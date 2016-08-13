package com.longlydeer.deer.portal.entity;


import com.longlydeer.deer.common.annotation.EntityInfo;
import com.longlydeer.deer.common.annotation.Meaning;
import com.longlydeer.deer.common.entity.BaseEntity;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

@EntityInfo("会员")
public class Member extends BaseEntity {

    private static final long serialVersionUID = -3533906117973307566L;

    public static final String PRINCIPAL_ATTRIBUTE_NAME = Member.class.getName() + ".Principal";

    @Meaning("手机")
    private String phone;
    @Meaning("用户名")
    private String username;
    @Meaning("密码")
    private String password;
    @Meaning("邮件")
    private String email;
    @Meaning("是否启用")
    private Boolean isEnabled;
    @Meaning("是否锁住")
    private Boolean isLocked;
    @Meaning("登录失败次数")
    private Integer loginFailureCount;
    @Meaning("锁住日期")
    private Date lockedDate;
    @Meaning("注册IP")
    private String registerIp;
    @Meaning("登录IP")
    private String loginIp;
    @Meaning("登录日期")
    private Date loginDate;
    @Meaning("推荐者手机号")
    private String recommender;

    @NotEmpty(groups={BaseEntity.Save.class})
    @Pattern(regexp="^[0-9]+$")
    @Length(max=200)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @NotEmpty(groups={BaseEntity.Save.class})
    @Pattern(regexp="^[^\\s&\"<>]+$")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @NotNull
    public Boolean getIsEnabled() {
        return isEnabled;
    }

    public void setIsEnabled(Boolean isEnabled) {
        this.isEnabled = isEnabled;
    }

    public Integer getLoginFailureCount() {
        return loginFailureCount;
    }

    public void setLoginFailureCount(Integer loginFailureCount) {
        this.loginFailureCount = loginFailureCount;
    }

    @NotNull
    public Boolean getIsLocked() {
        return isLocked;
    }

    public void setIsLocked(Boolean isLocked) {
        this.isLocked = isLocked;
    }

    public Date getLockedDate() {
        return lockedDate;
    }

    public void setLockedDate(Date lockedDate) {
        this.lockedDate = lockedDate;
    }

    public String getLoginIp() {
        return loginIp;
    }

    public void setLoginIp(String loginIp) {
        this.loginIp = loginIp;
    }

    public String getRegisterIp() {
        return registerIp;
    }

    public void setRegisterIp(String registerIp) {
        this.registerIp = registerIp;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getRecommender() {
        return recommender;
    }

    public void setRecommender(String recommender) {
        this.recommender = recommender;
    }
}
