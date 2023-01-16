package com.toffee.nuts.bulletinboard.util;

import com.toffee.nuts.bulletinboard.entity.BoardEntity;
import jakarta.persistence.AttributeConverter;

public class BoardEntityConverter implements AttributeConverter<BoardCategory, String> {

    @Override
    public String convertToDatabaseColumn(BoardCategory attribute) {
        return attribute.getCode();
    }

    @Override
    public BoardCategory convertToEntityAttribute(String dbData) {
        return BoardCategory.getEnum(dbData);
    }
}
