package com.longlydeer.portal.controller.front;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/** 首页课程体系
 *
 */
@Controller("frontCoursesController")
@RequestMapping({"/courses"})
public class CoursesController extends BaseController{

    @RequestMapping(method = RequestMethod.GET)
    public String index() {
        return "/front/courses/index";
    }
}
