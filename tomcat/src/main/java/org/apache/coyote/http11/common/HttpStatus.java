package org.apache.coyote.http11.common;

public enum HttpStatus {

    OK("200"),
    FOUND("302"),
    UNAUTHORIZED("401"),
    NOT_FOUND("404"),
    INTERNAL_SERVER_ERROR("500");

    private final String statusCode;

    HttpStatus(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getHttpStatus() {
        return String.join(" ", statusCode, name());
    }

    public boolean isFound() {
        return this == FOUND;
    }

}
