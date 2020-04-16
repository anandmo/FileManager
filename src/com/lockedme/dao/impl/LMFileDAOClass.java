package com.lockedme.dao.impl;

import com.lockedme.dao.LMFileDAO;
import com.lockedme.model.LMFile;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

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

        //Set<String> fileNameSet = fileMap.keySet();

        List<String> fileNameSet = fileMap.keySet().stream().sorted().collect(Collectors.toList());

        for(String fileName : fileNameSet) {

            LMFile fileObj = fileMap.get(fileName);

            System.out.println("File Name : "+fileObj.getFileName()+", File Type : "+fileObj.getFileType()+", Created on : "+fileObj.getFileCreationTime());

        }

    }
}
