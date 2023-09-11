package org.apache.coyote.http11.response;

import org.apache.coyote.http11.common.HttpCookie;
import org.apache.coyote.http11.common.HttpHeaders;
import org.apache.coyote.http11.common.HttpStatus;
import org.apache.coyote.http11.common.HttpVersion;

public class HttpResponse {

    private static final String CRLF = "\r\n";

    private final HttpVersion httpVersion;
    private final HttpHeaders responseHeaders;
    private HttpStatus httpStatus;
    private ResponseBody responseBody;
    private String path;

    public HttpResponse(HttpVersion httpVersion) {
        this.httpVersion = httpVersion;
        this.responseHeaders = HttpHeaders.createResponseHeaders();
    }

    public boolean isFound() {
        return httpStatus.isFound();
    }

    public String extractResponse() {
        return new StringBuilder()
                .append(convertStatusLine()).append(CRLF)
                .append(responseHeaders.convertResponseHeaders()).append(CRLF)
                .append(responseBody.getBody())
                .toString();
    }

    private String convertStatusLine() {
        return String.format("%s %s ", httpVersion.getVersion(), httpStatus.getHttpStatus());
    }

    public HttpResponse setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
        return this;
    }

    public HttpResponse setPath(String path) {
        this.path = path;
        return this;
    }

    public void setCookie(HttpCookie httpCookie) {
        responseHeaders.addCookies(httpCookie);
    }

    public String getPath() {
        return path;
    }

    public HttpResponse addHeader(String key, String value) {
        responseHeaders.addHeader(key, value);
        return this;
    }

    public void setResponseBody(ResponseBody responseBody) {
        this.responseBody = responseBody;
    }

    @Override
    public String toString() {
        return "HttpResponse{" +
                "responseHeaders=" + responseHeaders +
                '}';
    }
}
