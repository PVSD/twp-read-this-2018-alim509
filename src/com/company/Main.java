package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("Imports.txt");
        Scanner fileScanner = new Scanner(file);


        int maxIndex = -1;
        String name[] = new String[100];
        String grade[] = new String[100];
        String absences[] = new String[100];

        while (fileScanner.hasNext())
        {
            maxIndex++;
            name[maxIndex] = fileScanner.next() + fileScanner.next();
            grade[maxIndex] = fileScanner.next() + fileScanner.next();
            absences[maxIndex] = fileScanner.next() + fileScanner.next();

        }

        for(int j = 0; j <= maxIndex; j++)
        {
            System.out.println( name[j] );
        }

        fileScanner.close();
    }
}
