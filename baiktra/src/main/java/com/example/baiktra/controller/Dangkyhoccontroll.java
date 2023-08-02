package com.example.baiktra.controller;

import com.example.baiktra.model.Dangkyhoc;
import com.example.baiktra.service.Dangkyhocservice;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController
public class Dangkyhoccontroll {

    @Autowired
    private Dangkyhocservice dangKyhocSeviecs;
    @RequestMapping(value = "/themdk", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Dangkyhoc adddk(@RequestBody String dk) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Dangkyhoc dks = gson.fromJson(dk, Dangkyhoc.class);
        return dangKyhocSeviecs.adddk(dks);
    }

    @RequestMapping(value = "/suadk", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Dangkyhoc remakedk(@RequestBody String dksua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Dangkyhoc dk = gson.fromJson(dksua, Dangkyhoc.class);
        return dangKyhocSeviecs.remakedk(dk);
    }

    @RequestMapping(value = "/xoadk", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removedk(@RequestParam int id) {
        dangKyhocSeviecs.removdk(id);
    }

    @RequestMapping(value = "/gedk", method = RequestMethod.GET)
    public Dangkyhoc getdk(@RequestParam int id) {
        return dangKyhocSeviecs.getdk(id);
    }
}
