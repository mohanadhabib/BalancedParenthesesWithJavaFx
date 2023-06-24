package com.example.test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class TestApplication extends Application {
    @Override
    public void start(Stage stage) {
        Button btn = new Button("Welcome");
        Pane pane = new Pane();
        Scene scene = new Scene(pane);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
        stage.setHeight(480);
        stage.setWidth(480);
        btn.layoutXProperty().bind(pane.widthProperty().divide(2));
        btn.layoutYProperty().bind(pane.heightProperty().divide(2));
        btn.setMinSize(20,20);

        pane.getChildren().add(btn);
    }

    public static void main(String[] args) {
        launch();
    }
}