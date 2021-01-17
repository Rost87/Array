package com.company;

import java.io.File;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Keyboard {

   static void recordFile(String[] result, String fileName){
        try(PrintWriter out = new PrintWriter(fileName)){

            for (int i = 0; i < result.length; i++) {
                out.write(result[i]);
                out.write("\n");
            }

        }catch(Exception exc){
            System.out.println(exc.getMessage());
        }
    }

    static String[] checkKeyboard(int[] maxNumberOfClicks){
        String[] result = new String[maxNumberOfClicks.length];
        for (int i = 0; i < maxNumberOfClicks.length; i++) {
            if(maxNumberOfClicks[i] < 0) {
                result[i] = "yes";
            } else{
                result[i] = "no";
            }
        }
        return result;
    }

    // Комментарий/
    public static void main(String[] args) {

        String []  result;

        try (Scanner scanner = new Scanner(new File("input.txt"))) {

            //количество нажатий каждой клавиши
            int [] maxNumberOfClicks = new int[scanner.nextInt()];

            for (int i = 0; i < maxNumberOfClicks.length; i++) {
                maxNumberOfClicks[i] = scanner.nextInt();
            }

            // пропускаем текущую строку и сдедующую за ней
            scanner.nextLine();
            scanner.nextLine();
            int i = 0;
            while (scanner.hasNext()){
                i = scanner.nextInt() - 1;
                maxNumberOfClicks[i]--;

            }

            recordFile(checkKeyboard(maxNumberOfClicks), "result.txt");

        } catch (Exception exc) {
            System.out.println(exc.getMessage());
        }

    }
}