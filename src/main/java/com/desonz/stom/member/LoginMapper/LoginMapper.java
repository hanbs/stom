package com.desonz.stom.member.LoginMapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import javax.servlet.http.HttpSession;
import java.util.List;

@Mapper
@Repository
public interface LoginMapper {

    // 로그인
    List loginCheck(@Param("user_id") String user_id, @Param("user_pw") String user_pw);

    // 로그아웃
    void logout(HttpSession session);
}

