package com.study.api.common.file.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class File {

    @Id
    @GeneratedValue
    private Long fileId;
    private String filePath;
    private String originalFileName;
    private String saveFileName;
    private String fileExt;
    private Long fileSize;

    public static File createFile(String filePath, String originalFileName, String saveFileName, String fileExt, Long fileSize) {
        File file = new File();
        file.filePath = filePath;
        file.originalFileName = originalFileName;
        file.saveFileName = saveFileName;
        file.fileExt = fileExt;
        file.fileSize = fileSize;

        return file;
    }
}
