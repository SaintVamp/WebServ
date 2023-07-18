package com.svt.statistics;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Saint on 2017/2/9.
 */
@Controller
@RequestMapping("/")
public class Statistics {

	@ResponseBody
	@RequestMapping(value = "/Health", method = RequestMethod.GET)
	public String Health ( ) {
		return "OK";
	}




}
