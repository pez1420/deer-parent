package com.longlydeer.portal.controller.front.member;

import com.longlydeer.deer.common.entity.BaseEntity;
import com.longlydeer.deer.common.web.utils.Message;
import com.longlydeer.deer.portal.entity.Children;
import com.longlydeer.deer.portal.service.ChildrenService;
import com.longlydeer.portal.controller.front.BaseController;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 */
@Controller("frontChildrenController")
@RequestMapping({"/front/children"})
public class ChildrenController extends BaseController{
    private static final Logger logger = Logger.getLogger(ChildrenController.class);

    @Resource
    private ChildrenService childrenService;

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    @ResponseBody
    public Message update(Children children) {
        if (!validate(children, new Class[]{BaseEntity.Update.class})) {
            return ERROR;
        }

        if (!childrenService.childrenExists(children.getMemberId())) {
            childrenService.updateByMemberId(children);
        } else {
            childrenService.save(children);
        }

        return SUCCESS;
    }

}
