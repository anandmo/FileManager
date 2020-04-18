package com.lockedme.userinferface;

import com.lockedme.bo.impl.LMFileBOClass;
import com.lockedme.exception.LMFileException;
import com.lockedme.model.LMFile;

import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String filename,filetype;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
        boolean gotoMainMenu = false,exitApplication =false;
        LMFileBOClass lmFileBOClass = new LMFileBOClass();
        LMFile lmFile;
        Scanner input = new Scanner(System.in);
        Scanner fileinput = new Scanner(System.in);
        int user_input,user_input2 = 0;
        do {
            System.out.println("\t\t============LM Files 1.0===================");
            System.out.println("1. List All File in root");
            System.out.println("2. Perform Operation");
            System.out.println("3. About");
            System.out.println("4. Exit");
            try {
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
                        do {
                            System.out.println("\t\t============LM Files 1.0===================");
                            System.out.println("1. Add file");
                            System.out.println("2. Search file");
                            System.out.println("3. Delete file");
                            System.out.println("4. Delete Everything");
                            System.out.println("5. Main menu");
                            try {
                                user_input2 = input.nextInt();

                                switch (user_input2) {

                                    case 1:

                                        System.out.println("Enter filename");
                                        filename = fileinput.nextLine();
                                        System.out.println("Enter filetype");
                                        filetype = fileinput.nextLine();

                                        try {
                                            lmFileBOClass.addLMFile(filename, filetype);
                                        } catch (LMFileException exp) {
                                            System.out.println("Error will adding file");
                                        }

                                        break;

                                    case 2:
                                        System.out.println("Enter filename");
                                        filename = fileinput.nextLine();

                                        try {
                                            lmFile = lmFileBOClass.searchLMFile(filename);
                                            if (lmFile != null) {
                                                System.out.println("File Found with below details");
                                                System.out.println("File Name : " + lmFile.getFileName());
                                                System.out.println("File Type : " + lmFile.getFileType());
                                                System.out.println("Created on : " + lmFile.getFileCreationTime().format(dateTimeFormatter));
                                            } else
                                                System.out.println("File was not found");

                                        } catch (LMFileException exp) {
                                            System.out.println("Error will searching file");
                                        }

                                        break;

                                    case 3:
                                        System.out.println("Enter filename");
                                        filename = fileinput.nextLine();
                                        try {
                                            if (lmFileBOClass.deleteLMFile(filename))
                                                System.out.println("File deleted");
                                            else System.out.println("File was not found");

                                        } catch (LMFileException exp) {
                                            System.out.println("Error while deleting file");
                                        }

                                        break;

                                    case 4:
                                        try {
                                            if (lmFileBOClass.deleteAllLMFiles())
                                                System.out.println("Cleaned Root");
                                            else
                                                System.out.println("Root not found, Please make sure you have created files at least once.");
                                        } catch (LMFileException exp) {
                                            System.out.println("Error while cleaning root directory");
                                        }
                                        break;
                                    case 5:
                                        gotoMainMenu = true;
                                        break;


                                    default:
                                        System.out.println("Invalid input");

                                }

                            } catch (InputMismatchException excp) {
                                System.out.println("Invalid Input");
                                input = new Scanner(System.in);
                            }
                        } while (!gotoMainMenu);


                        break;

                    case 3:
                        System.out.println("Developed by : Anand Mohan");
                        break;

                    case 4:
                        exitApplication =  true;
                        break;

                    default:
                        System.out.println("Invalid input");
                }
            }catch (InputMismatchException excp){
                System.out.println("Invalid Input");
                input = new Scanner(System.in);}

        }while (!exitApplication);

    }

}
