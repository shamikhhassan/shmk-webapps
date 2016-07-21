package com.shmk.practice;

import java.awt.Dialog.ModalExclusionType;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import javax.annotation.Generated;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		return "home";
	}

	@RequestMapping(value = "/abc.htm", method = RequestMethod.GET)
	public ModelAndView abc(HttpServletRequest request,HttpServletResponse response) {
		ModelAndView mav =new ModelAndView();
		mav.setViewName("success");
		mav.addObject("msg","Welcome to Success Page");
		return mav;

	}
	
	@RequestMapping(value = "/orders/{orderId}", method = RequestMethod.GET)
	public ModelAndView pathdemo(@PathVariable String orderId ) {
		ModelAndView mav =new ModelAndView();
		mav.setViewName("success");
		mav.addObject("msg","Welcome to Fetch Order Page . Order Id is :"+orderId);
		return mav;

	}
	
	@RequestMapping(value = "/example",method=RequestMethod.GET)
    public String  getHello(Model model,
    @RequestHeader (value="User-Agent") String userAgent,
    @RequestHeader ("Accept") String acceptType,
    @RequestHeader ("Accept-Language") String acceptLang)
    {
		StringBuffer sb=new StringBuffer();
		sb.append(userAgent);
		sb.append("</br>");
		sb.append(acceptType);
		sb.append("</br>");
		sb.append(acceptLang);
		sb.append("</br>");
    	model.addAttribute("msg",sb);
        return "success";
    }
	
	@RequestMapping(value="/something",method=RequestMethod.GET)
	@ResponseBody
	public String helloWorld() {
	    return "success";
	}
	
	
}
