package com.ray.caipiao.ttffoff.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ray.base.util.GridDataModel;
import com.ray.base.util.ModelAndViewUtil;
import com.ray.caipiao.ttffoff.form.TtffoffForm;
import com.ray.caipiao.ttffoff.model.TtffCount;
import com.ray.caipiao.ttffoff.model.TtffData;
import com.ray.caipiao.ttffoff.service.TtffoffService;

import io.swagger.annotations.ApiOperation;
/**
 * 腾讯分分彩
 * http://www.off0.com/fenfencai.php
 * */
@Controller
@RequestMapping("/ttffoff")
public class TtffoffController {

	private final String tabCode = "ttffoff";// 表名标示
	private final String jspPath = "ttffoff";// JSP 包名称

	private static Logger logger = LoggerFactory.getLogger(TtffoffController.class);

    @Resource(name = "ttffoffService")
    private TtffoffService ttffoffService;

	@RequestMapping("index")
	public ModelAndView index(
		HttpServletRequest request, 
		HttpServletResponse response, 
		HttpSession session,
		Model model
	) {
		model.addAttribute("tabCode", tabCode);
		return ModelAndViewUtil.Jsp(jspPath + "/index");
	}
	
	@ApiOperation(value = "数据查询分页", httpMethod = "POST", response = String.class, notes = "")
	@RequestMapping(value="queryforlist", method = RequestMethod.POST)
	public ModelAndView queryforlist(
		HttpServletRequest request, 
		HttpServletResponse response, 
		HttpSession session,
		TtffoffForm form
	) {
		GridDataModel<TtffData> gdm = ttffoffService.query(form);
		return ModelAndViewUtil.Json_ok(gdm,"ttffoffForm");
	}

	@RequestMapping("indexcount")
    public ModelAndView indexcount(
        HttpServletRequest request, 
        HttpServletResponse response, 
        HttpSession session,
        Model model
    ) {
        model.addAttribute("tabCode", "ttffoffcount");
        return ModelAndViewUtil.Jsp(jspPath + "/indexcount");
    }
	
	@ApiOperation(value = "数据查询分页", httpMethod = "POST", response = String.class, notes = "")
    @RequestMapping(value="queryforlistcount", method = RequestMethod.POST)
    public ModelAndView queryforlistcount(
        HttpServletRequest request, 
        HttpServletResponse response, 
        HttpSession session,
        TtffoffForm form
    ) {
        GridDataModel<TtffCount> gdm = ttffoffService.querycount(form);
        return ModelAndViewUtil.Json_ok(gdm,"ttffoffForm");
    }
}