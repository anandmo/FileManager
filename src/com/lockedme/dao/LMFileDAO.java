package com.lockedme.dao;

import com.lockedme.model.LMFile;

public interface LMFileDAO {

boolean addLMFiletToStorage(LMFile lmFile);
boolean findLMFileFromStorage(String fileName);
boolean deleteLMFileFromStorage(String fileName);
void displayAllLMFileFromStorage();


}
