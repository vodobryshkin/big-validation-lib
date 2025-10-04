package ru.ifmo.se.validation.managers;

import ru.ifmo.se.validation.abstractions.NullHandler;
import ru.ifmo.se.validation.handlers.isnumber.XIsNumberHandler;
import ru.ifmo.se.validation.handlers.isnumber.YIsNumberHandler;
import ru.ifmo.se.validation.managers.interfaces.ValidationManager;
import ru.ifmo.se.validation.parser.CoordinatesBordersParser;

import java.io.IOException;
import java.util.List;

public class ValidationRManager extends ValidationManager {
    public ValidationRManager(String configName) throws IOException {
        List<NullHandler> baseHandlers = new CoordinatesBordersParser().parse(configName);
        XIsNumberHandler xIsNumberHandler = new XIsNumberHandler();
        YIsNumberHandler yIsNumberHandler = new YIsNumberHandler();

        xIsNumberHandler.setNext(yIsNumberHandler);
        yIsNumberHandler.setNext(baseHandlers.get(2));

        setStartHandler(xIsNumberHandler);
    }
}
