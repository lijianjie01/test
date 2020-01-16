package com.test.service;

import com.test.dto.SysUserDto;
import com.test.entity.SysUser;

import com.test.utils.TableResultResponse;

import java.util.Set;


public interface SysUserService {

    SysUser signUser(SysUser user);

    /**
     * null == list || list.size() ==0
     * list!=null && !list.isEmpty()
     * @param id
     * @return
     */
    SysUser selectUserById(Integer id);

    SysUser updUser(SysUser user);

    void deleteById(Integer id);

    /**
     * 分页要设置在查询语句之上
     * @param userDto
     * @return
     */
    TableResultResponse getList(SysUserDto userDto);

    SysUser selectByUserName(String username);

    /**
     * 查找用户的菜单权限标识集合
     * @param username
     * @return
     */
    Set<String> findPermissions(String username);
}
