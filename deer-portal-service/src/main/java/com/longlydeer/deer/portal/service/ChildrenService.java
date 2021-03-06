package com.longlydeer.deer.portal.service;

import com.longlydeer.deer.common.core.service.BaseService;
import com.longlydeer.deer.portal.entity.Children;
import com.longlydeer.deer.portal.entity.Member;


public interface ChildrenService extends BaseService<Children, Long> {

    /** 保存孩子
     *
     * @param children
     * @return
     */
    public void saveChildren(Children children);


    /** 更新孩子根据用户ID
     *
     * @param children 孩子实体,必须包含memberId
     *
     */
    public void updateByMemberId(Children children);


    /** 孩子是否已经存在
     *
     * @param memberId
     * @return
     */
    public boolean childrenExists(Long memberId);


    /** 根据用户ID删除孩子
     *
     * @param memberId
     */
    public void deleteByMemberId(Long memberId);
}
