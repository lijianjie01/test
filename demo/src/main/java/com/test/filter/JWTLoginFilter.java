package com.test.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.entity.SysUser;
import com.test.security.JwtAuthenticatioToken;
import com.test.utils.HttpUtils;
import com.test.utils.JwtTokenUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.event.InteractiveAuthenticationSuccessEvent;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.AuthenticationFilter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

/**
 * 验证用户名密码正确后，生成一个token，并将token返回给客户端
 * 该类继承自UsernamePasswordAuthenticationFilter，重写了其中的2个方法
 * attemptAuthentication ：接收并解析用户凭证。
 * successfulAuthentication ：用户成功登录后，这个方法会被调用，我们在这个方法里生成token。
 */

/**
 * 登录认证触发过滤器
 */
@Slf4j
public class JWTLoginFilter extends UsernamePasswordAuthenticationFilter {

    private AuthenticationManager authenticationManager;

    public JWTLoginFilter(AuthenticationManager authenticationManager) {
        this.authenticationManager = authenticationManager;
    }

    // 接收并解析用户凭证
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        log.info("JWTLoginFilter的attemptAuthentication方法执行~~~~~~~~");
        try {
            SysUser user = new ObjectMapper()
                    .readValue(request.getInputStream(), SysUser.class);
            UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
                    user.getUsername(),
                    user.getPassword(),
                    new ArrayList<>());
            // Allow subclasses to set the "details" property
            setDetails(request, usernamePasswordAuthenticationToken);
            return getAuthenticationManager().authenticate(
                    usernamePasswordAuthenticationToken
            );
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }

    // 用户成功登录后，这个方法会被调用，我们在这个方法里生成token
    @Override
    protected void successfulAuthentication(HttpServletRequest req,
                                            HttpServletResponse res,
                                            FilterChain chain,
                                            Authentication auth) throws IOException, ServletException {
        log.info("JWTLoginFilter的successfulAuthentication方法执行~~~~~~~~");

        // 存储登录认证信息到上下文
        SecurityContextHolder.getContext().setAuthentication(auth);
        // 记住我服务
        getRememberMeServices().loginSuccess(req, res, auth);
        // 触发事件监听器
        if (this.eventPublisher != null) {
            eventPublisher.publishEvent(new InteractiveAuthenticationSuccessEvent(auth, this.getClass()));
        }
        // 生成并返回token给客户端，后续访问携带此token
        JwtAuthenticatioToken token = new JwtAuthenticatioToken(null, null, JwtTokenUtils.generateToken(auth));
        HttpUtils.write(res, token);

//        String token = Jwts.builder()
//                .setSubject(((org.springframework.security.core.userdetails.User) auth.getPrincipal()).getUsername())
//                .setExpiration(new Date(System.currentTimeMillis() + 60 * 60 * 24 * 1000))
//                .signWith(SignatureAlgorithm.HS512, "MyJwtSecret")
//                .compact();
//        res.addHeader("Authorization", "Bearer " + token);
    }

}
