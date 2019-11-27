package com.test.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.test.dto.SysUserDto;
import com.test.entity.SysUser;
import com.test.mapper.SysUserMapper;
import com.test.utils.ResultResponse;
import com.test.utils.TableResultResponse;
import com.test.utils.pager.Pager;
import com.test.utils.pager.PagerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
@Transactional(rollbackFor = Exception.class)
public class SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;

    public SysUser addUser(SysUser user) {
        user.setIsDelete(0);
        user.setRegistTime(new Date());
        sysUserMapper.insertSelective(user);
        return user;
    }

    /**
     * null == list || list.size() ==0
     * list!=null && !list.isEmpty()
     * @param id
     * @return
     */
    public SysUser selectUserById(Integer id) {
        SysUser user = new SysUser();
        user.setId(id);
        List<SysUser> userList = sysUserMapper.select(user);
        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }

    public SysUser updUser(SysUser user) {
        sysUserMapper.updateByPrimaryKeySelective(user);
        return user;
    }

    public void deleteById(Integer id) {
        sysUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * 分页要设置在查询语句之上
     * @param userDto
     * @return
     */
    public TableResultResponse getList(SysUserDto userDto) {
        // 分页要设置在查询语句之上
        PageHelper.startPage(userDto.getPageNum(), userDto.getPageSize());
        List<SysUser> userList = sysUserMapper.getAllList();
        PageInfo<SysUser> pageInfo = new PageInfo<>(userList);
        return new TableResultResponse(pageInfo.getTotal(), pageInfo.getList());
    }
}
