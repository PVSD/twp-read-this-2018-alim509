package com.company;

import sun.tools.java.Imports;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        File file = new File("Imports");
        Scanner fileScanner = new Scanner(file);
        fileScanner.close();

        int maxIndx = -1;
        String text[] = new String[1000];

        while (fileScanner.hasNext())
        {
            maxIndx++;
            text[maxIndx] = fileScanner.nextLine();
        }

        fileScanner.close();

        for(int j = 0; j <= maxIndx; j++)
        {
            System.out.println( text[j] );
        }
    }
}
