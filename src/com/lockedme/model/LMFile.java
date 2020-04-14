package com.lockedme.model;

import java.time.LocalDateTime;

public class LMFile {

    private LocalDateTime fileCreationTime, lastModificationTime;
    private String fileType, fileName, filePath;
    private double fileSize;

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
