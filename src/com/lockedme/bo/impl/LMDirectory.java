package com.lockedme.bo.impl;

import java.io.File;

public class LMDirectory {

    private String fileSeparator = System.getProperty("file.separator");
    private String root;

   public LMDirectory(){
      String userProfile = System.getenv("USERPROFILE");
      root = userProfile+fileSeparator+"FileManager";
   }

    public boolean createRootDirectory() {
        File file = new File(root);
        return file.mkdir();
    }

    public String getRoot() {
        return root;
    }

    public boolean deleteRootDirectory(){
        File fileDirectory = new File(root);

        String[] files = fileDirectory.list();
        File currentFile;
        if(files != null){
        for(String file : files){
            currentFile = new File(root,file);
            currentFile.delete();
        } } else {
            System.out.println("No root directory found");
        }

        return fileDirectory.delete();
    }
}
