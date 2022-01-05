package com.example.covidtrackerusingrecyclerview;

public class Tested {
    private String testedasof;
    private  String totalindividualstested;
    private  String totalpositivecases;

    public Tested(String testedasof, String totalindividualstested, String totalpositivecases) {
        this.testedasof = testedasof;
        this.totalindividualstested = totalindividualstested;
        this.totalpositivecases = totalpositivecases;
    }

    public String getTestedasof() {
        return testedasof;
    }

    public String getTotalindividualstested() {
        return totalindividualstested;
    }

    public String getTotalpositivecases() {
        return totalpositivecases;
    }
}
