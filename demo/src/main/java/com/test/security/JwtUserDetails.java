package com.test.security;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.Collection;

/**
 * 安全用户模型
 * @author Louis
 * @date Jun 29, 2019
 */
@Slf4j
public class JwtUserDetails extends User {

	private static final long serialVersionUID = 1L;

	public JwtUserDetails(String username, String password, Collection<? extends GrantedAuthority> authorities) {
		this(username, password, true, true, true, true, authorities);
		log.info("JwtUserDetails 的 构造 方法 JwtUserDetails 1111111 执行~~~~~~~~~~~~");
	}
	
	public JwtUserDetails(String username, String password, boolean enabled, boolean accountNonExpired,
                          boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority> authorities) {
		super(username, password, enabled, accountNonExpired, credentialsNonExpired, accountNonLocked, authorities);
		log.info("JwtUserDetails 的 构造 方法 JwtUserDetails 2222222222 执行~~~~~~~~~~~~");
	}

}