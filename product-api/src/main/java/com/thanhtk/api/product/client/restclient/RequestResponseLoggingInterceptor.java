package com.thanhtk.api.product.client.restclient;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

public class RequestResponseLoggingInterceptor implements ClientHttpRequestInterceptor {

    private static Log log = LogFactory.getLog(RequestResponseLoggingInterceptor.class);

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution) throws IOException {
        logRequest(request, body);
        ClientHttpResponse response = execution.execute(request, body);
        logResponse(response);

        //Add optional additional headers
//        response.getHeaders().add("headerName", "VALUE");
        return response;
    }

    private void logRequest(HttpRequest request, byte[] body) throws IOException {

        String pattern = "Request{---} URI %s, Method %s, Body %s, Headers %s";
        String message = String.format(pattern, request.getURI(), request.getMethod(), new String(body, "UTF-8"), request.getHeaders());
        log.debug(message);
        System.out.println(message);
    }

    private void logResponse(ClientHttpResponse response) throws IOException {

        String pattern = "Response{---} StatusCode %s, StatusCodeText %s, Body %s, Headers %s";
        String message = String.format(pattern, response.getStatusCode(), response.getStatusText(),
                StreamUtils.copyToString(response.getBody(), Charset.defaultCharset())
                , response.getHeaders());
        log.debug(message);
        System.out.println(message);



    }
}