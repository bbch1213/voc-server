package com.board.api.common.base;

import com.board.api.account.entity.Account;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class Base {

    @CreatedDate
    @Column(name="created_at", updatable=false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name="updated_at", insertable=false)
    private LocalDateTime updatedAt;

    @CreatedBy
    @JoinColumn(name="created_by", updatable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Account createdBy;

    @LastModifiedBy
    @JoinColumn(name="updated_by", insertable = false)
    @ManyToOne(fetch = FetchType.LAZY)
    private Account updatedBy;

}
