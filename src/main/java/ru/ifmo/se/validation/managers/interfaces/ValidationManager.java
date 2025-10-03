package ru.ifmo.se.validation.managers.interfaces;

import lombok.Getter;
import lombok.Setter;
import ru.ifmo.se.validation.abstractions.NullHandler;
import ru.ifmo.se.validation.request.ValidationRequest;

/**
 * Интерфейс для определения функциональности менеджеров для валидации.
 */
public abstract class ValidationManager {
    @Getter
    @Setter
    private NullHandler startHandler;

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
