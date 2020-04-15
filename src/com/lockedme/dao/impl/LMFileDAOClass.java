package com.lockedme.dao.impl;

import com.lockedme.dao.LMFileDAO;
import com.lockedme.model.LMFile;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class LMFileDAOClass implements LMFileDAO {

    Map<String,LMFile> fileMap = new LinkedHashMap<>();

    @Override
    public boolean addLMFileToStorage(LMFile lmFile) {
        if(findLMFileFromStorage(lmFile.getFileName()) == null) {
            fileMap.put(lmFile.getFileName().toLowerCase(), lmFile);
            return true;
        }
        return false;
    }

    @Override
    public LMFile findLMFileFromStorage(String fileName) {

        Set set = fileMap.entrySet();
        Iterator iterator = set.iterator();

        while (iterator.hasNext()){
            Map.Entry mapEntry = (Map.Entry)iterator.next();
            if(mapEntry.getKey() == fileName.toLowerCase())
                return (LMFile)iterator.next();
        }

        return null;
    }

    @Override
    public boolean deleteLMFileFromStorage(String fileName) {
        return false;
    }

    @Override
    public void displayAllLMFileFromStorage() {

    }
}
