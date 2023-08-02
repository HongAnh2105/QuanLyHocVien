package com.example.baiktra.controller;

import com.example.baiktra.model.Tinhtranghoc;
import com.example.baiktra.service.Tinhtranghocservice;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Type;
import java.time.LocalDate;

public class Tinhtranghoccontroll {

    @Autowired
    private Tinhtranghocservice tthSeviecs;
    @RequestMapping(value = "/them1tinhtranghoc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Tinhtranghoc addtinhtranghoc(@RequestBody String th) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Tinhtranghoc tths = gson.fromJson(th, Tinhtranghoc.class);
        return tthSeviecs.addtinhtranghoc(tths);
    }

    @RequestMapping(value = "/suatinhtranghoc", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Tinhtranghoc remaketinhtranghoc(@RequestBody String thsua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Tinhtranghoc tths = gson.fromJson(thsua, Tinhtranghoc.class);
        return tthSeviecs.remaketinhtranghoc(tths);
    }

    @RequestMapping(value = "/xoatinhtranghoc", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removetinhtranghoc(@RequestParam int id) {
        tthSeviecs.removetinhtranghoc(id);
    }

    @RequestMapping(value = "/gettinhtranghoc", method = RequestMethod.GET)
    public Tinhtranghoc gettinhtranghoc(@RequestParam int id) {
        return tthSeviecs.gettinhtranghoc(id);
    }
}
