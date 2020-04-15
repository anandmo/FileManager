package com.lockedme.userinferface;

import com.lockedme.bo.impl.LMFileBOClass;
import com.lockedme.exception.LMFileException;

public class Main {

    public static void main(String[] args) {

        LMFileBOClass lmFileBOClass = new LMFileBOClass();
        try {
            lmFileBOClass.addLMFile("MyFile", "txt");
        } catch (LMFileException exp){
            System.out.println("File not created");
        }
    }

}
