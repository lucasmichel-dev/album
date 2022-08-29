package com.album.sticker.controller;

import com.album.sticker.controller.response.AlbumResponse;
import com.album.sticker.service.StickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("album")
public class AlbumController {

    @Autowired
    private StickerService stickerService;

    @GetMapping("stats")
    public ResponseEntity<AlbumResponse> getAlbumStats() {
        return ResponseEntity.status(HttpStatus.OK).body(stickerService.getAlbumStats());
    }

}
