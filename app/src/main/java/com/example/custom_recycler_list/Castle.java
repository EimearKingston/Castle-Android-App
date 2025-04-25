package com.example.custom_recycler_list;

import java.io.Serializable;

//https://pastebin.com/nJ2udEfm
public class Castle implements Serializable {
    private String name, image, description, url, subtitle, province;
    private Integer year;
    private double latitude, longitude;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String subtitle) {
        this.province = province;
    }

    public double getLatitude() {
        return latitude; // Getter for latitude
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude; // Setter for latitude
    }

    public double getLongitude() {
        return longitude; // Getter for longitude
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude; // Setter for longitude
    }
    public void setYear(int year) {
        this.year = year;     }

    public int getYear() {
        return year;
    }


    public Castle(String name, String image, String description, String url, double latitude, double longitude, String subtitle, String province, int year) {
        this.name = name;
        this.image = image;
        this.description = description;
        this.url = url;
        this.latitude = latitude;
        this.longitude = longitude;
        this.subtitle = subtitle;
        this.province = province;
        this.year = year;
    }
}
