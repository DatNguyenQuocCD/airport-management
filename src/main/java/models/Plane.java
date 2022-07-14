package models;

public class Plane {
    private String id;
    private String name;
    private String manufacturer;
    private int year_of_manufacture;
    private int number_of_seats;
    private String type;

    private String status;

    private Float price;

    public Plane(String id, String name, String manufacturer, int year_of_manufacture, int number_of_seats, String type, String status, Float price) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.year_of_manufacture = year_of_manufacture;
        this.number_of_seats = number_of_seats;
        this.type = type;
        this.status = status;
        this.price = price;
    }

    public String getId(){
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName(){
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer(){
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYearOfManufacture(){
        return year_of_manufacture;
    }

    public void setYear_of_manufacture(int year_of_manufacture) {
        this.year_of_manufacture = year_of_manufacture;
    }

    public int getNumber_of_seats(){
        return number_of_seats;
    }

    public void setNumber_of_seats(int number_of_seats) {
        this.number_of_seats = number_of_seats;
    }

    public String getType(){
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus(){
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getPrice(){return price;}

    public void setPrice(Float price) {
        this.price = price;
    }
}

