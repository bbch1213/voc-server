package com.board.api.common.helper.jwt;

import com.board.api.account.entity.Account;
import com.board.api.account.enumerate.AccountRole;
import com.board.api.account.repository.AccountRepository;
import com.board.api.common.helper.exception.AuthenticationException;
import com.board.api.role.entity.Role;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Component
public class JwtTokenProvider {

    @Value("${spring.jwt.secret}")
    private String secretKey;

    // 토큰 유효기간 60분
    private long tokenValidTime = 1000L * 60 * 60;

    private final AccountRepository accountRepository;

    @PostConstruct
    protected void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // 토큰 생성
    public String createToken(String userId, List<Role> roles) {
        Claims claims = Jwts.claims().setSubject(userId);
        claims.put("roles", getRole(roles));
        Date now = new Date();
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidTime))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }

    // 인증 정보 조회
    public Authentication getAuthentication(String token) {
        Account account = accountRepository.findByUserId(this.getUserId(token)).orElseThrow(AuthenticationException::new);
        return new UsernamePasswordAuthenticationToken(account, "", getRole(account.getRoles()));
    }

    // 회원 일련 번호 추출
    public String getUserId(String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
    }

    public List<? extends GrantedAuthority> getRole(List<Role> roles) {
        return Optional.ofNullable(roles).orElse(Collections.emptyList()).stream()
                .map    (role -> new SimpleGrantedAuthority(role.getRoleType().name()))
                .collect(Collectors.toList());
    }

    // Header 에서 token 추출
    public String resolveToken(HttpServletRequest req) {
        return req.getHeader("Authorization");
    }

    // 토큰 유효성 체크
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        }catch (Exception e) {
            return false;
        }
    }

}
