package com.weather.project.weather;

public class Constants {
        private Double Temperature;
        private  String main;
        private String desc;
        private Double humid;
        private String city;
        private String[] temp;
        private String[] multi_main;
    public Constants(Double temperature, String main, String desc, Double humid, String city) {
        Temperature = temperature;
        this.main = main;
        this.desc = desc;
        this.humid = humid;
        this.city = city;
    }

    public Constants(String[] temp,String[] multi_main) {
        this.temp = temp;
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

    public String[] getTemp() {
        return temp;
    }

    public String[] getMulti_main() {
        return multi_main;
    }
}

