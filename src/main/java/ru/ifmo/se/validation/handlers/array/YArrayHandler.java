package ru.ifmo.se.validation.handlers.array;

import lombok.ToString;
import ru.ifmo.se.validation.abstractions.ArrayHandler;
import ru.ifmo.se.validation.request.ValidationRequest;

import java.math.BigDecimal;
import java.util.List;

/**
 * Класс для обработки валидатором значения поступившего Y.
 */
@ToString
public class YArrayHandler extends ArrayHandler {
    public YArrayHandler(List<BigDecimal> validationValues) {
        super(validationValues);
    }

    /**
     * Метод выполняет обработку переданного запроса на валидацию.
     *
     * @param request переданный запрос на валидацию.
     * @return статус выполнения обработки.
     */
    @Override
    public boolean handle(ValidationRequest request) {
        BigDecimal y = new BigDecimal(request.y());

        for (BigDecimal val: getValidationValues()) {
            if (y.compareTo(val) == 0) {
                return handleNext(request);
            }
        }

        return false;
    }
}
