package com.mikhail.web;

import com.mikhail.file.FileService;
import com.mikhail.movieFile.MovieFile;
import com.mikhail.movieFile.MovieFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/files")
@RequiredArgsConstructor
public class FileController {

    private final FileService fileService;
    private final MovieFileService movieFileService;

    @GetMapping
    ResponseEntity<Void> download(String url, HttpServletResponse response) {
        String path = fileService.validPath(url);
        MovieFile movieFile = movieFileService.findByPath(path)
                .orElseThrow(() -> new IllegalArgumentException("Not found"));

        fileService.export(movieFile, response);
        return ResponseEntity.ok().build();
    }
}
