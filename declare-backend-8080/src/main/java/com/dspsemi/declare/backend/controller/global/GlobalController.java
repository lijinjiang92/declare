package com.dspsemi.declare.backend.controller.global;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dspsemi.common.web.BaseController;

/**
 * @author XiaoJin Wang
 *
 */
@Controller
public class GlobalController extends BaseController {
	
	/**
	 * index
	 */
	@RequestMapping("/index")
	public String index() throws Exception {
		return "main";
	}
	
	/**
	 * index
	 */
	@RequestMapping("/index1")
	public String index1() throws Exception {
		System.out.println("12312312");
		return "main";
	}
	
	@RequestMapping("/unauthorized")
	public String unauthorized() throws Exception {
		return "unauthorized";
	}
	
}
