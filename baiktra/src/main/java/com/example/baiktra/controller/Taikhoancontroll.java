package com.example.baiktra.controller;

import com.example.baiktra.model.Taikhoan;
import com.example.baiktra.service.Taikhoanservice;
import com.google.gson.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.List;

@RestController
public class Taikhoancontroll {


    @Autowired
    private Taikhoanservice taiKhoanSeviecs;
    @RequestMapping(value = "/themtk", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public Taikhoan addkhoahoc(@RequestBody String tk) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Taikhoan tks = gson.fromJson(tk, Taikhoan.class);
        return taiKhoanSeviecs.addtaikhoan(tks);
    }

    @RequestMapping(value = "/suatk", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public Taikhoan remakeloaikhoahoc(@RequestBody String tksua) {
        Gson gson = new GsonBuilder().registerTypeAdapter(LocalDate.class, new JsonDeserializer<LocalDate>() {
            @Override
            public LocalDate deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
                return LocalDate.parse(jsonElement.getAsJsonPrimitive().getAsString());
            }
        }).create();
        Taikhoan tk = gson.fromJson(tksua,Taikhoan.class);
        return taiKhoanSeviecs.remaketaikhoan(tk);
    }

    @RequestMapping(value = "/xoatk", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public void removetk(@RequestParam int id) {
        taiKhoanSeviecs.removetaikhoan(id);
    }

    @RequestMapping(value = "/gettk", method = RequestMethod.GET)
    public Taikhoan gettaikhoan(@RequestParam int id) {
        return taiKhoanSeviecs.gettaikhoan(id);
    }
    @RequestMapping(value = "/timtk", method = RequestMethod.GET)
    public List<Taikhoan> timkiem(@RequestParam String tk){
        return taiKhoanSeviecs.timkiemtk(tk);
    }

}
