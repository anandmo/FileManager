package com.lockedme.bo.impl;

import java.io.File;

public class LMDirectory {

    String fileSeparator = System.getProperty("file.separator");
    String root = "C:"+fileSeparator+"FileManager"+fileSeparator+"root";

    public  boolean createRootDirectory() {
        File file = new File(root);
        return file.mkdir();
    }

    public boolean createRootDirectory(String drive,String folderName) {

        String customPath = drive+fileSeparator+folderName;
        File file = new File(customPath);

        return file.mkdir();

    }

}
