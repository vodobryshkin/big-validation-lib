package ru.ifmo.se.validation.parser;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import ru.ifmo.se.validation.abstractions.BaseHandler;
import ru.ifmo.se.validation.handlers.RHandler;
import ru.ifmo.se.validation.handlers.XHandler;
import ru.ifmo.se.validation.handlers.YHandler;

import java.io.IOException;
import java.math.BigDecimal;
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
    public List<BaseHandler> parse(String configName) throws IOException {
        String json = Files.readString(Path.of(configName));

        List<BaseHandler> baseHandlers = new ArrayList<>();

        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(json, JsonObject.class);

        JsonObject objX = obj.get("x").getAsJsonObject();
        JsonObject objY = obj.get("y").getAsJsonObject();
        JsonObject objR = obj.get("r").getAsJsonObject();

        BigDecimal xLeft = objX.get("leftIncludingBorder").getAsBigDecimal();
        BigDecimal xRight = objX.get("rightIncludingBorder").getAsBigDecimal();

        BigDecimal yLeft  = objY.get("leftIncludingBorder").getAsBigDecimal();
        BigDecimal yRight = objY.get("rightIncludingBorder").getAsBigDecimal();

        BigDecimal rLeft = objR.get("leftIncludingBorder").getAsBigDecimal();
        BigDecimal rRight = objR.get("rightIncludingBorder").getAsBigDecimal();

        BaseHandler xHandler = new XHandler(xLeft, xRight);
        BaseHandler yHandler = new YHandler(yLeft, yRight);
        BaseHandler rHandler = new RHandler(rLeft, rRight);

        baseHandlers.add(xHandler);
        baseHandlers.add(yHandler);
        baseHandlers.add(rHandler);

        return baseHandlers;
    }
}
