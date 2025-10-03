package ru.ifmo.se.validation.parser;

import ru.ifmo.se.validation.abstractions.NullHandler;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для парсинга конфигурации к создаваемым обработчикам.
 */
public class CoordinatesBordersParser {
    /**
     * Метод для парсинга конфигурации для создания обработчиков.
     *
     * @param configName путь к файлу конфигурации
     * @return созданный
     */
    public List<NullHandler> parse(String configName) throws IOException {
        String json = Files.readString(Path.of(configName));

        List<NullHandler> handlers = new ArrayList<>();

        NullHandler xHandler = new XCoordinateParser(json).parse();
        NullHandler yHandler = new YCoordinateParser(json).parse();
        NullHandler rHandler = new RCoordinateParser(json).parse();

        handlers.add(xHandler);
        handlers.add(yHandler);
        handlers.add(rHandler);

        return handlers;
    }
}
