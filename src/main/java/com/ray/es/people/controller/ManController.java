package com.ray.es.people.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ray.base.util.GridDataModel;
import com.ray.base.util.ModelAndViewUtil;
import com.ray.base.util.SessionUtil;
import com.ray.es.people.Service.ManService;
import com.ray.exam.question.controller.QuestionController;
import com.ray.exam.question.form.QuestionForm;
import com.ray.exam.question.model.QuestionDO;
import com.ray.power.login.model.UserSession;

import io.swagger.annotations.ApiOperation;

@Controller
@RequestMapping("/man")
public class ManController {

	private static Logger logger = LoggerFactory.getLogger(ManController.class);

	@Resource(name = "manService")
	private ManService manService;

	@RequestMapping("test/{id}")
	public ModelAndView test (
			HttpSession session,
			HttpServletRequest request, 
			HttpServletResponse response, Model model,
			@PathVariable("id") String id 
	){
		
		return ModelAndViewUtil.Json_ok( "man",  manService.findById(id));
	}
}