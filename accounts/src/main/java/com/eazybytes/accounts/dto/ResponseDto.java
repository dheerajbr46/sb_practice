package com.eazybytes.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;

@Schema(
        name = "Response",
        description = "Schema to hold response status code and message"
)
public record ResponseDto(
        @Schema(
                description = "HTTP status code of the response"
        )
        String statusCode,

        @Schema(
                description = "Detailed message about the response"
        )
        String statusMessage) {
}
