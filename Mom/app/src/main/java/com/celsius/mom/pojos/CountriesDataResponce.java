package com.celsius.mom.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountriesDataResponce {

    @SerializedName("alpha2Code")
    @Expose
    String alpha2Code;

    @SerializedName("flag")
    @Expose
    String flag;

    @SerializedName("callingCodes")
    @Expose
    List<String> callingCodes;

    public CountriesDataResponce(String alpha2Code, String flag, List<String> callingCodes) {
        this.alpha2Code = alpha2Code;
        this.flag = flag;
        this.callingCodes = callingCodes;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public List<String> getCallingCodes() {
        return callingCodes;
    }

    public void setCallingCodes(List<String> callingCodes) {
        this.callingCodes = callingCodes;
    }
}
