package com.album.sticker.service;

import com.album.sticker.controller.response.AlbumResponse;
import com.album.sticker.entity.Sticker;
import com.album.sticker.repository.StickerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class StickerService {

    @Autowired
    private StickerRepository repository;

    public Sticker getByCode(String code) {
        return repository.findByStickerCode(code);
    }

    public Sticker addSticker(Sticker sticker) {

        sticker.incrementQuantity();

        return repository.save(sticker);
    }

    public AlbumResponse getAlbumStats() {

        AlbumResponse albumResponse = new AlbumResponse();
        albumResponse.setDoubledStickers(repository.getTotalDoubledStickers());
        Long owned = repository.countByQuantityGreaterThan(0);
        Long total = repository.count();
        albumResponse.setTotalStickers(String.format("%d/%d", owned, total));
        albumResponse.setCompletionPercentage(String.format("%d%%", getCompletionPercentage(owned, total)));
        albumResponse.setPrefixTotals(
                repository.getStickersOwnedAndTotalForEachGroup()
                        .stream()
                        .map(t -> String.format("%s: %d/%d", t.getCode(), t.getOwned(), t.getTotal()))
                        .collect(Collectors.toList())
        );

        return albumResponse;
    }

    private Long getCompletionPercentage(Long owned, Long total) {

        return owned * 100 / total;
    }
}
