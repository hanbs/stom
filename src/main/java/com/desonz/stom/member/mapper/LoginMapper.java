package com.desonz.stom.member.mapper;

import com.desonz.stom.member.model.LoginModel;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface LoginMapper {

    // 로그인
    LoginModel loginCheck(Map <String, String> map);

}

