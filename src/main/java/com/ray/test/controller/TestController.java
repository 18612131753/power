package com.ray.test.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ray.base.util.ModelAndViewUtil;
import com.ray.caipiao.ttffoff.model.OffoResult;
import com.ray.publicserver.service.MailService;

@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired  
    private MailService mailService;
    
    private static Logger logger = LogManager.getLogger(TestController.class);
    
	@RequestMapping("")
	public ModelAndView test (
			HttpSession session,
			HttpServletRequest request, 
			HttpServletResponse response, Model model
	){
	    mailService.sendSimpleMail("32411043@qq.com", "测试题目", "测试邮件");
		return ModelAndViewUtil.Json_ok( );
	}
}