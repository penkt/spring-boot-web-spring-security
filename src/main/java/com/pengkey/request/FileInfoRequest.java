package com.pengkey.request;

import com.pengkey.model.Resource;

public class FileInfoRequest extends Resource{
    //文件
    private String fileType;
    private String fileName;
    private String fileDir;
    private String simpleFileName;
    private String fileSuffix;

    public FileInfoRequest() {
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

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }

    public String getSimpleFileName() {
        return simpleFileName;
    }

    public void setSimpleFileName(String simpleFileName) {
        this.simpleFileName = simpleFileName;
    }

    public String getFileSuffix() {
        return fileSuffix;
    }

    public void setFileSuffix(String fileSuffix) {
        this.fileSuffix = fileSuffix;
    }
}
