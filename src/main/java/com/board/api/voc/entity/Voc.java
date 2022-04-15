package com.board.api.voc.entity;

import com.board.api.account.entity.Account;
import com.board.api.voc.enumerate.VocStatus;
import com.board.api.common.base.Base;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Voc extends Base {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false, length = 300)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 30 ,columnDefinition = "varchar(30) default 'NO_MANAGER'")
    private VocStatus vocStatus = VocStatus.NO_MANAGER;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "admin_id")
    private Account admin;
}
