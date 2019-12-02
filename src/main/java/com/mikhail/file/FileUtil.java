package com.mikhail.file;

import org.apache.tika.detect.Detector;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.mime.MimeType;
import org.apache.tika.mime.MimeTypeException;
import org.apache.tika.mime.MimeTypes;
import org.apache.tika.parser.AutoDetectParser;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Optional;

@Component
public class FileUtil {

    public static String getMimeType(MultipartFile file) {
        Optional<String> type;
        try (BufferedInputStream bis = new BufferedInputStream(file.getInputStream())) {
            AutoDetectParser parser = new AutoDetectParser();
            Detector detector = parser.getDetector();
            Metadata metadata = new Metadata();
            metadata.add(Metadata.RESOURCE_NAME_KEY, file.getOriginalFilename());
            metadata.add(Metadata.CONTENT_TYPE, file.getContentType());
            type = Optional.ofNullable(detector.detect(bis, metadata).toString());
        } catch (IOException e) {
            throw new RuntimeException("Error getting file mime type. " + e.getMessage());
        }

        return type.orElseThrow(() -> new RuntimeException("Error getting file mime type"));
    }

    public static String trimFileExtension(String value) {
        int formatIndex = value.lastIndexOf(".");
        return value.substring(0, formatIndex != -1 ? formatIndex : value.length());
    }

    public static String encodeUTF8(String value) {
        try {
            return URLEncoder.encode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("Error UTF8 encoding. " + e.getMessage());
        }
    }

    public static String decodeUtf8(String value) {
        try {
            return URLDecoder.decode(value, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            throw new AssertionError("Error UTF8 decoding. " + e.getMessage());
        }
    }

    public static String getFileExtension(String mimeType) {
        MimeTypes allTypes = MimeTypes.getDefaultMimeTypes();
        Optional<MimeType> type;
        try {
            type = Optional.ofNullable(allTypes.forName(mimeType));
        } catch (MimeTypeException e) {
            throw new RuntimeException("Error getting file extension. " + e.getMessage());
        }

        return type.orElseThrow(() -> new RuntimeException("Error getting file extension."))
                .getExtension();
    }

    public static String getFilenameWithExtension(String filename, String mimeType) {
        if (filename.isEmpty()) {
            return "";
        }
        return encodeUTF8(replaceInvalidCharacters(trimFileExtension(filename)) + getFileExtension(mimeType));
    }

    private static String replaceInvalidCharacters(String value) {
        Optional<String> valid = Optional.ofNullable(value);
        if (valid.orElseThrow(() -> new RuntimeException("Empty string!")).isEmpty()) {
            valid = valid.map(v -> v.replace(",", "_")
                    .replace(";", "_")
                    .replace("+", "_")
                    .replace(" ", "_"));
        }
        return valid.orElseThrow(() -> new RuntimeException("Error replacing invalid characters."));
    }
}
