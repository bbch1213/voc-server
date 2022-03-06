package com.board.api.reply.entity;

import com.board.api.account.entity.Account;
import com.board.api.common.base.Base;
import com.board.api.voc.entity.Voc;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Reply extends Base {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false, length = 30)
    private String title;

    @Column(nullable = false, length = 300)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private Account user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "voc_id")
    private Voc voc;
}
