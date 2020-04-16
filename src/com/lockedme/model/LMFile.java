package com.lockedme.model;

import com.lockedme.exception.LMFileException;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDateTime;

public class LMFile implements Serializable {

    private LocalDateTime fileCreationTime, lastModificationTime;
    private String fileType, fileName, filePath;
    private double fileSize;
    private String fileSeparator = System.getProperty("file.separator");

    public LMFile(String fileName,String fileType,String filePath) throws LMFileException{
        String absolutePath = filePath+fileSeparator+fileName+"."+fileType;
        System.out.println(absolutePath);
        File file = new File(absolutePath);
        this.fileCreationTime = LocalDateTime.now();
        this.fileName = fileName;
        this.fileType = fileType;
        this.filePath = absolutePath;
        try {
            if (!file.createNewFile()) throw new LMFileException();
        } catch (IOException exp){
            System.out.println("File cannot be Created");
        }
    }

    public LocalDateTime getFileCreationTime() {
        return fileCreationTime;
    }

    public void setFileCreationTime(LocalDateTime fileCreationTime) {
        this.fileCreationTime = fileCreationTime;
    }

    public LocalDateTime getLastModificationTime() {
        return lastModificationTime;
    }

    public void setLastModificationTime(LocalDateTime lastModificationTime) {
        this.lastModificationTime = lastModificationTime;
    }

    public String getFileType() {
        return fileType;
    }

    public void setFileType(String fileType) {
        this.fileType = fileType;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFileSize(double fileSize) {
        this.fileSize = fileSize;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public double getFileSize() {
        return fileSize;
    }


}
