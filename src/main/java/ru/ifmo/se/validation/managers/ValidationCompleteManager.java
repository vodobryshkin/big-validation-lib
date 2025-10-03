package ru.ifmo.se.validation.managers;

import ru.ifmo.se.validation.abstractions.NullHandler;
import ru.ifmo.se.validation.managers.interfaces.ValidationManager;
import ru.ifmo.se.validation.parser.CoordinatesBordersParser;

import java.io.IOException;
import java.util.List;

/**
 * Класс для валидации поступивших значений.
 */
public class ValidationCompleteManager extends ValidationManager {
    /**
     * Конструктор класса ValidationCompleteManager.
     * В нём создаются все необходимые обработчики и строится цепочка ответственностей.
     */
    public ValidationCompleteManager(String configName) throws IOException {
        List<NullHandler> baseHandlers = new CoordinatesBordersParser().parse(configName);

        baseHandlers.get(0).setNext(baseHandlers.get(1));
        baseHandlers.get(1).setNext(baseHandlers.get(2));

        setStartHandler(baseHandlers.get(0));
    }
}
