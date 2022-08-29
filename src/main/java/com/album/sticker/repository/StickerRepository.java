package com.album.sticker.repository;

import com.album.sticker.entity.Sticker;
import com.album.sticker.model.PrefixTotal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StickerRepository extends JpaRepository<Sticker, Integer> {

    @Query("select s from Sticker s where concat(trim(code), trim(number)) = upper(?1)")
    Sticker findByStickerCode(String stickerCode);

    Long countByQuantityGreaterThan(Integer quantity);

    @Query("select sum(quantity) from Sticker s where quantity > 0")
    Long sumQuantity();

    @Query("select sum(quantity - 1) from Sticker s where quantity > 1 order by code, number")
    Long getTotalDoubledStickers();

    @Query("select new com.album.sticker.model.PrefixTotal(code, count(*) as total, (select count(*) from Sticker s2 where s2.code = s.code and s2.quantity > 0) as owned) from Sticker s group by code")
    List<PrefixTotal> getStickersOwnedAndTotalForEachGroup();
}
