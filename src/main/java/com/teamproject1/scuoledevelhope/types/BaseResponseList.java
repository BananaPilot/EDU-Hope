package com.teamproject1.scuoledevelhope.types;

import java.util.List;

public class BaseResponseList <T> extends BaseResponse{
    List<T> elements;

    public BaseResponseList(){

    }

    public BaseResponseList(List<T> elements){
        this.elements = elements;
    }

    public List<T> getElements() {
        return elements;
    }
}
