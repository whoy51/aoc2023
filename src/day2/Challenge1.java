package day2;


import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

// only 12 red cubes, 13 green cubes, and 14 blue cubes
public class Challenge1 {
    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        File root = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
        File file = new File(root, "day2/input.txt");
        Scanner scan = new Scanner(file);

        int x = 0;
        int idx = 1;
        while (scan.hasNext()){
            boolean doesGamePass = true;
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
                    if (!isDrawClear(draw)){
                        doesGamePass = false;
                    }
                }
            }
            System.out.println(s + doesGamePass);
            if (doesGamePass){
                x += idx;
            }
            idx ++;

        }
        System.out.println(idx);
        System.out.println(x);



    }

    public static boolean isDrawClear(String s){
        if (s.contains("blue")){
            if (s.indexOf("blue") >=3) {
                String substring = s.substring(s.indexOf("blue") - 3, s.indexOf("blue") - 1);
                if (isInteger(substring)) {
                    if (Integer.parseInt(substring) > 14) {
                        return false;
                    }
                }
            }
        }
        if (s.contains("red")){
            if (s.indexOf("red") >=3) {
                String substring = s.substring(s.indexOf("red") - 3, s.indexOf("red") - 1);
                if (isInteger(substring)) {
                    if (Integer.parseInt(substring) > 12) {
                        return false;
                    }
                }
            }
        }
        if (s.contains("green")){
            if (s.indexOf("green") >=3) {
                String substring = s.substring(s.indexOf("green") - 3, s.indexOf("green") - 1);
                if (isInteger(substring)) {
                    if (Integer.parseInt(substring) > 13) {
                        return false;
                    }
                }
            }
        }
        return true;
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
