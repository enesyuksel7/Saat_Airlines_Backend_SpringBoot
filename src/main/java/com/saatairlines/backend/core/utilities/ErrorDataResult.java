package com.saatairlines.backend.core.utilities;

public class ErrorDataResult<T> extends DataResult{

    public ErrorDataResult(){
        super(null, false);
    }

    public ErrorDataResult(T data) {
        super(data, false);
    }

    public ErrorDataResult(Object data, String message) {
        super(data, false, message);
    }
}