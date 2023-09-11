package nextstep.jwp.controller;

import org.apache.coyote.http11.common.HttpStatus;
import org.apache.coyote.http11.controller.Controller;
import org.apache.coyote.http11.request.HttpRequest;
import org.apache.coyote.http11.response.HttpResponse;

public class NotFoundController implements Controller {

    @Override
    public void service(HttpRequest httpRequest, HttpResponse httpResponse) {
        httpResponse.setHttpStatus(HttpStatus.NOT_FOUND)
                .setPath("/404");
    }
}
