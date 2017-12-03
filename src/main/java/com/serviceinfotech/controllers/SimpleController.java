package com.serviceinfotech.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.CustomNumberEditor;
import org.springframework.stereotype.Controller;
import org.springframework.util.NumberUtils;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@Controller
public class SimpleController {

    private static final Logger logger = LoggerFactory.getLogger(SimpleController.class);


    @RequestMapping(value = "/simple/{index}",method = RequestMethod.POST)
    public @ResponseBody
    String setHello(@PathVariable Integer index) {
        if (index == null) {
            return "hello I am a null object";
        } else {
            return "hello" + index;

        }
    }

    @RequestMapping(value = "/simple/{index}",method = RequestMethod.GET)
    public @ResponseBody
    String getHello(@PathVariable Integer index) {
        if (index == null) {
            return "hello I am a null object";
        } else {
            return "hello" + index;

        }
    }

    @InitBinder
    public void dataBinding(WebDataBinder binder) {
        binder.registerCustomEditor(Integer.class, new CustomNumberEditor(Integer.class, true) {

            @Override
            public void setAsText(String text) throws IllegalArgumentException {
                try {
                    Integer integer = NumberUtils.parseNumber(text, Integer.class);
                    super.setValue(integer);
                } catch (NumberFormatException nfe) {
                    super.setValue(null);
                }

            }

        });
    }

    @ExceptionHandler
    public void handleException(HttpServletRequest request, Exception ex) throws Exception {
        logger.error("Requested URL=" + request.getRequestURL());
        logger.error("Exception Raised=" + ex);

    }
}
