package org.deeplearning4j.examples.GUI.tools;

import java.io.File;

/**
 * Created by Oleh on 15.06.2017.
 */
public class DirUntils {

    public static int calculateDirs(String path){

        File dir = new File(path);
        int numberOfSubfolders = 0;
        File listDir[] = dir.listFiles();
        for (int i = 0; i < listDir.length; i++) {
            if (listDir[i].isDirectory()) {
                numberOfSubfolders++;
            }
        }
        System.out.println(numberOfSubfolders);
        return numberOfSubfolders;
    }
}
