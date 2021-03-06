package com.inspur.cmis.service;

import com.inspur.cmis.entity.User;

import java.util.List;

/**
 * Created by LiuLiHao on 2018/8/16 21:59.
 * 描述：
 * 作者： LiuLiHao
 */
public interface UserService extends BaseService<User> {
    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     */
    public User login(String loginName, String password);

    List<User> findAll();

    void deleteAll(String ids);

    /**
     * 禁用用户
     * @param deletes
     */
    void disableAll(String deletes);

    /**
     * 启用用户
     * @param deletes
     */
    void enableAll(String deletes);

}
