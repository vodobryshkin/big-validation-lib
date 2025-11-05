package ru.ifmo.se.validation.request;

import lombok.Data;

/**
 * Класс с данными для отправки на валидацию.
 * Получается в результате обработки поступивших данных парсером.
 */
@Data
public class ValidationRequest implements ValidationManagerOutRequest {
    private final String x;
    private final String y;
    private final String r;
}
