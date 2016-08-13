package com.longlydeer.deer.portal.service;

import com.longlydeer.deer.common.core.service.BaseService;
import com.longlydeer.deer.portal.entity.Children;
import com.longlydeer.deer.portal.entity.Member;


public interface MemberService extends BaseService<Member, Long>{


    /** 保存用户
     *
     * @param member
     * @return
     */
    public void saveMember(Member member);


    /** 保存用户和孩子
     *
     * @param member
     * @param children
     */
    public void saveMember(Member member, Children children);


    /**验证用户名是否重复
     *
     * @param username
     * @return
     */
    public boolean usernameExists(String username);

    /**
     *
     * @param username
     * @return
     */
    public  Member findByUsername(String username);

    /**
     * 是否已经成功登陆
     *
     * @return
     */
    public  boolean isAuthenticated();

    /**
     * 返回当前用户
     *
     * @return
     */
    public  Member getCurrent();


    /**
     * 返回当前用户的名称
     * @return
     */
    public  String getCurrentUsername();



}
