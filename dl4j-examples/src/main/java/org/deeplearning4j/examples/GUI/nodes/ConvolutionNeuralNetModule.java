package org.deeplearning4j.examples.GUI.nodes;

import javafx.stage.Stage;
import org.deeplearning4j.examples.GUI.views.ConvolutionNeuralNetPageView;

/**
 * Created by oleh on 12.06.2017.
 * @author Oleh Pitsun
 */
public class ConvolutionNeuralNetModule {

    ConvolutionNeuralNetPageView convolutionNeuralNetPageView;
    protected ConvolutionNeuralNetModule convolutionNeuralNetModule;
    private Stage primaryStage;

    public ConvolutionNeuralNetModule() throws Exception {
        convolutionNeuralNetPageView = new ConvolutionNeuralNetPageView();
        convolutionNeuralNetPageView.render();
    }


    public void setConvolutionNeuralNetView(ConvolutionNeuralNetModule convolutionNeuralNetModule1) {

        this.convolutionNeuralNetModule = convolutionNeuralNetModule1;
    }
}
