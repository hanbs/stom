package com.desonz.stom.member.LoginService;

import com.desonz.stom.member.LoginModel.LoginModel;

import javax.servlet.http.HttpSession;

public interface LoginService {

    // 로그인
    LoginModel loginCheck(String user_id, String user_pw);

    // 로그아웃
    void logout(HttpSession session);

}