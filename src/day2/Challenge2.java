package day2;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

// only 12 red cubes, 13 green cubes, and 14 blue cubes

// I'm so happy - someone I got this one first try B)

// There's no justification for this coding monstrosity to any readers out there. I am sorry.
public class Challenge2 {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        File root = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
        File file = new File(root, "day2/input.txt");
        Scanner scan = new Scanner(file);

        int x = 0;
        while (scan.hasNext()){
            int minGreen = 0;
            int minBlue = 0;
            int minRed = 0;
            ArrayList<String> rounds = new ArrayList<>();
            String s = scan.nextLine();
            int j = 0;
            for (int i = 0; i < s.length(); i++){
                if (s.charAt(i) == ':'){
                    j = i + 2;
                }
                if (s.charAt(i) == ';'){
                    rounds.add(s.substring(j, i + 1));
                    j = i + 2;
                }
            }
            rounds.add(s.substring(j) + ";");

            for (String str : rounds) {
                ArrayList<String> draws = new ArrayList<>();
                j = 0;
                for (int i = 0; i < str.length(); i++){
                    if (str.charAt(i) == ';' || str.charAt(i) == ','){
                        draws.add(str.substring(j, i));
                        j = i + 2;
                    }
                }
                for (String draw : draws){
                    if (getBlue(draw) > minBlue) {
                        minBlue = getBlue(draw);
                    }
                    if (getRed(draw) > minRed) {
                        minRed = getRed(draw);
                    }
                    if (getGreen(draw) > minGreen) {
                        minGreen = getGreen(draw);
                    }
                }
            }
            System.out.println(s);
            System.out.println(minRed);
            System.out.println(minBlue);
            System.out.println(minGreen);
            x += (minRed * minBlue * minGreen);
        }

        System.out.println(x);



    }


    public static int getBlue(String s){
        if (s.contains("blue")){
            if (s.indexOf("blue") >=3) {
                String substring = s.substring(s.indexOf("blue") - 3, s.indexOf("blue") - 1);
                if (isInteger(substring)) {
                    return Integer.parseInt(substring);
                }
            }else {
                String substring = s.substring(s.indexOf("blue") - 2, s.indexOf("blue") - 1);
                if (isInteger(substring)) {
                    return Integer.parseInt(substring);
                }
            }
        }
        return 0;
    }
    public static int getRed(String s){
        if (s.contains("red")){
            if (s.indexOf("red") >=3) {
                String substring = s.substring(s.indexOf("red") - 3, s.indexOf("red") - 1);
                if (isInteger(substring)) {
                    return Integer.parseInt(substring);
                }
            }else {
                String substring = s.substring(s.indexOf("red") - 2, s.indexOf("red") - 1);
                if (isInteger(substring)) {
                    return Integer.parseInt(substring);
                }
            }
        }
        return 0;
    }
    public static int getGreen(String s){
        if (s.contains("green")){
            if (s.indexOf("green") >=3) {
                String substring = s.substring(s.indexOf("green") - 3, s.indexOf("green") - 1);
                if (isInteger(substring)) {
                    return Integer.parseInt(substring);
                }
            }else {
                String substring = s.substring(s.indexOf("green") - 2, s.indexOf("green") - 1);
                if (isInteger(substring)) {
                    return Integer.parseInt(substring);
                }
            }
        }
        return 0;
    }

    public static boolean isInteger(String s) {
        try {
            Integer.parseInt(s);
        } catch(NumberFormatException | NullPointerException e) {
            return false;
        }
        return true;
    }
}
