package com.lockedme.bo.impl;

import java.io.File;

public class LMDirectory {

    private String fileSeparator = System.getProperty("file.separator");
   // private String root = "C:"+fileSeparator+"FileManager"+fileSeparator+"root";
   private String root = "C:"+fileSeparator+"Users"+fileSeparator+"Anand Mohan"+fileSeparator+"FileManager";

    public boolean createRootDirectory() {
        File file = new File(root);
        return file.mkdir();
    }

    public boolean createRootDirectory(String drive,String folderName) {
        String customPath = drive+fileSeparator+folderName;
        root = customPath;
        File file = new File(customPath);
        return file.mkdir();

    }

    public String getRoot() {
        return root;
    }
}
