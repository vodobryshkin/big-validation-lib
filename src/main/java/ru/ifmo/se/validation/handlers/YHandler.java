package ru.ifmo.se.validation.handlers;

import ru.ifmo.se.validation.request.ValidationRequest;
import ru.ifmo.se.validation.abstractions.BaseHandler;

import java.math.BigDecimal;

/**
 * Класс для обработки валидатором значения поступившего Y.
 */
public class YHandler extends BaseHandler {
    public YHandler(BigDecimal leftIncludingBorder, BigDecimal rightIncludingBorder) {
        super(leftIncludingBorder, rightIncludingBorder);
    }

    /**
     * Метод выполняет обработку значения Y из переданного запроса на валидацию.
     * Если метод удовлетворяет условию, то происходит переход на следующий обработчик.
     * В противном случае, возвращается false (завершилось неправильно).
     *
     * @param request переданный запрос на валидацию.
     * @return статус выполнения обработки.
     */
    @Override
    public boolean handle(ValidationRequest request) {
        try {
            BigDecimal y = new BigDecimal(request.y());

            if (y.compareTo(getLeftIncludingBorder()) >= 0
                    && y.compareTo(getRightIncludingBorder()) <= 0) {
                return handleNext(request);
            }

            return false;
        } catch (NumberFormatException e) {
            return false;
        }

    }
}
