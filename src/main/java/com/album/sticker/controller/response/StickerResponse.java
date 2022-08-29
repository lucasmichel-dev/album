package com.album.sticker.controller.response;

import lombok.Data;

import java.io.Serializable;

@Data
public class StickerResponse implements Serializable {

    private String code;
    private Integer quantity;
}
