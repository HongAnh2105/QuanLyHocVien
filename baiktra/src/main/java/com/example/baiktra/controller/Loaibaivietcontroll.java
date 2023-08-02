package com.example.baiktra.controller;

import com.example.baiktra.model.Loaibaiviet;
import com.example.baiktra.service.Loaibaivietservice;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class Loaibaivietcontroll {
    @Autowired
    private Loaibaivietservice loaiBaivietSeviecs;
    @RequestMapping(value = "/themlbv", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Loaibaiviet addlbv(@RequestBody String lbv) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Loaibaiviet lbvs = gson.fromJson(lbv, Loaibaiviet.class);
        return loaiBaivietSeviecs.addlbv(lbvs);
    }

    @RequestMapping(value = "/sualbv", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Loaibaiviet remakelbv(@RequestBody String lbvsua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Loaibaiviet lbv = gson.fromJson(lbvsua, Loaibaiviet.class);
        return loaiBaivietSeviecs.remakelbv(lbv);
    }

    @RequestMapping(value = "/xoalbv", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removekhoahoc(@RequestParam int id) {
        loaiBaivietSeviecs.removelbv(id);
    }

    @RequestMapping(value = "/getlbv", method = RequestMethod.GET)
    public Loaibaiviet getkhoahoc(@RequestParam int id) {
        return loaiBaivietSeviecs.getlbv(id);
    }

}
