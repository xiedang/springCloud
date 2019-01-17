package com.xiedang.file.vo;


import com.xiedang.file.model.BillFiles;

/**
 * <p></p>
 *
 * @author : 谢当
 * @date : 2018/12/27 16:40
 */
public class FilesVo extends BillFiles {

    /**
     * 上传的文件夹名称
     */
    private String fileDir;

    public String getFileDir() {
        return fileDir;
    }

    public void setFileDir(String fileDir) {
        this.fileDir = fileDir;
    }
}
