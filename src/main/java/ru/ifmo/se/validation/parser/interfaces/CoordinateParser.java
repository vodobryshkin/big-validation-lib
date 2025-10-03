package ru.ifmo.se.validation.parser.interfaces;

import ru.ifmo.se.validation.abstractions.Handler;

/**
 * Интерфейс для определения функциональности парсеров конкретных координат из конфигурационных файлов.
 */
public interface CoordinateParser {
    /**
     * Метод для парсинга данных о координате в экземпляр BaseHandler'а.
     *
     * @return созданный обработчик для конкретной координаты в зависимости от данных в json.
     */
    Handler parse();
}
