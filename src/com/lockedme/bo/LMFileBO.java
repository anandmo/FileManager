 package com.lockedme.bo;

 import com.lockedme.exception.LMFileException;
 import com.lockedme.model.LMFile;

 public interface LMFileBO {

  public boolean addLMFile(String fileName,String fileType) throws LMFileException;
  public boolean deleteLMFile(String fileName) throws LMFileException;
  public LMFile searchLMFile(String fileName) throws LMFileException;
  public void listAllFiles() throws LMFileException;
  public boolean deleteAllLMFiles()throws LMFileException;

}
