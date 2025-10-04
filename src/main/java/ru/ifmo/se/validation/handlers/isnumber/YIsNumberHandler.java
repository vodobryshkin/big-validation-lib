package ru.ifmo.se.validation.handlers.isnumber;

import ru.ifmo.se.validation.abstractions.NullHandler;
import ru.ifmo.se.validation.request.ValidationRequest;

import java.math.BigDecimal;

/**
 * Обработчик, который проверяет только то, что переменная X -- число.
 */
public class YIsNumberHandler extends NullHandler {
    @Override
    public boolean handle(ValidationRequest request) {
        try {
            new BigDecimal(request.y());

            return handleNext(request);
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
