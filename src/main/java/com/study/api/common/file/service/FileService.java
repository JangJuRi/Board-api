package com.study.api.common.file.service;

import com.study.api.common.file.entity.File;
import com.study.api.common.file.repository.FileRepository;
import com.study.util.FileUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class FileService {
    private final FileRepository fileRepository;
    private final FileUtil fileUtil;

    public File uploadFile(MultipartFile file, String uploadPath) throws Exception {
        File fileEntity = fileUtil.uploadFile(file, uploadPath);

        fileRepository.save(fileEntity);

        return fileEntity;
    }
}
