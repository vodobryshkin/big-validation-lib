package ru.ifmo.se.validation.handlers.full;

import ru.ifmo.se.validation.request.ValidationRequest;
import ru.ifmo.se.validation.abstractions.BaseHandler;

import java.math.BigDecimal;

/**
 * Класс для обработки валидатором значения поступившего X.
 */
public class XHandler extends BaseHandler {
    public XHandler(BigDecimal leftIncludingBorder, BigDecimal rightIncludingBorder) {
        super(leftIncludingBorder, rightIncludingBorder);
    }

    /**
     * Метод выполняет обработку значения X из переданного запроса на валидацию.
     * Если метод удовлетворяет условию, то происходит переход на следующий обработчик.
     * В противном случае, возвращается false (завершилось неправильно).
     *
     * @param request переданный запрос на валидацию.
     * @return статус выполнения обработки.
     */
    @Override
    public boolean handle(ValidationRequest request) {
        try {
            BigDecimal x = new BigDecimal(request.getX());

            if (x.compareTo(getLeftIncludingBorder()) >= 0
                    && x.compareTo(getRightIncludingBorder()) <= 0) {
                return handleNext(request);
            }

            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
