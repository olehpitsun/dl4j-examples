/**
 *
 */

package org.deeplearning4j.examples.GUI;

import javafx.application.Application;
import javafx.stage.Stage;
import org.deeplearning4j.examples.GUI.nodes.ConvolutionNeuralNetModule;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class StringExample{



    public static Map<String, String> hashMap = new HashMap<>();

    public static Map<String, String> start(String str) {



        /*
        String str = "Examples labeled as 0 classified by model as 0: 1 times\n" +
            "Examples labeled as 1 classified by model as 0: 1 times\n" +
            "Examples labeled as 2 classified by model as 0: 1 times\n" +
            "Examples labeled as 4 classified by model as 0: 1 times\n" +
            "Examples labeled as 5 classified by model as 5: 1 times\n" +
            "Examples labeled as 5 classified by model as 1: 5 times\n" +
            "\n" +
            "Warning: class 2 was never predicted by the model. This class was excluded from the average precision\n" +
            "Warning: class 3 was never predicted by the model. This class was excluded from the average precision\n" +
            "Warning: class 4 was never predicted by the model. This class was excluded from the average precision\n" +
            "Warning: class 5 was never predicted by the model. This class was excluded from the average precision";
*/
        String prefix = "Examples labeled as 5 classified by model as";

        String[] tokens = str.substring(prefix.length()).split("times");

        String[] choosedStr = new String[10];

        for (int i = 0; i < tokens.length; i++) {
            choosedStr[i] = compareStr(tokens[i], "Examples labeled as 5 classified by model");
        }


        for (int i = 0; i < choosedStr.length; i++) {

            if (choosedStr[i] != null && choosedStr[i] != "") {
                String strTemp = choosedStr[i].toString();

                System.out.println(getSubStr(strTemp, 46, 48) + " - result");

                System.out.println(getSubStr(strTemp, 50, 51) + " - second result");

                String findClass = getSubStr(strTemp, 46, 48) ;

                String count = getSubStr(strTemp, 50, 51) ;

                hashMap.put(findClass, count);

            }

        }


        Set<Map.Entry<String, String>> set = hashMap.entrySet();

        for (Map.Entry<String, String> me : set) {
            System.out.print(me.getKey() + ":--- ");
            System.out.println(me.getValue());
        }

        return hashMap;
    }

    public static Map<String, String> getHashMap(){
        return hashMap;
    }

    public static String getSubStr(String inpStr, int f, int l ){
        String prefix = "Examples labeled as 5 classified by model as ";
        String noPrefixStr = inpStr.substring(f, l );
        String[] tokens = noPrefixStr.split(":");

        return tokens[0];
    }

    public static String compareStr (String inputStr, String findPattern){
        String result = "";
        String searchMe = inputStr;
        String findMe = findPattern;
        int searchMeLength = searchMe.length();
        int findMeLength = findMe.length();
        boolean foundIt = false;
        for (int i = 0; i <= (searchMeLength - findMeLength); i++) {
            if (searchMe.regionMatches(i, findMe, 0, findMeLength)) {
                foundIt = true;
                result = searchMe;
                //System.out.println("\\n" + searchMe.substring(i, i + findMeLength));
                break;
            }
        }
        if (!foundIt){
            result = "";
        }

        return result;
    }

    public static void getResult(String inputStr){

        System.out.println(inputStr + " sssss");
        String prefix = "Examples labeled as 5 classified by model as ";
        String noPrefixStr = inputStr.substring(inputStr.indexOf(prefix) );

        String[] tokens = noPrefixStr.split(":");

        for (String t : tokens)
            System.out.println(t);
    }



}


