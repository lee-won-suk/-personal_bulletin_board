package com.toffee.nuts.bulletinboard.util;

import org.springframework.expression.ExpressionException;

import java.util.Arrays;

public enum BoardCategory {
    NORMAL("NORMAL","1"),
    SPORTS("SPORTS","2"),
    STYLE("STYLE","3"),
    FUN("FUN","4"),
    ;


    private String categoryName;
    private String code;

    BoardCategory(String categoryName, String code) {
        this.categoryName = categoryName;
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }

    public static BoardCategory getEnum(String code) {
        return Arrays.stream(BoardCategory.values())
                .filter(v -> v.getCode().equals(code))
                .findAny()
                .orElseThrow(()-> new ExpressionException("enum값으로 변환 실패"));
    }
}
