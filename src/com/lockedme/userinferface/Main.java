package com.lockedme.userinferface;

import com.lockedme.bo.impl.LMFileBOClass;
import com.lockedme.exception.LMFileException;

import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static void main(String[] args) {

        LMFileBOClass lmFileBOClass = new LMFileBOClass();
        Scanner input = new Scanner(System.in);
        int user_input,user_input2;
        do {
            System.out.println(ANSI_YELLOW+"============Welcome to File Manager 1.0==================="+ANSI_RESET);
            System.out.println("1. List All File in root");
            System.out.println("2. Perform Operation");
            System.out.println("3. Exit");
            user_input = input.nextInt();

            switch (user_input) {

                case 1:
                    try {
                        lmFileBOClass.listAllFiles();
                    } catch (LMFileException exp) {
                        System.out.println("No Files");
                    }
                    break;

                case 2:
                    System.out.println(ANSI_YELLOW+"============Welcome to File Manager 1.0==================="+ANSI_RESET);
                    System.out.println("1. Add file");
                    System.out.println("2. Search file");
                    System.out.println("3. Delete file");
                    System.out.println("4. Main menu");
                    user_input2 = input.nextInt();
                    do {
                    switch (user_input2) {

                            case 1:
                                Scanner fileinput = new Scanner(System.in);
                                System.out.println("Enter filename");
                                String filename = fileinput.nextLine();
                                System.out.println("Enter filetype");
                                String filetype = fileinput.nextLine();

                                try {
                                    lmFileBOClass.addLMFile(filename, filetype);
                                } catch (LMFileException exp) {
                                    System.out.println("Not added");
                                }

                                break;

                            case 2:
                                break;

                            case 3:
                                break;

                            case 4:
                                break;

                            default:
                                System.out.println("Invalid input");

                        }
                    }while (user_input2 != 4);


                    break;

                case 3:
                    break;


                default:
                    System.out.println("Invalid input");

            }

        }while (user_input != 3);

    }

}
