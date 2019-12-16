package com.asukhoverka.localization;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class HotelImpl implements Serializable {

    private Long id;
    private String code;
//    private Map<String, HotelImplLocalized> localized = new HashMap<>();

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return this.id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return this.code;
    }


    /*public Map<String, HotelImplLocalized> getLocalized() {
        return localized;
    }

    public void setLocalized(Map<String, HotelImplLocalized> localized) {
        this.localized = localized;
    }*/
}
