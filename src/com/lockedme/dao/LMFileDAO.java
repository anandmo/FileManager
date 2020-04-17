package com.lockedme.dao;

import com.lockedme.model.LMFile;

public interface LMFileDAO {

boolean addLMFileToStorage(LMFile lmFile);
LMFile findLMFileFromStorage(String fileName);
boolean deleteLMFileFromStorage(String fileName);
void displayAllLMFileFromStorage();
void deleteAllLMFileFromStorage();

}
