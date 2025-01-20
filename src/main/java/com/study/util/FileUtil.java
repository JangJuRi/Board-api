package com.study.util;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

@Component
@RequiredArgsConstructor
public class FileUtil {

    @Value("${file.upload.dir}")
    private String serverFilePath;

    // 단일 파일 업로드
    public com.study.api.common.file.entity.File uploadFile(MultipartFile file, String uploadPath) throws Exception {
        if (file.getSize() != 0) {
            String uuid = UUID.randomUUID().toString();
            String originalFileName = file.getOriginalFilename();
            String ext = extractExt(originalFileName);
            String saveFileName = uuid + "." + ext;
            String filePath = uploadPath + "/" + saveFileName;

            String uploadFilePath = serverFilePath + filePath;

            File uploadFile = new File(uploadFilePath);

            if (!uploadFile.exists()) {
                uploadFile.mkdirs();
            }

            Path path = Paths.get(uploadFilePath).toAbsolutePath();

            file.transferTo(path.toFile());

            return com.study.api.common.file.entity.File.createFile(filePath, originalFileName, saveFileName, ext, file.getSize());

        } else {
            return null;
        }
    }

    // 파일 확장자 추출
    public String extractExt(String fileName) {
        return fileName.substring(fileName.lastIndexOf(".") + 1);
    }
}
