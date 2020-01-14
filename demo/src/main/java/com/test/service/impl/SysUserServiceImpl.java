package com.test.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.dto.SysUserDto;
import com.test.entity.SysUser;
import com.test.mapper.SysUserMapper;
import com.test.service.SysUserService;
import com.test.utils.EncoderUtils;
import com.test.utils.TableResultResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    @Override
    public SysUser signUser(SysUser user) {
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        user.setPassword(EncoderUtils.bCryptPasswordEncoder().encode(user.getPassword()));
        sysUserMapper.insertSelective(user);
        return user;
    }

    /**
     * null == list || list.size() ==0
     * list!=null && !list.isEmpty()
     * @param id
     * @return
     */
    @Override
    public SysUser selectUserById(Integer id) {
        SysUser user = new SysUser();
        user.setId(id);
        List<SysUser> userList = sysUserMapper.select(user);
        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }

    @Override
    public SysUser updUser(SysUser user) {
        sysUserMapper.updateByPrimaryKeySelective(user);
        return user;
    }

    @Override
    public void deleteById(Integer id) {
        sysUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * 分页要设置在查询语句之上
     * @param userDto
     * @return
     */
    @Override
    public TableResultResponse getList(SysUserDto userDto) {
        // 分页要设置在查询语句之上
        PageHelper.startPage(userDto.getPageNum(), userDto.getPageSize());
        List<SysUser> userList = sysUserMapper.getAllList();
        PageInfo<SysUser> pageInfo = new PageInfo<>(userList);
        return new TableResultResponse(pageInfo.getTotal(), pageInfo.getList());
    }

    @Override
    public SysUser selectByUserName(String username) {
        SysUser user = new SysUser();
        user.setUsername(username);
        List<SysUser> userList = sysUserMapper.select(user);
        if (userList != null && userList.size() > 0) {
            return userList.get(0);
        }
        return null;
    }
}
