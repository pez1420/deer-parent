package com.longlydeer.deer.controller.front.member;

import com.longlydeer.deer.common.utils.JsonUtil;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;


@Controller("frontMemberController")
@RequestMapping({"/front/member"})
public class MemberController {
    private static final Logger logger = Logger.getLogger(MemberController.class);

    @RequestMapping(value = { "/list" }, method = { RequestMethod.GET })
    @ResponseBody
    public String list() {
        logger.debug("#" + MemberController.class.getSimpleName() + " start!");
        HashMap<String, Object> res = new HashMap<String,Object>();
        res.put("name", "hello world2!");
        return JsonUtil.toJson(res);
    }

}
