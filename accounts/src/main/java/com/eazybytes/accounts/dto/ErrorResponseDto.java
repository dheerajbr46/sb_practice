package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Schema(
        name = "ErrorResponse",
        description = "Schema to hold error response details"
)
public record ErrorResponseDto(
        @Schema(
                description = "API path where the error occurred"
        )
        String apiPath,

        @Schema(
                description = "HTTP status code representing the error"
        )
        HttpStatus errorCode,

        @Schema(
                description = "Detailed error message"
        )
        String errorMessage,

        @Schema(
                description = "Timestamp when the error occurred"
        )
        LocalDateTime errorTime) {
}
