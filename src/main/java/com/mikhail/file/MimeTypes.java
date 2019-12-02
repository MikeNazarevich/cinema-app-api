package com.mikhail.file;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MimeTypes {

    public static final Set<String> SUPPORTED_PHOTO_TYPES = initializePhotoTypes();

    private static Set<String> initializePhotoTypes() {
        return Collections.unmodifiableSet(Stream.of(
                "image/jpeg", //.jpeg, .jpg
                "image/png", //.png
                "image/gif", //.gif
                "image/bmp") //.bmp
                .collect(Collectors.toSet()));
    }
}
