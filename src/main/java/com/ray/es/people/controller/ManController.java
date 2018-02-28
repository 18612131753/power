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
import org.springframework.web.servlet.ModelAndView;

import com.ray.base.util.ModelAndViewUtil;
import com.ray.es.people.Service.ManService;

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