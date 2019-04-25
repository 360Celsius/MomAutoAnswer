package com.celsius.mom.pojos;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TopLevelDomains {

    @SerializedName("topLevelDomain")
    @Expose
    String topLevelDomain;


    public TopLevelDomains(String name) {
        this.topLevelDomain = name;
    }

    public String getTopLevelDomains() {
        return topLevelDomain;
    }

    public void setTopLevelDomains(String name) {
        this.topLevelDomain = name;
    }
}
