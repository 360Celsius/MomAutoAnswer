package com.celsius.mom.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class CurrentCountryResponce {

    @SerializedName("countryCode")
    @Expose
    String countryCode;

    public CurrentCountryResponce(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }
}
