package org.deeplearning4j.examples.GUI.controllers;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.deeplearning4j.examples.GUI.StringExample;
import org.deeplearning4j.examples.GUI.tools.DirUntils;
import org.deeplearning4j.examples.dataexamples.MnistImagePipelineExampleLoad;
import org.deeplearning4j.examples.dataexamples.MnistImagePipelineExampleSave;
import org.controlsfx.control.*;

import java.io.File;

/**
 * Created by oleh on 12.06.2017.
 * @author Oleh Pitsun
 */
public class ConvolutionNeuralNetController {

    @FXML
    private Slider EpocheSlider, iterSlider, batchesSlider, batchesClassificationSlider;
    @FXML
    private Label epocheNumbLabel, iterLabel, batchesLabel, batchesClassificationLabel;
    @FXML
    private ProgressIndicator teachingIndicator, classificationIndicator;

    private String pathToFolder, epocheNumb, iterCount, batchSixe, batchClassificationSixe, ResultOfClassificationLog;
    private int classCount;
    @FXML
    private void initialize() {

        EpocheSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                epocheNumb = String.valueOf(newValue.intValue());
                epocheNumbLabel.setText(epocheNumb);
            }
        });

        iterSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                iterCount = String.valueOf(newValue.intValue());
                iterLabel.setText(iterCount);
            }
        });

        batchesSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                batchSixe = String.valueOf(newValue.intValue());
                batchesLabel.setText(batchSixe);
            }
        });

        batchesClassificationSlider.valueProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                batchClassificationSixe = String.valueOf(newValue.intValue());
                batchesClassificationLabel.setText(batchClassificationSixe);
            }
        });


    }



    /**
     * початок навчання
     */
    @FXML
    private void startTeaching(){

        teachingIndicator.setVisible(true);

        if(isInputValid()){


            Task<Void> task = new Task<Void>() {
                @Override
                public Void call() throws Exception {

                    classCount = DirUntils.calculateDirs(pathToFolder);
                    System.out.println(pathToFolder + " " + classCount + " " + epocheNumb + " " + iterCount + " " + batchSixe);

                    try {
                        MnistImagePipelineExampleSave.start(pathToFolder, Integer.valueOf(epocheNumb), classCount,
                            Integer.valueOf(batchSixe), 150, 200, Integer.valueOf(iterCount));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    teachingIndicator.setVisible(false);
                    return null;
                }
            };

            Thread tasks = new Thread(task);
            tasks.start();


        }
    }

    @FXML
    private void startClassification(){

        classificationIndicator.setVisible(true);

        Task<Void> task = new Task<Void>() {
            @Override
            public Void call() throws Exception {

                classCount = DirUntils.calculateDirs(pathToFolder);
                System.out.println(pathToFolder + " " + classCount + " "+ Integer.valueOf(batchClassificationSixe));

                try {
                    String classificationResult = MnistImagePipelineExampleLoad.start(pathToFolder, classCount,
                        Integer.valueOf(batchClassificationSixe), 150, 200);

                    ResultOfClassificationLog = classificationResult;
                } catch (Exception e) {
                    e.printStackTrace();
                }
                classificationIndicator.setVisible(false);


                return null;
            }
        };

        Thread tasks = new Thread(task);
        tasks.start();

    }


    @FXML
    private void showClassificationResult(){
        System.out.println("res " + ResultOfClassificationLog);
        StringExample.start(ResultOfClassificationLog);

        ClassificationResult cr = new ClassificationResult();
        Stage primaryStage = new Stage();

        cr.start(primaryStage);
    }

    @FXML
    private void loadFolder(){
        DirectoryChooser directoryChooser = new DirectoryChooser();
        File selectedDirectory =
                directoryChooser.showDialog(new Stage());
        if(selectedDirectory == null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Не вибрано директорію");
            alert.setHeaderText("Виберіть директорію");
            alert.showAndWait();
        }else{
            this.pathToFolder = selectedDirectory.getAbsolutePath();
            System.out.println(this.pathToFolder);
        }
    }



    private boolean isInputValid() {
        String errorMessage = "";

        if (pathToFolder == null ){
            errorMessage += " виберіть директорію ";
        }

        if (epocheNumb == null ){
            errorMessage += " Заповніть поле 'К-сть епох' ";
        }
        if (iterCount == null ){
            errorMessage += " Заповніть поле 'К-сть ітерацій' ";
        }
        if (batchSixe == null ){
            errorMessage += " Заповніть поле 'Batch size' ";
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            Notifications ntBuilder = Notifications.create()
                    .title("Виникла помилка")
                    .text(errorMessage)
                    .graphic(null)
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);
            ntBuilder.darkStyle();
            ntBuilder.show();

            return false;
        }
    }
}
