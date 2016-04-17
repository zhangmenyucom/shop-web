package com.taylor.web.shop.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.taylor.api.shop.service.TestService;

/**
 * @ClassName: TestServiceAction
 * @Function:测试控制器类
 * @date: 2016年4月16日 下午10:16:37
 * @author Taylor
 */
@Controller
@RequestMapping("/test/*")
public class TestServiceAction {
    private static final Logger LOGGER = Logger.getLogger(TestServiceAction.class);

    @Autowired
    private TestService testService;

    /**
     * @desc test(测试方法)
     * @param map
     * @param request
     * @param response
     * @author taylor
     * @date 2016年4月16日 下午10:19:26
     */
    @RequestMapping("test")
    public String test(ModelMap map, HttpServletRequest request, HttpServletResponse response) {
        try {
            testService.test();
            map.put("welcome", "hello world!");
        } catch (Exception e) {
            LOGGER.error("调用TestServiceAction.test方法时出错", e);
        }
        return "/test/index";

    }

}
