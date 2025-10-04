package ru.ifmo.se.validation.handlers.full;

import ru.ifmo.se.validation.request.ValidationRequest;
import ru.ifmo.se.validation.abstractions.BaseHandler;

import java.math.BigDecimal;

/**
 * Класс для обработки валидатором значения поступившего R.
 */
public class RHandler extends BaseHandler {
    public RHandler(BigDecimal leftIncludingBorder, BigDecimal rightIncludingBorder) {
        super(leftIncludingBorder, rightIncludingBorder);
    }

    /**
     * Метод выполняет обработку значения R из переданного запроса на валидацию.
     * Если метод удовлетворяет условию, то происходит переход на следующий обработчик.
     * В противном случае, возвращается false (завершилось неправильно).
     *
     * @param request переданный запрос на валидацию.
     * @return статус выполнения обработки.
     */
    @Override
    public boolean handle(ValidationRequest request) {
        try {
            BigDecimal r = new BigDecimal(request.r());

            if (r.compareTo(getLeftIncludingBorder()) >= 0
                    && r.compareTo(getRightIncludingBorder()) <= 0) {
                return handleNext(request);
            }

            return false;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
