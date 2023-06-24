package com.example.test;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainApplication extends Application {
    private final Label titleLbl = new Label("Enter Your Expression Here : ");
    private final TextField txt = new TextField();
    private final Button btn = new Button("Check");
    private final Label resLbl = new Label();
    private final Pane pane = new Pane();
    private final Scene scene = new Scene(pane,500,500);
    @Override
    public void start(Stage stage) {
        titleLbl.setId("titleLbl");
        titleLbl.layoutXProperty().bind(pane.widthProperty().divide(4));
        titleLbl.layoutYProperty().bind(pane.heightProperty().divide(4));
        txt.setId("txt");
        txt.layoutXProperty().bind(pane.widthProperty().divide(4));
        txt.layoutYProperty().bind(pane.heightProperty().divide(3));
        txt.minWidthProperty().bind(pane.widthProperty().divide(2));
        txt.setMinHeight(30);
        resLbl.setId("resLbl");
        resLbl.layoutXProperty().bind(pane.widthProperty().divide(4));
        resLbl.layoutYProperty().bind(pane.heightProperty().divide(2));
        btn.setId("btn");
        btn.layoutXProperty().bind(pane.widthProperty().divide(2.5));
        btn.layoutYProperty().bind(pane.heightProperty().divide(1.5));
        btn.minWidthProperty().bind(pane.widthProperty().divide(5));
        btn.setMinHeight(30);
        pane.setId("pane");
        pane.getChildren().addAll(titleLbl,txt,resLbl,btn);
        scene.getStylesheets().add("Application.css");
        stage.setTitle("Balanced Parentheses");
        stage.setScene(scene);
        stage.setMinWidth(500);
        stage.setMinHeight(500);
        stage.show();
        btnClick();
    }
    public void btnClick(){
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                boolean res = isBalanced(txt.getText());
                if(res){
                    resLbl.setText("Balanced");
                }
                else{
                    resLbl.setText("Not Balanced");
                }
            }
        });
    }
    public boolean isPair(char start,char end){
        boolean result;
        if(start=='(' && end==')'){
            result = true;
        }
        else if(start=='{' && end=='}'){
            result = true;
        }
        else if(start=='[' && end==']'){
            result = true;
        }
        else {
            result = false;
        }
        return result;
    }
    public boolean isBalanced(String expression){
        Stack stack = new Stack();
        for (int i = 0;i<expression.length();i++){
            if(expression.charAt(i)=='('||expression.charAt(i)=='{'||expression.charAt(i)=='['){
                stack.push(expression.charAt(i));
            }
            else if(expression.charAt(i)==')'||expression.charAt(i)=='}'||expression.charAt(i)==']'){
                if(stack.isEmpty()||!isPair(stack.getTop(),expression.charAt(i))){
                    return false;
                }
                else {
                    stack.pop();
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        launch();
    }
}