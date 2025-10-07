package com.pluralsight;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.*;
import java.io.*;

public class SearchEngineLogger {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss");
        String formattedDate = today.format(fmt);
        Scanner myScanner = new Scanner(System.in);
        logActions(myScanner, formattedDate);
        myScanner.close();
    }
    public static void logActions(Scanner myScanner, String formattedDate){
        try{
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("logs.txt"));
            bufferedWriter.write(formattedDate + " launch\n");
            boolean isDone = false;
            while(!isDone){
                System.out.println("Enter a search term (X to exit)");
                String input = myScanner.nextLine();
                if(input.equalsIgnoreCase("X")) {
                    isDone = true;
                    bufferedWriter.write(formattedDate + " exit\n");
                }
                else bufferedWriter.write(formattedDate + " search: " + input + "\n");
            }
            bufferedWriter.close();
        }
        catch(IOException ex){
            System.err.println("Error has occurred.");
        }
    }
}
