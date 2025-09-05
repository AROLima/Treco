package br.senac.trecos.exception;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@AllArgsConstructor
public class ApiError {
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private OffsetDateTime timestamp;
    private int status;
    private String error;
    private String message;
    private String path;

}
