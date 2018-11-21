package com.desonz.stom.member.LoginMapper;

import com.desonz.stom.member.LoginModel.LoginModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Mapper
@Repository
public interface LoginMapper {

    // 로그인
    List <LoginModel> loginCheck(@Param("user_id") String user_id, @Param("user_pw") String user_pw);

    // 로그아웃
    void logout(HttpSession session);
}

class LogCheck {

    Logger log = LoggerFactory.getLogger(LoginMapper.class);

    @Autowired
    LoginMapper mapper;

    void LogCheck(@Param("user_id") String user_id, @Param("user_pw") String user_pw) {
        log.info(String.valueOf("mapper >>" + mapper.loginCheck(user_id, user_pw)));
    }
}