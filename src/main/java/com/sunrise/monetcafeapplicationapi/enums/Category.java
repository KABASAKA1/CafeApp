package com.sunrise.monetcafeapplicationapi.enums;

import lombok.Getter;

@Getter
public enum Category {
    CIKOLATA_MUHALLEBI(MainCategory.TATLI),
    WAFFLE(MainCategory.TATLI),
    PANKEK(MainCategory.TATLI),
    LIMONATA(MainCategory.NULL),
    BUBBLE_TEA(MainCategory.NULL),
    SMOOTHIES(MainCategory.NULL),
    COCKTAILS(MainCategory.NULL),
    MILKSHAKE(MainCategory.NULL),
    EXPRESSO_BAZLI_SOGUK(MainCategory.KAHVE),
    EXPRESSO_BAZLI_SICAK(MainCategory.KAHVE),
    SICAK_ICECEKLER(MainCategory.NULL),
    MESRUBATLAR(MainCategory.NULL),
    CAYLAR(MainCategory.NULL),
    EXTRALAR(MainCategory.NULL),
    TURK_KAHVELERI(MainCategory.KAHVE),
    SPECIAL_ICECEKLER(MainCategory.NULL),
    GELENEKSEL_ICECEKLER(MainCategory.NULL);

    private final MainCategory mainCategory;

    Category(MainCategory mainCategory) {
        this.mainCategory = mainCategory;
    }
}
