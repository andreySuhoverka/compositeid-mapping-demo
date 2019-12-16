package com.asukhoverka.localization;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;


@Entity(name = "HotelImplLocalized")
@Table(name = "asset_localized")
public class HotelImplLocalized implements Serializable {

    @ManyToOne
    @MapsId("asset_id")
    @JoinColumn(name = "asset_id")
    private HotelImpl asset;

    @EmbeddedId
    private HotelImplLocalizedPK hotelImplLocalizedPK = new HotelImplLocalizedPK();
    @Column
    private String address;

    public HotelImpl getAsset() {
        return asset;
    }

    public void setAsset(HotelImpl asset) {
        this.asset = asset;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public HotelImplLocalizedPK getHotelImplLocalizedPK() {
        return hotelImplLocalizedPK;
    }

    public void setHotelImplLocalizedPK(HotelImplLocalizedPK hotelImplLocalizedPK) {
        this.hotelImplLocalizedPK = hotelImplLocalizedPK;
    }

}
