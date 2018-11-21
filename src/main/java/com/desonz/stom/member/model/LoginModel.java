package com.desonz.stom.member.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginModel {

    @NotEmpty(message = "아이디를 입력해 주세요")
    @Size(min = 3, max = 25)
    @Length(min = 3, max = 25)
    private String user_id;

    @NotEmpty(message = "비밀번호를 입력해 주세요")
    @Size(min = 4, max = 20)
    @Length(min = 4, max = 20)
    private String user_pw;

    @NotEmpty(message = "이름을 입력해 주세요")
    @Size(min = 2, max = 20)
    @Length(min = 2, max = 20)
    private String user_name;

    // 회원 이메일
    @Email
    @NotEmpty(message = "이메일을 입력해 주세요")
    @Size(min = 9, max = 50)
    @Length(min = 9, max = 50)
    private String user_email;

    // 아래는 정상적으로 기능 구현이 되면, 추가 할 것

    // 회원 나이
    // private int user_age;

    // 회원 번호
    // private int user_phone;

    // 회원 주소
    // private String user_addr;
}
