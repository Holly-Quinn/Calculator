package main.java;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("Calculator.fxml"));
        primaryStage.setTitle("Calculator");
        Scene calculator = new Scene(root);
        primaryStage.setScene(calculator);
        calculator.getStylesheets().add("main/resources/stylesheet.css");
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.getIcons().add(new Image("main/resources/Calculator.png"));

        final double[] xOffset = new double[1];
        final double[] yOffset = new double[1];

        //grab your root here
        root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset[0] = event.getSceneX();
                yOffset[0] = event.getSceneY();
            }
        });

        //move around here
        root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                primaryStage.setX(event.getScreenX() - xOffset[0]);
                primaryStage.setY(event.getScreenY() - yOffset[0]);
            }
        });


        primaryStage.show();



    }

}





