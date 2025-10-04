package ru.ifmo.se.validation.parser;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import lombok.AllArgsConstructor;
import lombok.Getter;
import ru.ifmo.se.validation.abstractions.NullHandler;
import ru.ifmo.se.validation.handlers.array.YArrayHandler;
import ru.ifmo.se.validation.handlers.full.YHandler;
import ru.ifmo.se.validation.parser.interfaces.CoordinateParser;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс для парсинга данных о координате X.
 */
@AllArgsConstructor
@Getter
public class YCoordinateParser implements CoordinateParser {
    private final String jsonData;
    /**
     * Метод для парсинга данных о координате в экземпляр Handler'а.
     *
     * @return созданный обработчик для координаты X в зависимости от данных в json.
     */
    @Override
    public NullHandler parse() {
        Gson gson = new Gson();
        JsonObject obj = gson.fromJson(jsonData, JsonObject.class);

        String yType = obj.get("yType").getAsString();

        if (yType.equals("including")) {
            JsonObject objX = obj.get("y").getAsJsonObject();
            BigDecimal yLeft = objX.get("leftIncludingBorder").getAsBigDecimal();
            BigDecimal yRight = objX.get("rightIncludingBorder").getAsBigDecimal();

            return new YHandler(yLeft, yRight);
        } else {
            JsonArray decimalList = obj.getAsJsonArray("y");

            List<BigDecimal> values = new ArrayList<>(decimalList.size());
            for (JsonElement e : decimalList) {
                if (e == null || e.isJsonNull()) continue;
                values.add(e.getAsBigDecimal());
            }

            return new YArrayHandler(values);
        }
    }
}
