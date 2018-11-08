package com.company;

import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {

        Scanner fileScanner = new Scanner (new File("Imports.txt"));
        Scanner kbInput = new Scanner(System.in);

        int maxIndex1 = -1;
        int maxIndex2 = -1;
        boolean b = true;
        boolean bb;
        int numA = 0;
        int numB = 0;
        int numC = 0;
        int numD = 0;
        int numF = 0;
        String response;
        double totalGrades = 0;
        int grade[] = new int[1000];
        int absence[] = new int[1000];
        String fName[] = new String[1000];
        String lName[] = new String[1000];
        String g[] = new String[1000];
        String a[] = new String[1000];

        while (maxIndex1 < 24)
        {
            maxIndex1++;
            fName[maxIndex1] = "" + fileScanner.next();
            lName[maxIndex1] = "" + fileScanner.next();
            g[maxIndex1] = "" + fileScanner.next();
            a[maxIndex1] = "" + fileScanner.next();
            g[maxIndex1] = g[maxIndex1].substring(0, g[maxIndex1].length() - 1);
            grade[maxIndex1] = Integer.parseInt(g[maxIndex1]);
            absence[maxIndex1] = Integer.parseInt(a[maxIndex1]);
            totalGrades += grade[maxIndex1];

            if (grade[maxIndex1] >= 90)
            {
                numA++;
            }

            else if (grade[maxIndex1] >= 80)
            {
                numB++;
            }

            else if (grade[maxIndex1] >= 70)
            {
                numC++;
            }

            else if (grade[maxIndex1] >= 60)
            {
                numD++;
            }

            else
            {
                numF++;
            }
        }

        fileScanner.close();

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
