package com.board.api.voc.predicate;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.board.api.voc.entity.QVoc;

public class VocPredicate {

    public static Predicate searchToUserId(String userId) {
        QVoc voc = QVoc.voc;
        BooleanBuilder builder = new BooleanBuilder();

        builder.and(voc.user.userId.eq(userId));

        return builder;
    }
}
