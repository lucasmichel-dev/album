package com.album.sticker.controller.response;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class AlbumResponse implements Serializable {

    private Long doubledStickers;
    private String totalStickers;
    private String completionPercentage;
    private List<String> prefixTotals;
}
