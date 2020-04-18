package com.lockedme.dao.impl;

import com.lockedme.dao.LMFileDAO;
import com.lockedme.model.LMFile;

import java.io.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LMFileDAOClass implements LMFileDAO {

    private Map<String,LMFile> fileMap =  null;

    public LMFileDAOClass(){
        fetchFileMap();
        if(fileMap == null){
            fileMap = new LinkedHashMap<>();
        }
    }

    @Override
    public boolean addLMFileToStorage(LMFile lmFile) {

        if(fileMap != null){
        if(!fileMap.containsKey(lmFile.getFileName().toLowerCase())) {
            fileMap.put(lmFile.getFileName().toLowerCase(), lmFile);
            persistFileMap();
            return true;
        } } else {
            fileMap = new LinkedHashMap<>();
            fileMap.put(lmFile.getFileName().toLowerCase(), lmFile);
            persistFileMap();
            return true;
        }
        return false;
    }

    @Override
    public LMFile findLMFileFromStorage(String fileName) {
        if(fileMap != null)
        return fileMap.get(fileName.toLowerCase());
        else
            return null;
    }

    @Override
    public boolean deleteLMFileFromStorage(String fileName) {

        if(fileMap.remove(fileName.toLowerCase(),fileMap.get(fileName.toLowerCase()))) {
            persistFileMap();
            return true;
        }
        return false;
    }

    @Override
    public void displayAllLMFileFromStorage() {

        if(fileMap == null || fileMap.isEmpty()) {
            System.out.println("No Files to display");
        } else {

            List<String> fileNameSet = fileMap.keySet().stream().sorted().collect(Collectors.toList());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);

            for (String fileName : fileNameSet) {

                LMFile fileObj = fileMap.get(fileName);

                System.out.println("File Name : " + fileObj.getFileName() + ", File Type : " + fileObj.getFileType() + ", Created on : " + fileObj.getFileCreationTime().format(dateTimeFormatter));

            }
        }

    }

    @Override
    public void deleteAllLMFileFromStorage() {
        fileMap = null;
        persistFileMap();
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
