package com.lockedme.userinferface;

import com.lockedme.bo.impl.LMFileBOClass;
import com.lockedme.exception.LMFileException;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int user_input;

        System.out.println("Welcome to File Manager 2.0/n");
        System.out.println("1. List All File in root");
        System.out.println("2. Perform Operation");
        System.out.println("3. Exit\n");
        user_input = input.nextInt();

        switch (user_input) {

            case 1 :
                break;

            case 2 :

                System.out.println("1. Add file");
                System.out.println("2. Search file");
                System.out.println("3. Delete file");
                System.out.println("4. Main menu");
                user_input = input.nextInt();

                switch (user_input){

                    case 1 :
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


                break;

            case 3 :
                break;


                default:
                    System.out.println("Invalid input");

        }


        LMFileBOClass lmFileBOClass = new LMFileBOClass();
        try {
            System.out.println(lmFileBOClass.addLMFile("MyFile", "txt"));
            System.out.println(lmFileBOClass.searchLMFile("MyFile").getFileCreationTime());
        } catch (LMFileException exp){
            System.out.println("File not created");
        }
    }

}
