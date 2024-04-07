package com.teamproject1.scuoledevelhope;

import com.teamproject1.scuoledevelhope.types.BaseResponse;
import com.teamproject1.scuoledevelhope.types.errors.BadRequestException;
import com.teamproject1.scuoledevelhope.types.errors.NotFoundException;
import com.teamproject1.scuoledevelhope.types.errors.NullValueException;
import com.teamproject1.scuoledevelhope.types.errors.SQLException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;

@RestControllerAdvice
public class Handler {
    @ExceptionHandler(BadRequestException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public BaseResponse badRequestHandler(BadRequestException e) {
        return new BaseResponse(HttpStatus.BAD_REQUEST, e.getMessage(), Arrays.toString(e.getStackTrace()));
    }

    @ExceptionHandler(NullValueException.class)
    @ResponseStatus(HttpStatus.NOT_EXTENDED)
    public BaseResponse nullValueHandler(NullValueException e) {
        return new BaseResponse(HttpStatus.NOT_ACCEPTABLE, e.getMessage(), Arrays.toString(e.getStackTrace()));
    }

    @ExceptionHandler(NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BaseResponse notFoundHandler(NotFoundException e) {
        return new BaseResponse(HttpStatus.NOT_FOUND, e.getMessage(), Arrays.toString(e.getStackTrace()));
    }

    @ExceptionHandler(SQLException.class)
    @ResponseStatus(HttpStatus.NOT_MODIFIED)
    public BaseResponse sqlExceptionHandler(SQLException e) {
        return new BaseResponse(HttpStatus.NOT_MODIFIED, e.getMessage(), Arrays.toString(e.getStackTrace()));
    }
}
