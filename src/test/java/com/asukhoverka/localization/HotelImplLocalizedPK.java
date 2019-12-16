package com.asukhoverka.localization;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;


@Embeddable
public class HotelImplLocalizedPK implements Serializable {

    @Column(name = "asset_id")
    private Long id;
    private String locale;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof HotelImplLocalizedPK)) return false;
        HotelImplLocalizedPK that = (HotelImplLocalizedPK) o;
        return Objects.equals(getId(), that.getId()) &&
                Objects.equals(getLocale(), that.getLocale());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getLocale());
    }
}
