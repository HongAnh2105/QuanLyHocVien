package com.example.baiktra.controller;

import com.example.baiktra.model.Chude;
import com.example.baiktra.service.Chudeservice;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Type;
import java.time.LocalDate;
@Service
public class Chudecontroll {
    @Autowired
    private Chudeservice chuDeSeviecs;
    @RequestMapping(value = "/themcd", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Chude addbv(@RequestBody String cd) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Chude cds = gson.fromJson(cd, Chude.class);
        return chuDeSeviecs.addcd(cds);
    }

    @RequestMapping(value = "/suacd", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Chude remakeloaibv(@RequestBody String cdsua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Chude cd = gson.fromJson(cdsua, Chude.class);
        return chuDeSeviecs.remakecd(cd);
    }

    @RequestMapping(value = "/xoacd", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removebv(@RequestParam int id) {
        chuDeSeviecs.removecd(id);

    }

    @RequestMapping(value = "/getcd", method = RequestMethod.GET)
    public Chude getkhoahoc(@RequestParam int id) {
        return chuDeSeviecs.getcd(id);
    }
}
