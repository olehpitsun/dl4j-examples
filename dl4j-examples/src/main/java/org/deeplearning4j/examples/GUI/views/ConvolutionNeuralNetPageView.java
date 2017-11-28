package org.deeplearning4j.examples.GUI.views;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.nio.file.Paths;

/**
 * Created by oleh on 12.06.2017.
 * @author Oleh Pitsun
 */
public class ConvolutionNeuralNetPageView {
    Stage primaryStage = new Stage();

    public void render() throws Exception {

        URL url = Paths.get("./src/main/resources/fxml/ConvolutionNeuralNetPageView.fxml").toUri().toURL();
        Parent pr1 = FXMLLoader.load(url);

        //Parent pr1 = FXMLLoader.load(getClass().getResource("fxml/ConvolutionNeuralNetPageView.fxml"));
        primaryStage.setTitle("Нейронна мережа");
        Scene scene = new Scene(pr1);

        URL cssurl = Paths.get("./src/main/resources/css/DarkTheme.css").toUri().toURL();

        scene.getStylesheets().add(0, cssurl.toString());

        primaryStage.setMinWidth(300);
        primaryStage.setMinHeight(275);
        primaryStage.setScene(scene);
        primaryStage.setResizable(true);
        //CurrentStage.setMainStage(primaryStage);
        //CurrentStage.getStage().close();
        primaryStage.show();
    }

}
