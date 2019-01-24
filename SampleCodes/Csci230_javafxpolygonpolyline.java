/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package csci230_javafxpolygonpolyline;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import javafx.stage.Stage;

/**
 *
 * @author Gheni
 */
public class Csci230_javafxpolygonpolyline extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        /*
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });
        
        StackPane root = new StackPane();
        root.getChildren().add(btn);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
        */
        Pane pane = new Pane();             // create a pane
Polygon polygon = new Polygon();    // create a polygon
pane.getChildren().add(polygon);    // add the polygon to the pane
polygon.setFill(Color.WHITE);       // polygon will be filled in white
polygon.setStroke(Color.BLACK);     //     with a black border
ObservableList<Double> list = polygon.getPoints(); // get its vertex list

final double WIDTH = 200, HEIGHT = 200;            // See Fig. 14.40 (a)
double centerX = WIDTH / 2, centerY = HEIGHT / 2;  //
double radius = Math.min(WIDTH, HEIGHT) * 0.4;     //

// Generated and add (x, y) points to the polygon’s vertex list
for (int i = 0; i < 6; i++) 
{
   list.add(centerX + radius * Math.cos(2 * i * Math.PI / 6));
   list.add(centerY - radius * Math.sin(2 * i * Math.PI / 6));
}

// Create a scene and place it in the stage
Scene scene = new Scene(pane, WIDTH, HEIGHT);
primaryStage.setTitle("ShowPolygon"); // Set the stage title
primaryStage.setScene(scene);         // Put scene in stage
primaryStage.show();                  // Display the stage

    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
