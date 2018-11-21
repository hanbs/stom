package com.desonz.stom.word.controller;

import com.desonz.stom.word.service.WordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class WordController {

    @Autowired
    WordService wordService;

//    @GetMapping(value = "/selectWord")
//    public String selectWord(Model model, LoginModel vo) {
//        model.addAttribute("selectword", wordService.selectWord(vo));
//
//        return "word/select_word";
//    }
}