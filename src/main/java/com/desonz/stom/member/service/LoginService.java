package com.desonz.stom.member.service;

import com.desonz.stom.member.model.LoginModel;

public interface LoginService {

    // 로그인
    LoginModel loginCheck(String user_id, String user_pw);

    // 회원가입
    void join(LoginModel vo);

}