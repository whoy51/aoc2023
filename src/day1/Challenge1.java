package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Challenge1 {

    public static void main(String[] args) throws FileNotFoundException, URISyntaxException {
        File root = new File(Thread.currentThread().getContextClassLoader().getResource("").toURI());
        File file = new File(root, "day1/input.txt");
        Scanner scan = new Scanner(file);

        Integer fin = 0;
        while(scan.hasNext()){
            String s = scan.nextLine();
            System.out.println(s);
            String num = "";
            for (int i = 0; i < s.length(); i++){
                if(isInteger(s.substring(i, i + 1))){
                    num += s.substring(i, i+1);
                    break;
                }
            }
            for (int i = s.length()-1; i >=0; i--){
                if(isInteger(s.substring(i, i + 1))){
                    num += s.substring(i, i+1);
                    break;
                }
            }
            System.out.println(num);
            if (!num.isEmpty())
                fin += Integer.parseInt(num);
        }
        System.out.println(fin);
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
