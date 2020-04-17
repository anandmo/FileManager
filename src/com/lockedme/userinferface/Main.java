package com.lockedme.userinferface;

import com.lockedme.bo.impl.LMFileBOClass;
import com.lockedme.exception.LMFileException;
import com.lockedme.model.LMFile;

import java.util.Scanner;

public class Main {

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";


    public static void main(String[] args) {

        String filename,filetype;
        LMFileBOClass lmFileBOClass = new LMFileBOClass();
        LMFile lmFile;
        Scanner input = new Scanner(System.in);
        Scanner fileinput = new Scanner(System.in);
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
                    do {
                    System.out.println(ANSI_YELLOW+"============Welcome to File Manager 1.0==================="+ANSI_RESET);
                    System.out.println("1. Add file");
                    System.out.println("2. Search file");
                    System.out.println("3. Delete file");
                    System.out.println("4. Delete Everything");
                    System.out.println("5. Main menu");
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
                                    if (lmFile != null){
                                        System.out.println("File Found with below details");
                                        System.out.println("File Name : "+lmFile.getFileName());
                                        System.out.println("File Type : "+lmFile.getFileType());
                                        System.out.println("Created on : "+lmFile.getFileCreationTime());
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
                                    if(lmFileBOClass.deleteLMFile(filename))
                                        System.out.println("File deleted");
                                    else System.out.println("File was not found");

                                }catch (LMFileException exp){
                                    System.out.println("Error while deleting file");
                                }

                                break;

                        case 4:
                            try {
                                if(lmFileBOClass.deleteAllLMFiles())
                                    System.out.println("Cleaned Root");
                                else System.out.println("Root not found, Please make sure you have created files at least once.");
                            } catch (LMFileException exp){
                                System.out.println("Error while cleaning root directory");
                            }

                            case 5:
                                break;



                            default:
                                System.out.println("Invalid input");

                        }
                    }while (user_input2 != 5);


                    break;

                case 3:
                    break;


                default:
                    System.out.println("Invalid input");

            }

        }while (user_input != 3);

    }

}
