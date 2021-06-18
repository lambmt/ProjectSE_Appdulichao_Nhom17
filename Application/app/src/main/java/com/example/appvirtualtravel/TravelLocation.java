package com.example.appvirtualtravel;

public class TravelLocation {
    public String image_link;
    public String location_id;
    public String location_name;
    public String province;
    public long starrating;

    public TravelLocation(){}

    public TravelLocation(String image_link, String location_id, String location_name, String province, long starrating) {
        this.image_link = image_link;
        this.location_id = location_id;
        this.location_name = location_name;
        this.province = province;
        this.starrating = starrating;
    }

    public String getImage_link() {
        return image_link;
    }

    public void setImage_link(String image_link) {
        this.image_link = image_link;
    }

    public String getLocation_id() {
        return location_id;
    }

    public void setLocation_id(String location_id) {
        this.location_id = location_id;
    }

    public String getLocation_name() {
        return location_name;
    }

    public void setLocation_name(String location_name) {
        this.location_name = location_name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public long getStarrating() {
        return starrating;
    }

    public void setStarrating(long starrating) {
        this.starrating = starrating;
    }
}
