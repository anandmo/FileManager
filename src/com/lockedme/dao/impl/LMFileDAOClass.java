package com.lockedme.dao.impl;

import com.lockedme.dao.LMFileDAO;
import com.lockedme.model.LMFile;

import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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

        if(fileMap.remove(fileName.toLowerCase(),fileMap.get(fileName.toLowerCase())))
            return true;

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

    private void persistFileMap() {

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("data.lmfdb");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(fileMap);
            objectOutputStream.close();
            fileOutputStream.close();
        }catch (FileNotFoundException exp){
             System.out.println("LM Database not found");
        }catch (IOException exp){
            System.out.println("Error while persisting data");
        }
    }

    private void fetchFileMap(){

        try {
            FileInputStream fileInputStream = new FileInputStream("data.lmfdb");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
            fileMap = (LinkedHashMap)objectInputStream.readObject();
            objectInputStream.close();
            fileInputStream.close();

        }catch(FileNotFoundException exp) {
            System.out.println("LM Database not found");
        }catch (IOException exp){
            System.out.println("Error while fetching data");
        }catch (ClassNotFoundException exp){
            System.out.println("No data found on database");
        }


    }

}
