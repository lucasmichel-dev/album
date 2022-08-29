package com.album.sticker.entity;

import com.album.sticker.controller.response.StickerResponse;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Sticker {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String code;
    private Integer number;
    private Integer quantity;

    public void incrementQuantity() {
        quantity += 1;
    }

    public StickerResponse toResponse() {

        StickerResponse response = new StickerResponse();
        response.setCode(code + number);
        response.setQuantity(quantity);

        return response;
    }

    public String toString() {
        return code + number;
    }
}
