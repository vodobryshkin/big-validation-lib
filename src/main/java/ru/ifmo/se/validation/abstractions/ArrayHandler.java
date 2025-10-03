package ru.ifmo.se.validation.abstractions;

import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

/**
 * Абстрактный класс для упрощения создания конкретных обработчиков, основанных на выборке значений.
 */
public abstract class ArrayHandler extends NullHandler {
    @Getter
    private final List<BigDecimal> validationValues;

    public ArrayHandler(List<BigDecimal> validationValues) {
        this.validationValues = validationValues;
    }
}
