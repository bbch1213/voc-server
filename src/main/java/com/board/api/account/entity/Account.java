package com.board.api.account.entity;

import com.board.api.common.base.Base;
import com.board.api.role.entity.Role;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Account extends Base {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String userId;

    @Column(nullable = false, length = 100)
    private String password;

    @Column(nullable = false, length = 30)
    private String name;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinTable(name="account_role", joinColumns=@JoinColumn(name="account_id"), inverseJoinColumns=@JoinColumn(name="role_id"))
    private List<Role> roles;
}
