package com.example.typing.services;

import com.example.typing.domain.Result;

public interface ResultService {
    void addResult(Result result);
    String getStringDate();
    String getStringResult(long number, String text);
}
