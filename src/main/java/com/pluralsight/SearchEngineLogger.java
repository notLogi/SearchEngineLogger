package com.pluralsight;

import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.time.*;
import java.io.*;

public class SearchEngineLogger {
    public static void main(String[] args) {
        LocalDateTime today = LocalDateTime.now();
        Scanner myScanner = new Scanner(System.in);
        logActions(myScanner);
        myScanner.close();
    }
    public static void logActions(Scanner myScanner){
        try{
            DateTimeFormatter fmt = DateTimeFormatter.ofPattern("yyyy-dd-MM HH:mm:ss");
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("logs.txt "));
            bufferedWriter.write(LocalDateTime.now().format(fmt) + " launch\n");
            boolean isDone = false;
            while(!isDone){
                LocalDateTime today = LocalDateTime.now();
                String formattedDate = today.format(fmt);
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
