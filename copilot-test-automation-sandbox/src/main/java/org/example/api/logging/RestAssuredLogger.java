package org.example.api.logging;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.specification.RequestSpecification;
import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Arrays;

@UtilityClass
@Slf4j
public class RestAssuredLogger {
    private final PrintStream globalPrintStream;

    static {
        OutputStream output = new OutputStream() {
            private StringBuilder stringBuilder = new StringBuilder();

            @Override
            public void write(int b) {
                this.stringBuilder.append((char) b);
            }

            @Override
            public void flush() {
                var msg = this.stringBuilder.toString();
                if (!msg.isEmpty() && !msg.equals("\r\n")) {
                    log.info(msg);
                }
                stringBuilder = new StringBuilder();
            }
        };
        globalPrintStream = new PrintStream(output, true);
    }

    public RequestSpecification givenWithLogging() {
        return RestAssured
                .given()
                .filters(Arrays.asList(
                        new RequestLoggingFilter(getGlobalPrintStream()),
                        new ResponseLoggingFilter(getGlobalPrintStream()))
                );
    }

    public PrintStream getGlobalPrintStream() {
        return globalPrintStream;
    }
}