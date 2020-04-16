package com.lockedme.bo.impl;

import com.lockedme.bo.LMFileBO;
import com.lockedme.dao.impl.LMFileDAOClass;
import com.lockedme.exception.LMFileException;
import com.lockedme.model.LMFile;

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
    public void deleteLMFile(String fileName) throws LMFileException {

    }

    @Override
    public LMFile searchLMFile(String fileName) throws LMFileException {
       LMFile lmFile =  lmFileDAOClass.findLMFileFromStorage(fileName);
       return lmFile;
    }

    @Override
    public void listAllFiles() throws LMFileException {

    }
}
