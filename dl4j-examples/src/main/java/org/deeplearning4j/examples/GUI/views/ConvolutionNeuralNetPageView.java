package org.deeplearning4j.examples.GUI.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by oleh on 12.06.2017.
 * @author Oleh Pitsun
 */
public class ConvolutionNeuralNetPageView {
    Stage primaryStage = new Stage();

    public void render() throws Exception {

        Parent pr1 = FXMLLoader.load(getClass().getClassLoader().getResource("fxml/ConvolutionNeuralNetPageView.fxml"));
        primaryStage.setTitle("Нейронна мережа");
        Scene scene = new Scene(pr1);
        scene.getStylesheets().add(0, "css/DarkTheme.css");

        primaryStage.setMinWidth(300);
        primaryStage.setMinHeight(275);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        //CurrentStage.setMainStage(primaryStage);
        //CurrentStage.getStage().close();
        primaryStage.show();
    }

}
