package com.example.baiktra.controller;

import com.example.baiktra.model.Khoahoc;
import com.example.baiktra.service.Khoahocservice;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class Khoahoccontroll {
    @Autowired
    private Khoahocservice khoaHocSeviecs;

    @RequestMapping(value = "/them1khoahoc", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Khoahoc addkhoahoc(@RequestBody String kh) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Khoahoc khs = gson.fromJson(kh, Khoahoc.class);
        return khoaHocSeviecs.addkhoahoc(khs);
    }

    @RequestMapping(value = "/suakhoahoc", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Khoahoc remakeloaikhoahoc(@RequestBody String khsua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Khoahoc kh = gson.fromJson(khsua, Khoahoc.class);
        return khoaHocSeviecs.remakekhoahoc(kh);
    }

    @RequestMapping(value = "/xoa1khoahoc", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removekhoahoc(@RequestParam int id) {
        khoaHocSeviecs.removekhoahoc(id);
    }

    @RequestMapping(value = "/getkhoahoc", method = RequestMethod.GET)
    public Khoahoc getkhoahoc(@RequestParam int id) {
        return khoaHocSeviecs.getkhoahoc(id);
    }
    @RequestMapping(value = "/timkhoahoc", method = RequestMethod.GET)
    public List<Khoahoc> timkiem(@RequestParam String hoten){
        return khoaHocSeviecs.timkiem(hoten);
    }
    @RequestMapping(value = "/phantrang",method =RequestMethod.GET)
    public List<Khoahoc> getKhoaHocByPage(@RequestParam int pageNumber,@RequestParam int pageSize){
        return khoaHocSeviecs.getKhoaHocByPage(pageNumber,pageSize);
    }
}
