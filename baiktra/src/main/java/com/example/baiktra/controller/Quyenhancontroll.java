package com.example.baiktra.controller;

import com.example.baiktra.model.Quyenhan;
import com.example.baiktra.service.Quyenhanservice;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
public class Quyenhancontroll {
    @Autowired
    private Quyenhanservice quyenHanSeviecs;
    @RequestMapping(value = "/themquyenhan", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Quyenhan addkhoahoc(@RequestBody String qh) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Quyenhan khs = gson.fromJson(qh, Quyenhan.class);
        return quyenHanSeviecs.addquyenhan(khs);
    }

    @RequestMapping(value = "/suaquyenhan", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Quyenhan remakeloaikhoahoc(@RequestBody String qhsua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Quyenhan qh = gson.fromJson(qhsua, Quyenhan.class);
        return quyenHanSeviecs.remakekhoahoc(qh);
    }

    @RequestMapping(value = "/xoaquyenhan", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removequyenhan(@RequestParam int id) {
        quyenHanSeviecs.removequyenhan(id);
    }

    @RequestMapping(value = "/getquyenhan", method = RequestMethod.GET)
    public Quyenhan getquyenhan(@RequestParam int id) {
        return quyenHanSeviecs.getquyenhan(id);
    }
}
