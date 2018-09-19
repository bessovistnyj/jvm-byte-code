package ru.napadovskiu.storage;

import com.google.gson.*;
import ru.napadovskiu.entities.Item;

import java.lang.reflect.Type;

public class ItemsConverter implements JsonSerializer<Item>, JsonDeserializer<Item> {


    @Override
    public Item deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        return null;
    }

    @Override
    public JsonElement serialize(Item item, Type type, JsonSerializationContext jsonSerializationContext) {
        JsonObject object = new JsonObject();
            object.addProperty("car", item.getCar().getCarName());
            object.addProperty("transmission", item.getCar().getTransmission().getTransName());
            object.addProperty("engine", item.getCar().getTransmission().getTransName());
            object.addProperty("gearBox", item.getCar().getTransmission().getTransName());
            object.addProperty("closed", item.getCar().getTransmission().getTransName());
            object.addProperty("date", item.getCar().getTransmission().getTransName());
            //object.addProperty("date", item.getCar().getTransmission().getTransName());
        return object;
    }
}
