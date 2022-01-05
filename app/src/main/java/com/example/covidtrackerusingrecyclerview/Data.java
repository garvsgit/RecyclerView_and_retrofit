package com.example.covidtrackerusingrecyclerview;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Data {
    @SerializedName("tested")
    private List<Tested> testedList;

    public void setTestedList(List<Tested> testedList) {
        this.testedList = testedList;
    }

    public Data(List<Tested> testedList) {
        this.testedList = testedList;
    }

    public List<Tested> getTestedList() {
        return testedList;
    }
}
