package com.longlydeer.portal.controller.front;

import com.longlydeer.deer.common.web.utils.DateEditor;
import com.longlydeer.deer.common.web.utils.Message;
import com.longlydeer.deer.common.web.utils.XssFilterEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.annotation.Resource;
import javax.validation.Validator;
import java.beans.PropertyEditorSupport;
import java.util.Date;
import java.util.Set;


public class BaseController {

    protected static final Message ERROR = Message.error("front.message.error", new Object[0]);
    protected static final Message SUCCESS = Message.success("front.message.success", new Object[0]);

    @Resource(name="validator")
    private Validator validator; //表单验证功能


    /**Springmvc {@link PropertyEditorSupport}实现绑定时的类型转换
     *
     * @param dataBinder
     */
    @InitBinder
    protected void dataBinder(WebDataBinder dataBinder) {
        dataBinder.registerCustomEditor(XssFilterEditor.class, new XssFilterEditor(true, true));
        dataBinder.registerCustomEditor(Date.class, new DateEditor(true));
    }


    /**使用validate(){@link Validator}方法对一个给定的<b>实体对象</b>中定义的所有约束条件进行校验
     *
     * Validator 方法使用与解释:
     *  <a href="http://docs.jboss.org/hibernate/validator/4.2/reference/zh-CN/html/validator-usingvalidator.html"></a>
     *  <a href="http://yingzhuo.iteye.com/blog/1455438"></a>
     * @param object
     * @param groups
     * @return
     */
    protected boolean validate(Object object, Class<?>[] groups) {
        Set set = this.validator.validate(object, groups);
        if (set.isEmpty())
            return true;
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        requestAttributes.setAttribute("constraintViolations", set, 0);
        return false;
    }

    /**通过validateValue(){@link Validator}方法,
     * 你能够校验如果把一个特定的值赋给一个类的某一个属性的话,
     * 是否会违反此类中定义的约束条件
     *
     * @param beanType
     * @param propertyName
     * @param value
     * @param groups
     * @return
     */
    protected boolean validateValue(Class<?> beanType, String propertyName, Object value, Class<?>[] groups) {
        Set set = this.validator.validateValue(beanType, propertyName, value, groups);
        if (set.isEmpty())
            return true;
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        requestAttributes.setAttribute("constraintViolations", set, 0);
        return false;
    }

    /** 通过validateProperty() {@link Validator}可以对一个给定实体对象的单个属性进行校验.
     *  其中属性名称需要符合JavaBean规范中定义的属性名称
     *
     *  参考地址:<a href="http://docs.jboss.org/hibernate/validator/4.2/reference/zh-CN/html/validator-usingvalidator.html"></a>
     *
     * @param object
     * @param propertyName
     * @param groups
     * @return
     */
    protected boolean validateProperty(Object object, String propertyName, Class<?>[] groups) {
        Set set = this.validator.validateProperty(object, propertyName, groups);
        if (set.isEmpty())
            return true;

        return false;
    }
}
