package com.mikhail.file.impl;

import com.mikhail.file.FileService;
import com.mikhail.file.FileUtil;
import com.mikhail.file.FileValidator;
import com.mikhail.movieFile.MovieFile;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDate;
import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_OCTET_STREAM_VALUE;

@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    @Value("${com.mikhail.cinema.file.uploadRootPath}")
    private String uploadRootPath;

    private final FileValidator fileValidator;

    @Override
    public String save(MultipartFile file) {
        fileValidator.validate(file);

        String relativePath = LocalDate.now().toString() + "/" + UUID.randomUUID();
        final Path storePath = Paths.get(uploadRootPath + relativePath);

        try {
            Files.createDirectories(storePath);
            Files.copy(file.getInputStream(), storePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while saving the file." + e.getMessage());
        }

        return relativePath;
    }

    @Override
    public String update(MultipartFile file, String oldRelativePath) {
        delete(oldRelativePath);
        return save(file);
    }

    @Override
    public void delete(String relativePath) {
        String decodePath = FileUtil.decodeUtf8(relativePath);
        Path path = Paths.get(uploadRootPath + FileUtil.trimFileExtension(decodePath));

        try {
            Files.delete(path);
        } catch (IOException e) {
            throw new RuntimeException("An error occurred while deleting the file." + e.getMessage());
        }
    }

    public String validPath(String relativePath) {
        String validRelativePath = FileUtil.trimFileExtension(relativePath);
        validRelativePath = FileUtil.decodeUtf8(validRelativePath);

        return validRelativePath;
    }

    @Override
    public void export(@NotNull MovieFile movieFile, HttpServletResponse response) {
        Path absolutePath = Paths.get(uploadRootPath + movieFile.getFilePath());
        String mimeType = movieFile.getMimeType();

        try {
            response.setContentType(mimeType != null ? mimeType : APPLICATION_OCTET_STREAM_VALUE);
            response.setContentLength((int) Files.size(absolutePath));
            ServletOutputStream servletOutputStream = response.getOutputStream();
            Files.copy(absolutePath, servletOutputStream);
        } catch (IOException e) {
            throw new RuntimeException("Can't load file");
        }
    }
}
