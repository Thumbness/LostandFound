package sevenone.lostandfound.model;

import java.util.Date;

public class Item {

    private String lost;
    private String name, description, location;
    private String phone;
    private Integer id;
    private String date;

    public Item(String lost, String name, String description, String location, String phone, String date) {
        this.lost = lost;
        this.name = name;
        this.description = description;
        this.location = location;
        this.phone = phone;
        this.date = date;
    }
    public Item()
    {

    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLost() {
        return lost;
    }

    public void setLost(String lost) {
        this.lost = lost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
