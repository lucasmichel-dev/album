package com.album.sticker.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PrefixTotal {

    private String code;
    private Long total;
    private Long owned;
}
