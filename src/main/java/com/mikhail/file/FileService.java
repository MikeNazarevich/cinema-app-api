package com.mikhail.file;

import com.mikhail.movieFile.MovieFile;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;

public interface FileService {

    String save(MultipartFile file);

    String update(MultipartFile file, String oldRelativePath);

    void delete(String relativePath);

    void export(MovieFile movieFile, HttpServletResponse response);

    String validPath(String relativePath);
}
