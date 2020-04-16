package com.lockedme.dao.impl;

import com.lockedme.dao.LMFileDAO;
import com.lockedme.model.LMFile;

import java.util.LinkedHashMap;
import java.util.Map;

public class LMFileDAOClass implements LMFileDAO {

    private Map<String,LMFile> fileMap = new LinkedHashMap<>();

    @Override
    public boolean addLMFileToStorage(LMFile lmFile) {
        if(!fileMap.containsKey(lmFile.getFileName().toLowerCase())) {
            fileMap.put(lmFile.getFileName().toLowerCase(), lmFile);
            return true;
        }
        return false;
    }

    @Override
    public LMFile findLMFileFromStorage(String fileName) {
        return fileMap.get(fileName.toLowerCase());
    }

    @Override
    public boolean deleteLMFileFromStorage(String fileName) {
        return false;
    }

    @Override
    public void displayAllLMFileFromStorage() {

    }
}
