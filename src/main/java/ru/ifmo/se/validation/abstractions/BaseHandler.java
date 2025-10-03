package ru.ifmo.se.validation.abstractions;

import lombok.Getter;

import java.math.BigDecimal;

/**
 * Абстрактный класс для упрощения создания конкретных обработчиков.
 */
public abstract class BaseHandler extends NullHandler {
    @Getter
    private final BigDecimal leftIncludingBorder;
    @Getter
    private final BigDecimal rightIncludingBorder;

    public BaseHandler(BigDecimal leftIncludingBorder, BigDecimal rightIncludingBorder) {
        this.leftIncludingBorder = leftIncludingBorder;
        this.rightIncludingBorder = rightIncludingBorder;
    }
}
