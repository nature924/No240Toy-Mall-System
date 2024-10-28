package com.wsy.config.exception;

import com.alibaba.fastjson.JSON;
import com.wsy.config.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @author Wsy
 */
@ControllerAdvice
@Slf4j
public class AdminExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(Exception e, HttpServletRequest request, HttpServletResponse response) throws Exception {
         ModelAndView mav = new ModelAndView();
         Result result = null;
        if (e instanceof NeedLoginException) {
            result =  Result.error("需要登录");
            result.setCode(10001);
        }else {
            e.printStackTrace();
            result = Result.error(e.getMessage());
            result.setData("");
        }
        mav.addObject("err_msg",result.getMsg());
        if(isAjax(request)){
            MappingJackson2JsonView view = new MappingJackson2JsonView();
            view.setAttributesMap(JSON.parseObject(JSON.toJSONString(result),Map.class));
            mav.setView(view);
        }else{
            if(request.getRequestURI().endsWith("do")){
                response.sendRedirect("/mobileCustomer/login.html");
            }else{
                response.sendRedirect("/login.html");
            }
        }
        return mav;
    }

    /**
     * 判断是不是ajax请求
     * @param request
     * @return
     */
    public boolean isAjax(HttpServletRequest request){
        String requestType = request.getHeader("X-Requested-With");
        if("XMLHttpRequest".equals(requestType)){
            return true;
        }else{
            return false;
        }
    }
}
