package com.lockedme.bo.impl;

import com.lockedme.bo.LMFileBO;
import com.lockedme.exception.LMFileException;
import com.lockedme.model.LMFile;

public class LMFileBOClass implements LMFileBO {

    private LMDirectory lmDirectory = new LMDirectory();

    @Override
    public boolean addLMFile(String fileName,String fileType) throws LMFileException {

        if(!lmDirectory.createRootDirectory()) {
            LMFile lmFile = new LMFile(fileName,fileType,lmDirectory.getRoot());
            return true;
        }
        return false;
    }

    @Override
    public void deleteLMFile(String fileName) throws LMFileException {

    }

    @Override
    public LMFile searchLMFile(String fileName) throws LMFileException {
        return null;
    }

    @Override
    public void listAllFiles() throws LMFileException {

    }
}
