package com.example.baiktra.controller;

import com.example.baiktra.model.Hocvien;
import com.example.baiktra.service.Hocvienservice;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class Hocviencontroll {
    @Autowired
    private Hocvienservice hocVienSeviecs;
    @RequestMapping(value = "/them1hocvien", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Hocvien addhocvien(@RequestBody String hv) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Hocvien hvs = gson.fromJson(hv, Hocvien.class);
        return hocVienSeviecs.addhocvien(hvs);
    }
    @RequestMapping(value = "/suahocvien", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Hocvien remakehocvien(@RequestBody String hvsua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Hocvien hv = gson.fromJson(hvsua, Hocvien.class);
        return hocVienSeviecs.remakehocvien(hv);
    }
    @RequestMapping(value = "/xoahocvien", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removekhoahoc(@RequestParam int id) {
        hocVienSeviecs.removhocvien(id);
    }
    @RequestMapping(value = "/gethocvien", method = RequestMethod.GET)
    public Hocvien gethocvien(@RequestParam int id) {
        return hocVienSeviecs.gethocvien(id);
    }
    @RequestMapping(value = "/timhocvien", method = RequestMethod.GET)
    public List<Hocvien> timkiem(@RequestParam String ten, String email){
        return hocVienSeviecs.timkiem(ten,email);
    }

}
