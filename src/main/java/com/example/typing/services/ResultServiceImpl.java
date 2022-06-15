package com.example.typing.services;

import com.example.typing.domain.Result;
import com.example.typing.repos.ResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class ResultServiceImpl implements ResultService {
    @Autowired
    private ResultRepository resultRepository;

    @Override
    public void addResult(Result result){
        resultRepository.save(result);
    }

    @Override
    public  String getStringDate(){
        Date date = new Date();
        DateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        return dateFormat.format(date);
    }

    @Override
    public String getStringResult(long time, String text) {
        double numInM = (double) time/60;
        String res = "Символов в минуту: " + Math.round(text.length()/numInM);
        return res;
    }
}
