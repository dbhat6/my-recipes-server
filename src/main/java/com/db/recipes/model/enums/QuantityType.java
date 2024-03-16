package com.db.recipes.model.enums;

public enum QuantityType {
    TABLESPOON("TABLESPOON"),
    TEASPOON("TEASPOON"),
    PACKET("PACKET"),
    CUP("CUP"),
    NUMBER("NUMBER");

    private String quantityType;

    QuantityType(String quantityType) {
        this.quantityType = quantityType;
    }
}
