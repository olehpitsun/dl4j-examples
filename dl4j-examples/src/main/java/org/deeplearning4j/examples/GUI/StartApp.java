/**
 *
 */

package org.deeplearning4j.examples.GUI;

import javafx.application.Application;
import javafx.stage.Stage;
import org.deeplearning4j.examples.GUI.nodes.ConvolutionNeuralNetModule;

public class StartApp extends Application {

    public static boolean DONE = false;
    private Stage primaryStage;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        try {
            ConvolutionNeuralNetModule convolutionNeuralNetModule = new ConvolutionNeuralNetModule();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


