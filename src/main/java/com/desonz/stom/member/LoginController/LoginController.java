package com.desonz.stom.member.LoginController;

import com.desonz.stom.member.LoginMapper.LoginMapper;
import com.desonz.stom.member.LoginModel.LoginModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.List;

@Slf4j
@Controller
public class LoginController {

    @Autowired
    private LoginMapper mapper;

    @GetMapping(value = {"/", "/main"})
    public String index() {
        return "client/main";
    }

    // 로그인
    @GetMapping(value = "login")
    public String login_g() {
        return "client/login";
    }

    // 로그인 확인
    @PostMapping(value = "login_check")
    public ModelAndView login_s(@ModelAttribute @Valid LoginModel vo, BindingResult bindingResult, HttpSession session, ModelAndView mv, HttpServletRequest req, String user_id, String user_pw) {

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

        List <LoginModel> result = mapper.loginCheck(user_id, user_pw);
        user_id = vo.getUser_id();
        user_pw = vo.getUser_pw();


        String userid = req.getParameter("user_id");
        String userpw = req.getParameter("user_pw");

        log.info("(get vo)user_id >> " + user_id + ", (get vo)user_pw >> " + user_pw);
        log.info("(get parameter)userid >> " + userid + ", (get parameter)userpw >> " + userpw);
        log.info("(return service)result 값 >> " + result);

        if (user_id == userid && user_pw == userpw) {

            session.setAttribute("user_id", userid); // 세션에 저장 해 둬야되나???
            session.setAttribute("user_pw", userpw);
            mv.setViewName("client/main");
        } else {
            mv.setViewName("client/login");
        }
        return mv;
    }

    // 로그아웃
    @GetMapping(value = "logout")
    public ModelAndView login(ModelAndView mv, HttpSession session) {
        mapper.logout(session);
        mv.setViewName("client/main");
        return mv;
    }

    // 회원가입
    @GetMapping(value = "join_g")
    public ModelAndView join(ModelAndView mv) {
        mv.setViewName("client/join");
        return mv;
    }
}