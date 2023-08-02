package com.example.baiktra.controller;

import com.example.baiktra.model.Baiviet;
import com.example.baiktra.service.Baivietservice;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class Baivietcontroll {
@Autowired
private Baivietservice baiVietSeviecs;



    @RequestMapping(value = "/thembv", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Baiviet addbv(@RequestBody String bv) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Baiviet bvs = gson.fromJson(bv, Baiviet.class);
        return baiVietSeviecs.addbaiviet(bvs);
    }

    @RequestMapping(value = "/suabv", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Baiviet remakeloaibv(@RequestBody String bvsua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Baiviet bv = gson.fromJson(bvsua, Baiviet.class);
        return baiVietSeviecs.remakebaiviet(bv);
    }

    @RequestMapping(value = "/xoabv", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removebv(@RequestParam int id) {
        baiVietSeviecs.removebaiviet(id);
    }

    @RequestMapping(value = "/getbv", method = RequestMethod.GET)
    public Baiviet getkhoahoc(@RequestParam int id) {
        return baiVietSeviecs.getbaiviet(id);
    }
    @RequestMapping(value = "/timbv", method = RequestMethod.GET)
    public List<Baiviet> timkiem(@RequestParam String tenbv){
        return baiVietSeviecs.timkiem(tenbv);
    }
@RequestMapping(value = "/phantrangbv",method =RequestMethod.GET)
public List<Baiviet> getbaivietByPage(@RequestParam int pageNumber, @RequestParam int pageSize){
    return baiVietSeviecs.getbaivietByPage(pageNumber,pageSize);
}
}
