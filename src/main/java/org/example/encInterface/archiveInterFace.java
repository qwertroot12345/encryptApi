package org.example.encInterface;

import org.example.encEnum.compressEnum;

import java.io.File;

public interface archiveInterFace {

    //创建归档（空）
    boolean createArchive(compressEnum compressEnum);

    //创建归档（文从件）
    boolean compressFilesToArchive(compressEnum compressEnum,
                                   File[] files,
                                   boolean is_solid);

    //创建归档（文从件加密）
    boolean compressFilesToArchive(compressEnum compressEnum,
                                   File[] files,
                                   boolean is_solid,
                                   String password,
                                   boolean all_cfg_encryped);

    //往归档加文件
    boolean addFilesToArchive(compressEnum compressEnum,
                              File[] files);

    boolean addFilesToArchive(compressEnum compressEnum,
                              String password,
                              File[] files);

    //判断归档里面有没有某文件（文件名）
    boolean is_inArchie(File ArcFile,
                        String[] filename);
    boolean is_inArchie(File ArcFile,
                        String[] filename,
                        String password);

    //判断归档里面有没有某文件（crc）
    boolean is_inArchie(File ArcFile,
                        String crc32);
    boolean is_inArchie(File ArcFile,
                        String crc32,
                        String password);

    //从归档中删文件
    boolean deleteFileFromArchieve(File ArcFile,
                                   String filename);
    boolean deleteFileFromArchieve(File ArcFile,
                                   String filename,
                                   String password);

    //从已有归档加密为加密归档
    boolean encryptArchive(File ArcFile,
                           String password);
}
