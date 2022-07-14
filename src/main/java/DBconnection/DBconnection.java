package DBconnection;

import models.Plane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBconnection {
    private Connection connection;

    public DBconnection(){
        try {
            connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost/airport_management",
                    "root",
                    "");
            System.out.println("Thanh cong n");
        } catch (SQLException e) {
            connection = null;
            System.out.println(e);
        }
    }

    public ArrayList<Plane> getPlanes(){
        ArrayList<Plane> list = new ArrayList<>();
        String sql = "SELECT * FROM planes";
        try {
            ResultSet results = connection.prepareStatement(sql).executeQuery();
            while (results.next()){
                Plane plane = new Plane(
                        results.getString("id"),
                        results.getString("name"),
                        results.getString("manufacturer"),
                        results.getInt("year_of_manufacture"),
                        results.getInt("number_of_seats"),
                        results.getString("type"),
                        results.getString("status"),
                        results.getFloat("price")
                );
                list.add(plane);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

    public void addPlane(Plane plane){
        String sql = "INSERT INTO planes(id,name,manufacturer,year_of_manufacture,number_of_seats,type,status,price) VALUES ("+"'" + plane.getId() +"'" + ",'" + plane.getName()+"','" + plane.getManufacturer()+"',"+plane.getYearOfManufacture()+","+ plane.getNumber_of_seats()+",'"+plane.getType()+"','"+plane.getStatus()+"',"+plane.getPrice()+")";
        System.out.println(sql);
        try{
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void updatePlane( String status, String id){
        String sql="UPDATE planes SET status='"+status+"' WHERE id= '"+id+"'";
        System.out.println(sql);
        try{
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }

    public void deletePlane(String id){
        String sql = "DELETE FROM planes WHERE id = '"+ id+"'";
        try {
            connection.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public ArrayList<Plane> getPlanesByManufacturer(String manufacturer){
        ArrayList<Plane> planelist = new ArrayList<>();
        String sql = "SELECT * FROM planes WHERE manufacturer = '"+ manufacturer+"'";
        try {
            ResultSet results = connection.prepareStatement(sql).executeQuery();
            while (results.next()){
                Plane plane1 = new Plane(
                        results.getString("id"),
                        results.getString("name"),
                        results.getString("manufacturer"),
                        results.getInt("year_of_manufacture"),
                        results.getInt("number_of_seats"),
                        results.getString("type"),
                        results.getString("status"),
                        results.getFloat("price")
                );
                planelist.add(plane1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return planelist;
    }
    public int getTotalPlanes(){
        String sql = "SELECT COUNT(id) AS 'total' FROM planes;";
        int total = 0;
        try {
            ResultSet results = connection.prepareStatement(sql).executeQuery();
            results.next();
            total = results.getInt("total");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return total;
    }

    public int getTotalPlanesByStatus(String status){
        String sql = "SELECT COUNT(id) AS 'total' FROM planes WHERE status = '"+ status +"'";
        int totalStatus = 0;
        try {
            ResultSet results = connection.prepareStatement(sql).executeQuery();
            results.next();
            totalStatus = results.getInt("total");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return totalStatus;
    }
}
