package com.longlydeer.deer.portal.service.impl;

import com.longlydeer.deer.common.core.service.impl.BaseServiceImpl;
import com.longlydeer.deer.portal.dao.ChildrenDao;
import com.longlydeer.deer.portal.dao.MemberDao;
import com.longlydeer.deer.portal.entity.Children;
import com.longlydeer.deer.portal.service.ChildrenService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 *
 */
@Service
public class ChildrenServiceImpl extends BaseServiceImpl<Children, Long> implements ChildrenService {

    @Resource
    private ChildrenDao childrenDao;

    @Resource
    public void setDao(ChildrenDao childrenDao) {
        super.setBaseDao(childrenDao);
    }

    @Transactional
    public void saveChildren(Children children) {
         childrenDao.saveChildren(children);
    }

    @Transactional
    public void updateByMemberId(Children children) {
        childrenDao.updateByMemberId(children);
    }

    @Transactional(readOnly = true)
    public boolean childrenExists(Long memberId) {
        return childrenDao.childrenExists(memberId) > 0L;
    }

    @Transactional
    public void deleteByMemberId(Long memberId) {
        childrenDao.deleteByMemberId(memberId);
    }
}
