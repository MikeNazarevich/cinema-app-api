package com.mikhail.web.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.io.Serializable;

@AllArgsConstructor
@Getter
public class FieldError implements Serializable {

    private final String objectName;

    private final String field;

    private final String message;
}
