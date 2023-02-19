package com.toffee.nuts.bulletinboard.util;

import jakarta.persistence.AttributeConverter;

public class BoardEntityConverter implements AttributeConverter<BoardCategory, String> {

    @Override
    public String convertToDatabaseColumn(BoardCategory category) {
        return category.getCode();
    }

    @Override
    public BoardCategory convertToEntityAttribute(String dbData) {
        return BoardCategory.getEnum(dbData);
    }
}
