package com.mikhail.movieFile.impl;

import com.mikhail.file.FileService;
import com.mikhail.file.FileUtil;
import com.mikhail.movieFile.MovieFile;
import com.mikhail.movieFile.MovieFileService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovieFileServiceImpl implements MovieFileService {

    private static final String FILES_URL_WITH_PATH_PARAM = "/files?filePath=";

    private final FileService fileService;
    private final MovieFileRepository repository;

    @Override
    public MovieFile addMovieFile(MultipartFile image) {
        String relativePath = fileService.save(image);

        MovieFile movieFile = new MovieFile()
                .setName(FileUtil.trimFileExtension(image.getOriginalFilename()))
                .setMimeType(FileUtil.getMimeType(image))
                .setUrl(FILES_URL_WITH_PATH_PARAM + FileUtil.encodeUTF8(relativePath))
                .setFilePath(relativePath);

        return repository.save(movieFile);
    }

    @Override
    public MovieFile updateMovieFile(String url, MultipartFile file) {
        String relativePath = fileService.save(file);

        if (url != null)
            deleteMovieFile(url);

        MovieFile movieFile = new MovieFile()
                .setName(FileUtil.trimFileExtension(file.getOriginalFilename()))
                .setFilePath(relativePath)
                .setUrl(FILES_URL_WITH_PATH_PARAM + FileUtil.encodeUTF8(relativePath))
                .setMimeType(FileUtil.getMimeType(file));

        return repository.save(movieFile);
    }

    @Override
    public void deleteMovieFile(@NotNull String url) {
        MovieFile movieFile = repository.findByUrl(url);
        repository.delete(movieFile);
        fileService.delete(movieFile.getFilePath());
    }

    @Override
    public Optional<MovieFile> findByPath(String path) {
        return repository.findByFilePath(path);
    }
}
