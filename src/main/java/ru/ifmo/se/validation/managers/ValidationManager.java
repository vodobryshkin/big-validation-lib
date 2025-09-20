package ru.ifmo.se.validation.managers;

import ru.ifmo.se.validation.abstractions.BaseHandler;
import ru.ifmo.se.validation.parser.CoordinatesBordersParser;
import ru.ifmo.se.validation.request.ValidationRequest;
import lombok.Getter;
import lombok.Setter;
import ru.ifmo.se.validation.abstractions.Handler;

import java.io.IOException;
import java.util.List;

/**
 * Класс для валидации поступивших значений.
 */
public class ValidationManager {
    @Getter
    @Setter
    private Handler startHandler;

    /**
     * Конструктор класса ValidationManager.
     * В нём создаются все необходимые обработчики и строится цепочка ответственностей.
     */
    public ValidationManager(String configName) throws IOException {
        List<BaseHandler> baseHandlers = new CoordinatesBordersParser().parse(configName);

        baseHandlers.get(0).setNext(baseHandlers.get(1));
        baseHandlers.get(1).setNext(baseHandlers.get(2));

        setStartHandler(baseHandlers.get(0));
    }

    /**
     * Метод для валидации поступившего запроса на валидацию по цепочке ответственностей.
     *
     * @param request поступивший запрос на валидацию.
     * @return ответ
     */
    public boolean validate(ValidationRequest request) {
        return getStartHandler().handle(request);
    }
}
