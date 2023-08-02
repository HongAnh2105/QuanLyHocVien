package com.example.baiktra.controller;

import com.example.baiktra.model.Loaikhoahoc;
import com.example.baiktra.service.Loaikhoahocservice;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;

@RestController

public class Loaikhoahoccontroll {
    @Autowired
    private Loaikhoahocservice loaiKhoahocSeviecs;
    @RequestMapping(value = "/them1loaikhoahoc", method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    public Loaikhoahoc addloaikhoahoc(@RequestBody String lkh) {
        Gson gson=new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Loaikhoahoc lkhs = gson.fromJson(lkh,Loaikhoahoc.class);
        return loaiKhoahocSeviecs.addloaikhoahoc(lkhs);
    }
    @RequestMapping(value = "/sualoaikhoahoc", method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    public Loaikhoahoc remakeloaikhoahoc(@RequestBody String lkhsua){
        Gson gson=new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Loaikhoahoc lkh=gson.fromJson(lkhsua,Loaikhoahoc.class);
        return loaiKhoahocSeviecs.remakeloaikhoahoc(lkh);
    }
    @RequestMapping(value = "/xoa1loaikhoahoc", method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
    public void removeloaikhoahoc(@RequestParam int id) {
        loaiKhoahocSeviecs.removeloaikhoahoc(id);
    }
}
