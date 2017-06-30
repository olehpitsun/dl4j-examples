package org.deeplearning4j.examples.GUI.controllers;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import org.deeplearning4j.examples.GUI.StringExample;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static org.deeplearning4j.examples.GUI.StringExample.hashMap;

/**
 * Created by Oleh on 13.06.2017.
 */


public class ClassificationResult extends Application {






    @Override
    public void start(Stage stage) {
        Scene scene = new Scene(new Group());
        stage.setTitle("Результати класифікації");
        stage.setWidth(500);
        stage.setHeight(500);

        String labels[]={"велосипед","мотоцикл","скутер"};
        System.out.println(labels[0]);


        Set<Map.Entry<String, String>> set = StringExample.getHashMap().entrySet();

        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();

        for (Map.Entry<String, String> me : set) {
            pieChartData.add(new PieChart.Data(labels[Integer.parseInt(me.getKey().trim())] , Double.parseDouble(me.getValue())));
        }

        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Результати класифікації");
        final Label caption = new Label("");
        caption.setTextFill(Color.ANTIQUEWHITE);
        caption.setStyle("-fx-font: 24 arial;");

        for (final PieChart.Data data : chart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_PRESSED,
                    new EventHandler<MouseEvent>() {
                        @Override public void handle(MouseEvent e) {
                            caption.setTranslateX(e.getSceneX());
                            caption.setTranslateY(e.getSceneY());
                            caption.setText(String.valueOf(data.getPieValue()));
                        }
                    });
        }

        ((Group) scene.getRoot()).getChildren().addAll(chart, caption);
        stage.setScene(scene);
        //scene.getStylesheets().add("piechartsample/Chart.css");
        stage.show();
    }

    public static void main() {
        launch();
    }
}
