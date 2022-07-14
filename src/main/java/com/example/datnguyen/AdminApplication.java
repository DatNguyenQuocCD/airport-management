package com.example.datnguyen;

import DBconnection.DBconnection;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.Background;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.util.ArrayList;

import models.Plane;

public class AdminApplication extends Application {
    private Scene scene;
    private static final String EMPTY = "";
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) {
        DBconnection con = new DBconnection();
        GridPane grid = new GridPane();
        grid.setStyle("-fx-background-image: url(\"https://www.vietnamairlines.com/~/media/ContentImage/TravelInfo/ChuyenBayMoUoc.jpg?la=en\");-fx-background-size: cover;");
        grid.setAlignment(Pos.CENTER);
        grid.setVgap(15);
        grid.setHgap(20);
        ArrayList<Plane> planeList = con.getPlanes();
        int totalPlane = con.getTotalPlanes();
        int totalPlaneIsMaintained = con.getTotalPlanesByStatus("is maintained");
        int totalPlaneIsActive = con.getTotalPlanesByStatus("is active");
        int totalPlaneStopWorking = con.getTotalPlanesByStatus("stop working");

        VBox form = new VBox();
        form.setStyle("-fx-background-color:  #FFFFFF; -fx-padding: 50;");

        //InterFace
        var headerFromLeft1 = new Label("Form Add Plane");
        headerFromLeft1.setStyle("-fx-background-color:  #FFFFFF; -fx-padding: 5 15; -fx-font: normal bold 16px 'Arial'");
        grid.add(headerFromLeft1, 0, 0);
//
        var headerFromRight = new Label("");
        headerFromRight.setStyle("-fx-background-color:  #FFFFFF; -fx-padding:5 100; -fx-font: normal bold 20px 'serif'");
        grid.add(headerFromRight, 1, 0);

        var lID = new Label("ID");
        lID.setStyle("-fx-font: normal bold 16px 'Arial'");
        grid.add(lID, 0, 1);
        var tfID = new TextField();
//        tfID.setStyle("-fx-background-color:  #FFFFFF; -fx-padding: 5 130 5 15; -fx-font: normal bold 20px 'serif'");
        grid.add(tfID, 1, 1);
//        //
        var lName = new Label("Name");
        lName.setStyle("-fx-font: normal bold 16px 'Arial'");
        grid.add(lName, 0, 2);
        var tfName = new TextField();
        grid.add(tfName, 1, 2);
//        //
        var lManufacturer = new Label("Manufacturer");
        lManufacturer.setStyle("-fx-font: normal bold 16px 'Arial'");
        grid.add(lManufacturer, 0, 3);
        var tfManufacturer = new TextField();
        grid.add(tfManufacturer, 1, 3);
//        //
        var lYear_of_manufacture = new Label("Year Of Manufacture");
        lYear_of_manufacture.setStyle("-fx-font: normal bold 16px 'Arial'");
        grid.add(lYear_of_manufacture, 0, 4);
        var tfYear_of_manufacture = new TextField();
        grid.add(tfYear_of_manufacture, 1, 4);
//        //
        var lNumber_of_seats = new Label("Number Of Seats");
        lNumber_of_seats.setStyle("-fx-font: normal bold 16px 'Arial'");
        grid.add(lNumber_of_seats, 0, 5);
        var tfNumber_of_seats = new TextField();
        grid.add(tfNumber_of_seats, 1, 5);
//        //
        var lType = new Label("Type");
        lType.setStyle("-fx-font: normal bold 16px 'Arial'");
        grid.add(lType, 0, 6);
        var tfType = new TextField();
        grid.add(tfType, 1, 6);
//        //
        var lStatus = new Label("Status");
        lStatus.setStyle("-fx-font: normal bold 16px 'Arial'");
        grid.add(lStatus, 0, 7);
        var tfStatus = new TextField();
        grid.add(tfStatus, 1, 7);
//        //
        var lPrice = new Label("Price");
        lPrice.setStyle("-fx-font: normal bold 16px 'Arial'");
        grid.add(lPrice,0,  8);
        var tfPrice = new TextField();
        tfPrice.setPrefWidth(200);
        grid.add(tfPrice, 1, 8);
        grid.add(new Label("$"),2,  8);
//        //
//
        //show
        var lIdT = new Label("ID");
        lIdT.setStyle("-fx-font: normal bold 14px 'Arial'");
        grid.add(lIdT, 4, 1);
//        //
        var lNameT = new Label("Name");
        lNameT.setStyle("-fx-font: normal bold 14px 'Arial'");
        grid.add(lNameT, 5, 1);
//        //
        var lManufacturerT = new Label("Manufacturer");
        lManufacturerT.setStyle("-fx-font: normal bold 14px 'Arial'");
        grid.add(lManufacturerT, 6, 1);
//        //
        var lYear_of_manufactureT = new Label("Year Of Manufacture");
        lYear_of_manufactureT.setStyle("-fx-font: normal bold 14px 'Arial'");
        grid.add(lYear_of_manufactureT, 7, 1);
//        //
        var lNumber_of_seatsT = new Label("Number Of Seats");
        lNumber_of_seatsT.setStyle("-fx-font: normal bold 14px 'Arial'");
        grid.add(lNumber_of_seatsT, 8, 1);
//        //
        var lTypeT = new Label("Type");
        lTypeT.setStyle("-fx-font: normal bold 14px 'Arial'");
        grid.add(lTypeT, 9, 1);
//        //
        var lStatusT = new Label("Status");
        lStatusT.setStyle("-fx-font: normal bold 14px 'Arial'");
        grid.add(lStatusT, 10, 1);
//        //
        var lPriceT = new Label("Price");
        lPriceT.setStyle("-fx-font: normal bold 14px 'Arial'");
        grid.add(lPriceT,11,  1);
//
        var lUpdateT = new Label("Update");
        lUpdateT.setStyle("-fx-font: normal bold 14px 'Arial'");
        grid.add(lUpdateT,12,  1);
//
        var lDeleteT = new Label("Delete");
        lDeleteT.setStyle("-fx-font: normal bold 14px 'Arial'");
        grid.add(lDeleteT,13,  1);

        for(int i = 0; i < planeList.size(); i++) {
            var showId = new Label(planeList.get(i).getId());
            showId.setStyle("-fx-font: normal bold 12px 'Arial'");
            grid.add(showId, 4, i + 2);
            var showName = new Label(planeList.get(i).getName());
            showName.setStyle("-fx-font: normal bold 12px 'Arial'");
            grid.add(showName, 5, i + 2);
            var showManufacturer = new Label(planeList.get(i).getManufacturer());
            showManufacturer.setStyle("-fx-font: normal bold 12px 'Arial'");
            grid.add(showManufacturer, 6, i + 2);
            var showYearOfManufacture = new Label(""+planeList.get(i).getYearOfManufacture());
            showYearOfManufacture.setStyle("-fx-font: normal bold 12px 'Arial'");
            grid.add(showYearOfManufacture, 7, i + 2);
            var showNumber_of_seats = new Label(""+planeList.get(i).getNumber_of_seats());
            showNumber_of_seats.setStyle("-fx-font: normal bold 12px 'Arial'");
            grid.add(showNumber_of_seats, 8, i + 2);
            var showType = new Label(planeList.get(i).getType());
            showType.setStyle("-fx-font: normal bold 12px 'Arial'");
            grid.add(showType, 9, i + 2);
            var showStatus = new Label(planeList.get(i).getStatus());
            showStatus.setStyle("-fx-font: normal bold 12px 'Arial'");
            grid.add(showStatus, 10, i + 2);
            var showPrice = new Label(planeList.get(i).getPrice() + "$");
            showPrice.setStyle("-fx-font: normal bold 12px 'Arial'");
            grid.add(showPrice, 11, i + 2);


        //        // add
        var btnAdd = new Button("Add");
        btnAdd.setPadding(new Insets(5, 15, 5, 15));
        btnAdd.setOnAction(e -> {
            String id = tfID.getText();
            String name = tfName.getText();
            String manufacturer = tfManufacturer.getText();
            Integer year_of_manufacture = Integer.valueOf(tfYear_of_manufacture.getText());
            Integer number_of_seats = Integer.valueOf(tfNumber_of_seats.getText());
            String type = tfType.getText();
            String status = tfStatus.getText();
            Float price = Float.valueOf(tfPrice.getText());
            if (!id.equals(EMPTY)&&!name.equals(EMPTY) && !manufacturer.equals(EMPTY) && !year_of_manufacture.equals(EMPTY) && !number_of_seats.equals(EMPTY) && !type.equals(EMPTY) && !status.equals(EMPTY) && !price.equals(EMPTY)) {
                con.addPlane(new Plane(id,name,manufacturer,year_of_manufacture,number_of_seats,type,status,price));
                try {
                    start(stage);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
                return;
            }
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("Please fill all blank!");
            alert.showAndWait();
        });
        grid.add(btnAdd, 0, 9);
        btnAdd.setStyle("-fx-background-color:  #0033FF; -fx-color: #000000; -fx-padding: 5 50 5 50; -fx-font: normal bold 16px 'Arial'");
//

            // Update
            var btnUpdate = new Button("Update");
            btnUpdate.setId(planeList.get(i).getId());
            int finalI = i;
            btnUpdate.setOnAction(e -> {
                btnAdd.setVisible(false);
                String id1 = btnUpdate.getId();

                TextField tfid = (TextField) grid.getChildren().get(3);
                tfid.setText("" + planeList.get(finalI).getId());

                TextField tfname = (TextField) grid.getChildren().get(5);
                tfname.setText("" + planeList.get(finalI).getName());
//
                TextField tfmanufacturer = (TextField) grid.getChildren().get(7);
                tfmanufacturer.setText(planeList.get(finalI).getType());
//
                TextField tfyear_of_manufacture = (TextField) grid.getChildren().get(9);
                tfyear_of_manufacture.setText("" + planeList.get(finalI).getYearOfManufacture());
//
                TextField tfnumber_of_seats= (TextField) grid.getChildren().get(11);
                tfnumber_of_seats.setText("" + planeList.get(finalI).getNumber_of_seats());
//
                TextField tftype = (TextField) grid.getChildren().get(13);
                tftype.setText(planeList.get(finalI).getType());
//
                TextField tfstatus = (TextField) grid.getChildren().get(15);
                tfstatus.setText(planeList.get(finalI).getStatus());
//
                TextField tfprice = (TextField) grid.getChildren().get(17);
                tfprice.setText(""+planeList.get(finalI).getPrice());
//
                var newbtnAdd = new Button("Update");
                newbtnAdd.setPadding(new Insets(5, 15, 5, 15));
                newbtnAdd.setOnAction(newe -> {
                    String NewId = tfid.getText();
                    String NewStatus = tfstatus.getText();
                    if (!NewStatus.equals(EMPTY)) {
                        con.updatePlane(NewStatus, NewId);
                        try {
                            start(stage);
                        } catch (Exception ex) {
                            throw new RuntimeException(ex);
                        }
                        return;
                    }
                    var alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill all blank!");
                    alert.showAndWait();
                });
                grid.add(newbtnAdd, 1, 9);
                newbtnAdd.setStyle("-fx-background-color:  #00CC00; -fx-color: #000000; -fx-padding: 5 20 5 20; -fx-font: normal bold 16px 'Arial'");
            });
            grid.add(btnUpdate, 12, i+2);
            btnUpdate.setStyle("-fx-background-color:  #00CC00; -fx-color: #000000; -fx-padding: 5 20 5 20; -fx-font: normal bold 12px 'Arial'");

            // Delete
            var btnDelete = new Button("Delete");
            btnDelete.setId(planeList.get(i).getId());
            btnDelete.setOnAction(e -> {
                String id = btnDelete.getId();
                con.deletePlane(id);
                var alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setContentText("Deleted!");
                alert.showAndWait();
                try {
                    start(stage);
                } catch (Exception ex) {
                    throw new RuntimeException(ex);
                }
            });
            grid.add(btnDelete, 13, i+2);
            btnDelete.setStyle("-fx-background-color:  #EE0000; -fx-color: #000000; -fx-padding: 5 20 5 20; -fx-font: normal bold 12px 'Arial'");
        }
//        search
        var lSearching = new Label("Searching Manufacturer");
        lSearching.setStyle("-fx-font: normal bold 14px 'Arial'");
        grid.add(lSearching, 0, 11);
        var tfSearch = new TextField();
        grid.add(tfSearch, 1, 11);
        var btnSearch = new Button("Search");
        btnSearch.setPadding(new Insets(5, 15, 5, 15));
        btnSearch.setOnAction(e -> {
            String manufacturer = tfSearch.getText();
            if (!manufacturer.equals(EMPTY)) {
                ArrayList <Plane> planeByManufacturerList = con.getPlanesByManufacturer(manufacturer);
                var lIdS = new Label("ID");
                lIdS.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 14px 'Arial'");
                grid.add(lIdS, 4, 11);
//        //
                var lNameS = new Label("Name");
                lNameS.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 14px 'Arial'");
                grid.add(lNameS, 5, 11);
//        //
                var lManufacturerS = new Label("Manufacturer");
                lManufacturerS.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 14px 'Arial'");
                grid.add(lManufacturerS, 6, 11);
//        //
                var lYear_of_manufactureS = new Label("Year Of Manufacture");
                lYear_of_manufactureS.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 14px 'Arial'");
                grid.add(lYear_of_manufactureS, 7, 11);
//        //
                var lNumber_of_seatsS = new Label("Number Of Seats");
                lNumber_of_seatsS.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 14px 'Arial'");
                grid.add(lNumber_of_seatsS, 8, 11);
//        //
                var lTypeS = new Label("Type");
                lTypeS.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 14px 'Arial'");
                grid.add(lTypeS, 9, 11);
//        //
                var lStatusS = new Label("Status");
                lStatusS.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 14px 'Arial'");
                grid.add(lStatusS, 10, 11);
//        //
                var lPriceS = new Label("Price");
                lPriceS.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 14px 'Arial'");
                grid.add(lPriceS,11,  11);
//
                for(int x = 0; x < planeByManufacturerList.size(); x++){
                    var showId = new Label(planeByManufacturerList.get(x).getId());
                    showId.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 12px 'Arial'");
                    grid.add(showId, 4, x + 12);
                    var showName = new Label(planeByManufacturerList.get(x).getName());
                    showName.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 12px 'Arial'");
                    grid.add(showName, 5, x + 12);
                    var showManufacturer = new Label(planeByManufacturerList.get(x).getManufacturer());
                    showManufacturer.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 12px 'Arial'");
                    grid.add(showManufacturer, 6, x + 12);
                    var showYearOfManufacture = new Label(""+planeByManufacturerList.get(x).getYearOfManufacture());
                    showYearOfManufacture.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 12px 'Arial'");
                    grid.add(showYearOfManufacture, 7, x + 12);
                    var showNumber_of_seats = new Label(""+planeByManufacturerList.get(x).getNumber_of_seats());
                    showNumber_of_seats.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 12px 'Arial'");
                    grid.add(showNumber_of_seats, 8, x + 12);
                    var showType = new Label(planeByManufacturerList.get(x).getType());
                    showType.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 12px 'Arial'");
                    grid.add(showType, 9, x + 12);
                    var showStatus = new Label(planeByManufacturerList.get(x).getStatus());
                    showStatus.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 12px 'Arial'");
                    grid.add(showStatus, 10, x + 12);
                    var showPrice = new Label(planeByManufacturerList.get(x).getPrice() + "$");
                    showPrice.setStyle("-fx-text-fill: #000011;-fx-font: normal bold 12px 'Arial'");
                    grid.add(showPrice, 11, x + 12);
                }
//                try {
//                    start(stage);
//                } catch (Exception ex) {
//                    throw new RuntimeException(ex);
//                }
                return;
            }
            var alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(null);
            alert.setContentText("You need to completely fill in the search box!");
            alert.showAndWait();
        });
        grid.add(btnSearch, 0, 12);
        btnSearch.setStyle("-fx-background-color:  # 00F5FF; -fx-color: #000000; -fx-padding: 5 50 5 50; -fx-font: normal bold 16px 'Arial'");
//

        // thống kê
        var statistical = new Label("Statistical");
        statistical.setStyle("-fx-background-color:  #FFFFFF; -fx-padding: 5 15; -fx-font: normal bold 16px 'Arial'");
        grid.add(statistical, 0, 13);

        var lTotalPlanes = new Label("Total Planes");
        lTotalPlanes.setStyle("-fx-background-color:  #FFFFFF; -fx-padding: 5 15; -fx-font: normal bold 12px 'Arial'");
        grid.add(lTotalPlanes, 0, 14);

        var totalPlanes = new Label(""+ totalPlane);
        totalPlanes.setStyle("-fx-background-color:  #FFFFFF; -fx-padding: 5 15; -fx-font: normal bold 12px 'Arial'");
        grid.add(totalPlanes, 1, 14);

        var lIsMaintained = new Label("Total is maintained");
        lIsMaintained.setStyle("-fx-background-color:  #FFFFFF; -fx-padding: 5 15; -fx-font: normal bold 12px 'Arial'");
        grid.add(lIsMaintained, 0, 15);

        var totalIsMaintained = new Label(""+ totalPlaneIsMaintained);
        totalIsMaintained.setStyle("-fx-background-color:  #FFFFFF; -fx-padding: 5 15; -fx-font: normal bold 12px 'Arial'");
        grid.add(totalIsMaintained, 1, 15);

        var lIsActive = new Label("Total is active");
        lIsActive.setStyle("-fx-background-color:  #FFFFFF; -fx-padding: 5 15; -fx-font: normal bold 12px 'Arial'");
        grid.add(lIsActive, 0, 16);

        var totalIsActive = new Label(""+ totalPlaneIsActive);
        totalIsActive.setStyle("-fx-background-color:  #FFFFFF; -fx-padding: 5 15; -fx-font: normal bold 12px 'Arial'");
        grid.add(totalIsActive, 1, 16);

        var lStopWorking = new Label("Total stop working");
        lStopWorking.setStyle("-fx-background-color:  #FFFFFF; -fx-padding: 5 15; -fx-font: normal bold 12px 'Arial'");
        grid.add(lStopWorking, 0, 17);

        var totalStopWorking = new Label(""+ totalPlaneStopWorking);
        totalStopWorking.setStyle("-fx-background-color:  #FFFFFF; -fx-padding: 5 15; -fx-font: normal bold 12px 'Arial'");
        grid.add(totalStopWorking, 1, 17);
        //

        // scene quản lý nhân viên


        scene = new Scene(grid, 1500, 800);
        stage.setTitle("Book");
        stage.setScene(scene);
        stage.show();

    }
}