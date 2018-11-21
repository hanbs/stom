package com.desonz.stom.member.LoginMapper;

import com.desonz.stom.member.LoginModel.LoginModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Mapper
@Repository
public interface LoginMapper {
//
    // 로그인
    LoginModel loginCheck(Map <String, String> map);

    // 로그아웃
    void logout(HttpSession session);
}

