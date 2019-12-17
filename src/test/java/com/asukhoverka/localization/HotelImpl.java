package com.asukhoverka.localization;


import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MapKey;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "asset")
public class HotelImpl implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(length = 5)
    private String code;

    @OneToMany(mappedBy = "asset", cascade = {CascadeType.ALL}, orphanRemoval = true)
    @MapKey(name = "hotelImplLocalizedPK.locale")
    private Map<String, HotelImplLocalized> localized = new HashMap<>();

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


    public Map<String, HotelImplLocalized> getLocalized() {
        return localized;
    }

    public void setLocalized(Map<String, HotelImplLocalized> localized) {
        this.localized = localized;
    }
}
