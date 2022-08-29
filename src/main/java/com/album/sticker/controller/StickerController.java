package com.album.sticker.controller;

import com.album.sticker.entity.Sticker;
import com.album.sticker.service.StickerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("sticker")
public class StickerController {

    @Autowired
    private StickerService stickerService;

    @GetMapping("{code}")
    public ResponseEntity<Object> getSticker(@PathVariable String code) {

        Sticker sticker = stickerService.getByCode(code);

        if (sticker == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sticker not found!");

        return ResponseEntity.status(HttpStatus.OK).body(sticker.toResponse());
    }

    @PostMapping("/add/{code}")
    public ResponseEntity<Object> addSticker(@PathVariable String code) {

        Sticker sticker = stickerService.getByCode(code);

        if (sticker == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Sticker not found!");

        sticker = stickerService.addSticker(sticker);

        return ResponseEntity.status(HttpStatus.CREATED).body(sticker.toResponse());
    }
}
