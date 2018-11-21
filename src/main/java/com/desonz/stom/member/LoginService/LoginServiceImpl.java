package com.desonz.stom.member.LoginService;

import com.desonz.stom.member.LoginMapper.LoginMapper;
import com.desonz.stom.member.LoginModel.LoginModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.List;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    // 로그인
    public List<LoginModel> loginCheck(String user_id, String user_pw) {
        log.info("serviceimpl >> "+String.valueOf(loginMapper.loginCheck(user_id,user_pw)));
        return loginMapper.loginCheck(user_id,user_pw);
    }

    // 로그아웃
    @Override
    public void logout(HttpSession session) {
        session.invalidate();
    }
}