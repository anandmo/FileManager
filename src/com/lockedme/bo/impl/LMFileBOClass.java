package com.lockedme.bo.impl;

import com.lockedme.bo.LMFileBO;
import com.lockedme.dao.impl.LMFileDAOClass;
import com.lockedme.exception.LMFileException;
import com.lockedme.model.LMFile;

import java.io.File;

public class LMFileBOClass implements LMFileBO {

    private LMDirectory lmDirectory = new LMDirectory();
    private LMFileDAOClass lmFileDAOClass = new LMFileDAOClass();

    @Override
    public boolean addLMFile(String fileName,String fileType) throws LMFileException {

        boolean isRoot = lmDirectory.createRootDirectory();
        if(!isRoot) {
            LMFile lmFile = new LMFile(fileName,fileType,lmDirectory.getRoot());
            System.out.println(lmFileDAOClass.addLMFileToStorage(lmFile));
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteLMFile(String fileName) throws LMFileException {

        File file = new File(lmFileDAOClass.findLMFileFromStorage(fileName).getFilePath());
        if(file.delete() && lmFileDAOClass.deleteLMFileFromStorage(fileName))
            return true;

        return false;
    }

    @Override
    public LMFile searchLMFile(String fileName) throws LMFileException {
       LMFile lmFile =  lmFileDAOClass.findLMFileFromStorage(fileName);
       return lmFile;
    }

    @Override
    public void listAllFiles() throws LMFileException {

        lmFileDAOClass.displayAllLMFileFromStorage();

    }

    @Override
    public boolean deleteAllLMFiles() throws LMFileException{

        File file = new File(lmDirectory.getRoot());
        lmFileDAOClass.deleteAllLMFileFromStorage();
        return file.delete();

    }
}
