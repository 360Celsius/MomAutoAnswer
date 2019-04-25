package com.celsius.mom.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountriesDataResponce {

    @SerializedName("name")
    @Expose
    String name;

    @SerializedName("topLevelDomain")
    @Expose
    List<String> topLevelDomain;


    public CountriesDataResponce(String name,List<String> topLevelDomain) {
        this.name = name;
        this.topLevelDomain = topLevelDomain;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getTopLevelDomain() {
        return topLevelDomain;
    }

    public void setTopLevelDomain(List<String> topLevelDomain) {
        this.topLevelDomain = topLevelDomain;
    }
}
