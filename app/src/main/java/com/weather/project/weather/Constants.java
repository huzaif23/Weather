package com.weather.project.weather;

public class Constants {
        private Double Temperature;
        private  String main;
        private String desc;
        private Double humid;
        private String city;
        private String[] dayTemp;
         private String[] nightTemp;
         private String[] eveTemp;
          private String[] mornTemp;
        private String[] multi_main;
    public Constants(Double temperature, String main, String desc, Double humid, String city) {
        Temperature = temperature;
        this.main = main;
        this.desc = desc;
        this.humid = humid;
        this.city = city;
    }

    public Constants(String[] dayTemp,String[] nightTemp,String[] eveTemp,String[] mornTemp,String[] multi_main) {
        this.dayTemp = dayTemp;
        this.nightTemp = nightTemp;
        this.eveTemp = eveTemp;
        this.mornTemp= mornTemp;
        this.multi_main = multi_main;
    }
    public Constants() {

    }

    public String getMain() {
        return main;
    }

    public String getDesc() {

        return desc;
    }

    public String getCity() {
        return city;
    }

    public Double getTemperature() {
        return Temperature;
    }

    public Double getHumid() {
        return humid;
    }

    public String[] getDayTemp() {
        return dayTemp;
    }

    public String[] getNightTemp() {
        return nightTemp;
    }

    public String[] getEveTemp() {
        return eveTemp;
    }

    public String[] getMornTemp() {
        return mornTemp;
    }

    public String[] getMulti_main() {
        return multi_main;
    }
}

