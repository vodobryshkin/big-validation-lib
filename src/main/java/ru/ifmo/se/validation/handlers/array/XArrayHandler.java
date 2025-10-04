package ru.ifmo.se.validation.handlers.array;

import lombok.ToString;
import ru.ifmo.se.validation.abstractions.ArrayHandler;
import ru.ifmo.se.validation.request.ValidationRequest;

import java.math.BigDecimal;
import java.util.List;

/**
 * Класс для обработки валидатором значения поступившего X (по массиву).
 */
@ToString
public class XArrayHandler extends ArrayHandler {
    public XArrayHandler(List<BigDecimal> validationValues) {
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
        BigDecimal x = new BigDecimal(request.x());

        for (BigDecimal val: getValidationValues()) {
            if (x.compareTo(val) == 0) {
                return handleNext(request);
            }
        }

        return false;
    }
}
