package com.desonz.stom.member.controller;

import com.desonz.stom.member.model.LoginModel;
import com.desonz.stom.member.service.LoginService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(value = {"/", "/main"})
    public String index() {
        return "client/main";
    }

    // 로그인
    @GetMapping(value = "/login")
    public String login() {
        return "client/login";
    }

    // 로그인 확인
    @PostMapping(value = "/login_check")
    public ModelAndView loginCheck(@ModelAttribute @Valid LoginModel vo, BindingResult bindingResult, HttpSession session, ModelAndView mv, String user_id, String user_pw) {

        // 유효성 검사 sample
        // if (bindingResult.hasErrors()) {
        // List <ObjectError> list = bindingResult.getAllErrors();
        // for (ObjectError e : list) {
        // log.error("ObjectError : " + e);
        // }
        // mv.setViewName("")
        // mv.addObject("",);
        // return mv;
        // }
        // log.debug("### vo : ",vo );
        // mv.setViewName("");
        // mv.addObject("",);

        LoginModel result =  loginService.loginCheck(user_id, user_pw);

        String userid = vo.getUser_id();
        String userpw = vo.getUser_pw();

        log.info("(get vo)user_id >> " + user_id + ", (get vo)user_pw >> " + user_pw);
        log.info("(return service)result 값 >> " + result);

        if (result != null) { // vo의 값이 null이 아니면,
            // 성공
            session.setAttribute("user_id", userid);
            session.setAttribute("user_pw", userpw);
            mv.setViewName("client/main");
        } else {
            // 실패
            mv.setViewName("client/login");
        }
        return mv;
    }

    // 로그아웃
    @GetMapping(value = "/logout")
    public String login(HttpSession session) {
        session.setAttribute("user_id", null);
        return "redirect:/main";
    }

    // 회원가입
    @GetMapping(value = "/join")
    public String join() {
        return "client/join";
    }

    // 회원가입 확인
    @PostMapping(value = "/join_check")
    public ModelAndView joinCheck(ModelAndView mv) {

        mv.setViewName("client/login");
        return mv;
    }

    // 아이디 찾기
    @GetMapping(value = "/find_id")
    public String findId() {
        return "client/find_id";
    }

    // 아이디 확인
    @PostMapping(value = "/find_id_check")
    public ModelAndView findIdCheck(ModelAndView mv) {
        mv.setViewName("client/login");
        return mv;
    }

    // 비밀번호 찾기
    @GetMapping(value = "/find_pw")
    public String findPw() {
        return "client/find_pw";
    }

    // 비밀번호 확인
    @PostMapping(value = "/find_pw_check")
    public ModelAndView findPwCheck(ModelAndView mv) {
        mv.setViewName("client/login");
        return mv;
    }
}