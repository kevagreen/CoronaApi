package com.tts.coronatracking.stats;

public class StateStats {
    private String state;
    private String country;
    private  int updatedCases;
    private String deaths;
    String recoveries;

    public StateStats(String state, String country, int updatedCases, String deaths, String recoveries) {
        this.state = state;
        this.country = country;
        this.updatedCases = updatedCases;
        this.deaths = deaths;
        this.recoveries = recoveries;
    }
    public StateStats(){

    }
    public StateStats(StateStats stats){

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getUpdatedCases() {
        return updatedCases;
    }

    public void setUpdatedCases(int updatedCases) {
        this.updatedCases = updatedCases;
    }

    public String getDeaths() {
        return deaths;
    }

    public void setDeaths(String deaths) {
        this.deaths = deaths;
    }

    public String getRecoveries() {
        return recoveries;
    }

    public void setRecoveries(String recoveries) {
        this.recoveries = recoveries;
    }

    @Override
    public String toString() {
        return "StateStats{" +
                "state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", updatedCases=" + updatedCases +
                ", deaths='" + deaths + '\'' +
                ", recoveries='" + recoveries + '\'' +
                '}';
    }
}
