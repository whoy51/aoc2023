package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Scanner;

public class Challenge2 {

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        File root = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
        File file = new File(root, "day1/input.txt");
        Scanner scan = new Scanner(file);

        ArrayList<String> digits = new ArrayList<>();
        digits.add("one");
        digits.add("two");
        digits.add("three");
        digits.add("four");
        digits.add("five");
        digits.add("six");
        digits.add("seven");
        digits.add("eight");
        digits.add("nine");


        int fin = 0;
        boolean shouldIBreak= false;
        while(scan.hasNext()){
            String s = scan.nextLine();
            System.out.println(s);
            String x = "";
            for (int i = 0; i < s.length(); i++){
                if (shouldIBreak){
                    shouldIBreak = false;
                    break;
                }
                if(isInteger(s.substring(i, i + 1))){
                    x += s.substring(i, i+1);
                    break;
                }
                for (int j = i + 1; j < s.length(); j++){
                    if (digits.contains(s.substring(i, j))){
                        x += String.valueOf(digits.indexOf(s.substring(i, j)) + 1);
                        System.out.println("loop 1 x is now " + x);
                        shouldIBreak = true;
                        break;
                    }
                }
            }
            for (int i = s.length(); i >= 0; i--){
                if (shouldIBreak) {
                    shouldIBreak = false;
                    break;
                }
                if(isInteger(s.substring(i-1, i))){
                    x += s.substring(i-1, i);
                    break;
                }
                for (int j = i - 1; j >= 0; j--){

                    if (digits.contains(s.substring(j, i))){
                        x += String.valueOf(digits.indexOf(s.substring(j, i)) + 1);
                        System.out.println("loop 2 x is now " + x);
                        shouldIBreak = true;
                        break;
                    }
                }
            }
            System.out.println(x);
            if (!x.isEmpty())
                fin += Integer.parseInt(x);
            System.out.println("cur final num: " + fin);
        }
        System.out.println("final num "+ fin);


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
