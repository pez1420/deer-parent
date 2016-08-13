package com.longlydeer.deer.portal.service.impl;

import com.longlydeer.deer.common.core.service.impl.BaseServiceImpl;
import com.longlydeer.deer.common.web.shiro.Principal;
import com.longlydeer.deer.portal.dao.MemberDao;
import com.longlydeer.deer.portal.entity.Children;
import com.longlydeer.deer.portal.entity.Member;
import com.longlydeer.deer.portal.service.ChildrenService;
import com.longlydeer.deer.portal.service.MemberService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**会员业务逻辑实现类
 *
 * @author pez1420@163.com
 * @version 1.0
 */
@Service("memberServiceImpl")
public class MemberServiceImpl extends BaseServiceImpl<Member, Long> implements MemberService {
    @Resource
    private ChildrenService childrenService;

    @Resource
    private MemberDao memberDao;

    @Resource
    public void setDao(MemberDao memberDao) {
        super.setBaseDao(memberDao);
    }

    @Transactional
    public void saveMember(Member member) {
        Assert.notNull(member);
        memberDao.saveMember(member);
    }

    @Transactional
    public void saveMember(Member member, Children children) {
        Assert.notNull(member);
        memberDao.saveMember(member);
        children.setMemberId(member.getId());
        childrenService.saveChildren(children);
    }


    @Transactional(readOnly = true)
    public Member find(Long id) {
        return memberDao.find(id);
    }

    @Transactional(readOnly = true)
    public boolean usernameExists(String username) {
        return this.memberDao.usernameExists(username) > 0;
    }

    @Transactional(readOnly = true)
    public Member findByUsername(String username) {
        return memberDao.findByUsername(username);
    }

    @Transactional(readOnly = true)
    public boolean isAuthenticated() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest httpServletRequest = ((ServletRequestAttributes)requestAttributes).getRequest();
            Principal principal = (Principal)httpServletRequest.getSession().getAttribute(Member.PRINCIPAL_ATTRIBUTE_NAME);
            if (principal != null)
                return true;
        }
        return false;
    }

    @Transactional(readOnly = true)
    public Member getCurrent() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest httpServletRequest = ((ServletRequestAttributes)requestAttributes).getRequest();
            Principal principal = (Principal)httpServletRequest.getSession().getAttribute(Member.PRINCIPAL_ATTRIBUTE_NAME);
            if (principal != null)
                return this.memberDao.find(principal.getId());
        }
        return null;
    }

    @Transactional(readOnly = true)
    public String getCurrentUsername() {
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        if (requestAttributes != null) {
            HttpServletRequest httpServletRequest = ((ServletRequestAttributes)requestAttributes).getRequest();
            Principal principal = (Principal)httpServletRequest.getSession().getAttribute(Member.PRINCIPAL_ATTRIBUTE_NAME);
            if (principal != null)
                return principal.getUsername();
        }
        return null;
    }
}
