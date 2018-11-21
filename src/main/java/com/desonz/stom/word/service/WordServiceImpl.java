package com.desonz.stom.word.service;

import com.desonz.stom.member.model.LoginModel;
import com.desonz.stom.word.mapper.WordMapper;
import com.desonz.stom.word.model.WordModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class WordServiceImpl implements WordService{

    @Autowired
    WordMapper wordMapper;

//    @Override
//    public LoginModel selectWord(WordModel vo) {
//        Map <String, WordModel> map = new HashMap <>();
//        map.put("word", vo);
//        return wordMapper.selectWord();
//    }
}
