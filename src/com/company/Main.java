package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner fileScanner = new Scanner (new File("Imports.txt"));
        Scanner kbInput = new Scanner(System.in);

        int maxIndex1 = -1;
        int maxIndex2;
        boolean b = true;
        boolean bb;
        int numA = 0;
        int numB = 0;
        int numC = 0;
        int numD = 0;
        int numF = 0;
        String response;
        double totalGrades = 0;
        String array[] = new String[26];
        int grade[] = new int[5000];
        int absence[] = new int[5000];
        String fName[] = new String[5000];
        String lName[] = new String[5000];
        String g[] = new String[5000];
        String a[] = new String[5000];
        String text[];

        while (fileScanner.hasNext())
        {
            maxIndex1++;
            array[maxIndex1] = fileScanner.nextLine();
        }

        fileScanner.close();

        for (int i = 1; i < array.length - 5; i++) {
            text = array[i].split("\t");
            fName[i] = text[0];
            lName[i] = text[1];
            g[i] = text[2];
            a[i] = text[3];

            g[i] = g[i].substring(0, g[i].length() - 1);
            grade[i] = Integer.parseInt(g[i]);
            absence[i] = Integer.parseInt(a[i]);
            totalGrades += grade[i];

            if (grade[i] >= 90)
            {
                numA++;
            }

            else if (grade[i] >= 80)
            {
                numB++;
            }

            else if (grade[i] >= 70)
            {
                numC++;
            }

            else if (grade[i] >= 60)
            {
                numD++;
            }

            else
            {
                numF++;
            }
        }

        System.out.println("Class Average: " + totalGrades / 25 + "%\n");
        System.out.println(numA + " students got A's.");
        System.out.println(numB + " students got B's.");
        System.out.println(numC + " students got C's.");
        System.out.println(numD + " students got D's.");
        System.out.println(numF + " students got F's.\n");

        System.out.println("If you would like to find a specific student's information, please search their full name.\n");

        while (b)
        {
            maxIndex2 = 0;
            response = kbInput.nextLine();
            bb = false;
            while (maxIndex2 < 24)
            {
                maxIndex2++;
                if (response.equals(fName[maxIndex2] + " " + lName[maxIndex2]))
                {
                    bb = true;
                    System.out.println("\nInformation on " + fName[maxIndex2] + " " + lName[maxIndex2] + ":\n");
                    System.out.println("First Name: " + fName[maxIndex2]);
                    System.out.println("Last Name: " + lName[maxIndex2]);
                    System.out.println("Grade: " + grade[maxIndex2]);
                    System.out.println("Absences: " + absence[maxIndex2] + "\n");
                    if (grade[maxIndex2] < 70)
                    {
                        if (absence[maxIndex2] >= 6)
                        {
                            System.out.println("WARNING! " + fName[maxIndex2] + " has a " + grade[maxIndex2] + " and " + absence[maxIndex2] + " absences. This number of absences may be hurting " + fName[maxIndex2] + "'s grade.\n");
                        }
                    }

                }
            }
            if (!bb)
            {
                System.out.println("\nThat is not a correctly formatted name of a student. Please enter in a student's first and last name.\n");
            }
        }
    }
}
