package ru.ifmo.se.validation.handlers;

import lombok.ToString;
import ru.ifmo.se.validation.abstractions.ArrayHandler;
import ru.ifmo.se.validation.request.ValidationRequest;

import java.math.BigDecimal;
import java.util.List;

/**
 * Класс для обработки валидатором значения поступившего R.
 */
@ToString
public class RArrayHandler extends ArrayHandler {
    public RArrayHandler(List<BigDecimal> validationValues) {
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
        BigDecimal r = new BigDecimal(request.r());

        for (BigDecimal val: getValidationValues()) {
            if (r.equals(val)) {
                return true;
            }
        }

        return false;
    }
}
