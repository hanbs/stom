package com.desonz.stom.member.LoginService;

import com.desonz.stom.member.LoginMapper.LoginMapper;
import com.desonz.stom.member.LoginModel.LoginModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@Service
@Slf4j
public class LoginServiceImpl implements LoginService {
//
    @Autowired
    LoginMapper loginMapper;

    // 로그인
    public LoginModel loginCheck(String user_id, String user_pw) {

        Map<String, String> map = new HashMap <>();
        map.put("user_id", user_id);
        map.put("user_pw", user_pw);

        return loginMapper.loginCheck(map);
    }

    // 로그아웃
    @Override
    public void logout(HttpSession session) {
        session.invalidate();
    }
}