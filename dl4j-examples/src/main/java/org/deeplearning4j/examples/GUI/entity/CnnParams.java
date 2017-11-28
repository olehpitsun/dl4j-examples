package org.deeplearning4j.examples.GUI.entity;

/**
 * Created by Oleh on 02.10.2017.
 */
public class CnnParams {

    private static String patjToFolder;
    private static Integer epochs;
    private static Integer iterations;
    private static Integer height;
    private static Integer width;
    private static Integer batches;
    private static Integer classes;

    public static Integer getBatches() {
        return batches;
    }

    public static void setBatches(Integer batches) {
        CnnParams.batches = batches;
    }

    public static Integer getClasses() {
        return classes;
    }

    public static void setClasses(Integer classes) {
        CnnParams.classes = classes;
    }

    public static String getPatjToFolder() {
        return patjToFolder;
    }

    public static void setPatjToFolder(String patjToFolder) {
        CnnParams.patjToFolder = patjToFolder;
    }

    public static int getEpochs() {
        return epochs;
    }

    public static void setEpochs(Integer epochs) {
        CnnParams.epochs = epochs;
    }

    public static int getIterations() {
        return iterations;
    }

    public static void setIterations(Integer iterations) {
        CnnParams.iterations = iterations;
    }

    public static int getHeight() {
        return height;
    }

    public static void setHeight(Integer height) {
        CnnParams.height = height;
    }

    public static int getWidth() {
        return width;
    }

    public static void setWidth(Integer width) {
        CnnParams.width = width;
    }

}
