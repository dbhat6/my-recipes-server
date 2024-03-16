package com.db.recipes.model;

import com.db.recipes.model.enums.QuantityType;
import lombok.Data;

@Data
public class Quantity {
    private int number;
    private QuantityType quantityType;
}
