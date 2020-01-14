//package com.test.config;
//
//import com.test.entity.SysUser;
//import com.test.service.SysUserService;
//import lombok.extern.slf4j.Slf4j;
//import org.apache.shiro.authc.*;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.springframework.beans.factory.annotation.Autowired;
//
///**
// * shiro权限
// */
//@Slf4j
//public class MyShiroRealm extends AuthorizingRealm {
//
//    @Autowired
//    private SysUserService sysUserService;
//
//    @Override
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        String username = (String) principals.getPrimaryPrincipal();
//
//        log.info("权限认证---------------------开始");
//        return null;
//    }
//
//    @Override
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//        log.info("用户认证开始-------------------------------");
//        String username = (String)token.getPrincipal(); // return getUsername(); 用户名
//        SysUser user = sysUserService.selectByUserName(username);
//        if (user == null) {
//            throw new UnknownAccountException("账户不存在!");
//        }
//        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(username, user.getPassword(), getName());
//        return authenticationInfo;
//    }
//}
