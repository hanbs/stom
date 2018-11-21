package com.desonz.stom.member.LoginService;

import javax.servlet.http.HttpSession;
import java.util.List;

public interface LoginService {

    // 로그인
    List loginCheck(String user_id, String user_pw);

    // 로그아웃
    void logout(HttpSession session);

}