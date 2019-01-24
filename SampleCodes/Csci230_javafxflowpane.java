/*
CSCI230 Sample Codes are licensed under the 
Creative Commons Attribution 4.0 International License, except where otherwise noted.
*/

package csci230_javafxflowpane;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Csci230_javafxflowpane extends Application {
    
    @Override
    public void start(Stage primaryStage) // From Listing 14.10 (p. 553)
{
   // Create a pane and set its properties
   FlowPane pane = new FlowPane();
   pane.setPadding(new Insets(11, 12, 13, 14));
   pane.setHgap(5);
   pane.setVgap(5);

   // Place nodes in the pane
   pane.getChildren().addAll(new Label("First Name:"),
   new TextField(), new Label("MI:"));
   TextField tfMi = new TextField();
   tfMi.setPrefColumnCount(1);
   pane.getChildren().addAll(tfMi, new Label("Last Name:"),
   new TextField());

   // Create a scene and place it in the stage
   Scene scene = new Scene(pane, 200, 250);
   primaryStage.setTitle("ShowFlowPane"); // Set the stage title
   primaryStage.setScene(scene);          // Put scene in stage
   primaryStage.show();                   // Display the stage
}

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
