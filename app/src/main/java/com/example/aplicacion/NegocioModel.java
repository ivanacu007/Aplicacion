package com.example.aplicacion;

public class NegocioModel {
    private String name, desc, location;
    private int img, phone, fav;
    private double lat,lon;

    public NegocioModel() {
    }

    public NegocioModel(String name, String desc, String location, int img, int phone, int fav, double lat, double lon) {
        this.name = name;
        this.desc = desc;
        this.location = location;
        this.img = img;
        this.phone = phone;
        this.fav = fav;
        this.lat = lat;
        this.lon = lon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public int getFav() {
        return fav;
    }

    public void setFav(int fav) {
        this.fav = fav;
    }

    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public void setLon(double lon) {
        this.lon = lon;
    }
}
