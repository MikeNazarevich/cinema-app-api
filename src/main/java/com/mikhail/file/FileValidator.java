package com.mikhail.file;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class FileValidator {
    public void validate(MultipartFile file) {
        checkMimeType(file);
        checkFileSize(file);
    }

    private void checkMimeType(MultipartFile file) {

        String mimeType = FileUtil.getMimeType(file);

        if (!MimeTypes.SUPPORTED_PHOTO_TYPES.contains(mimeType)) {
            throw new RuntimeException("Unsupported image type: mimeType");
        }
    }

    private void checkFileSize(MultipartFile file) {
        long maxFileSizeMb = 3;
        long maxFileSizeByte = maxFileSizeMb * 1024 * 1024;

        if (file.getSize() > maxFileSizeByte) {
            throw new RuntimeException("The maximum file size has been exceeded. Maximum file size: size 3Mb");
        }
    }
}
