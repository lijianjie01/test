package com.test.mapper;

import com.test.dto.SysUserDto;
import com.test.entity.SysUser;
import com.test.utils.mapper.MyMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface SysUserMapper extends MyMapper<SysUser> {

    List<SysUser> getAllList();

}