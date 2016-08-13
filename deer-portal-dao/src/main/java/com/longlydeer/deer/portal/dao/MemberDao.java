package com.longlydeer.deer.portal.dao;

import com.longlydeer.deer.common.core.dao.BaseDao;
import com.longlydeer.deer.portal.entity.Member;

/**
 * 会员管理DAO接口
 * @author pez1420@163.com
 * @version 1.0
 */
public interface MemberDao extends BaseDao<Member, Long> {

    /** 保存用户
     *
     * @param member
     * @return
     */
    public void saveMember(Member member);

    /**
     *检查 用户名是否存在
     *
     * @param username
     * @return
     */
    public  long usernameExists(String username);

    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public  Member findByUsername(String username);

}
