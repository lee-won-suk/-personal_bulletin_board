package com.toffee.nuts.bulletinboard.util;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BoardUpdateRequest {
    private String title;
    private String content;
    private BoardCategory category;
}
