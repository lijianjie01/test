//package com.test.config;
//
//import org.apache.shiro.cache.CacheManager;
//import org.apache.shiro.cache.MemoryConstrainedCacheManager;
//import org.apache.shiro.codec.Base64;
//import org.apache.shiro.spring.LifecycleBeanPostProcessor;
//import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
//import org.apache.shiro.web.mgt.CookieRememberMeManager;
//import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
//import org.apache.shiro.web.servlet.SimpleCookie;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.apache.shiro.mgt.SecurityManager;
//
//import java.util.LinkedHashMap;
//import java.util.Map;
//
//@Configuration
//public class ShiroConfig {
//
//    @Bean
//    public MyShiroRealm myShiroRealm() {
//        return new MyShiroRealm();
//    }
//
//    @Bean
//    public CacheManager cacheManager() {
//        return new MemoryConstrainedCacheManager();
//    }
//
//    /**
//     * cookie对象;
//     * rememberMeCookie()方法是设置Cookie的生成模版，比如cookie的name，cookie的有效时间等等。
//     * @return
//     */
//    @Bean
//    public SimpleCookie rememberMeCookie(){
//        //System.out.println("ShiroConfiguration.rememberMeCookie()");
//        //这个参数是cookie的名称，对应前端的checkbox的name = rememberMe
//        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
//        //<!-- 记住我cookie生效时间30天 ,单位秒;-->
//        simpleCookie.setMaxAge(259200);
//        return simpleCookie;
//    }
//
//    /**
//     * cookie管理对象;
//     * rememberMeManager()方法是生成rememberMe管理器，而且要将这个rememberMe管理器设置到securityManager中
//     * @return
//     */
//    @Bean
//    public CookieRememberMeManager rememberMeManager(){
//        //System.out.println("ShiroConfiguration.rememberMeManager()");
//        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
//        cookieRememberMeManager.setCookie(rememberMeCookie());
//        //rememberMe cookie加密的密钥 建议每个项目都不一样 默认AES算法 密钥长度(128 256 512 位)
//        cookieRememberMeManager.setCipherKey(Base64.decode("2AvVhdsgUs0FSA3SDFAdag=="));
//        return cookieRememberMeManager;
//    }
//
//    @Bean
//    public SecurityManager securityManager() {
//        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
//        manager.setRealm(myShiroRealm());
//        manager.setCacheManager(cacheManager());
//        // 注入记住我管理器
//        manager.setRememberMeManager(rememberMeManager());
//        // 注入自定义sessionManager
////        manager.setSessionManager(sessionManager());
//        return manager;
//    }
//
//    //自定义sessionManager
////    @Bean
////    public SessionManager sessionManager() {
////        return new CustomSessionManager();
////    }
//
////    public CORSAuthenticationFilter corsAuthenticationFilter(){
////        return new CORSAuthenticationFilter();
////    }
//
//    /**
//     * 请求拦截
//     * @param securityManager
//     * @return
//     */
//    @Bean(name = "shiroFilter")
//    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
//        ShiroFilterFactoryBean shiroFilter = new ShiroFilterFactoryBean();
//        shiroFilter.setSecurityManager(securityManager); // setSecurityManager 表示指定 SecurityManager
//        shiroFilter.setLoginUrl("/loginPage"); // setLoginUrl 表示指定登录页面
//        shiroFilter.setSuccessUrl("/successUrl"); // setSuccessUrl 表示指定登录成功页面
//        shiroFilter.setUnauthorizedUrl("/unauthorizedurl");
//        //SecurityUtils.setSecurityManager(securityManager);
//        Map<String, String> filterChainDefinitionMap = new LinkedHashMap<>();
////        //配置不会被拦截的链接，顺序判断
////        filterChainDefinitionMap.put("/", "anon");
//        filterChainDefinitionMap.put("/login", "anon");
//        filterChainDefinitionMap.put("/quartz/**", "anon");
//        filterChainDefinitionMap.put("/**", "authc");
//        //authc:所有url必须通过认证才能访问，anon:所有url都可以匿名访问
////        filterChainDefinitionMap.put("/**", "corsAuthenticationFilter");
//        shiroFilter.setFilterChainDefinitionMap(filterChainDefinitionMap);
//        //自定义过滤器
////        Map<String, Filter> filterMap = new LinkedHashMap<>();
////        filterMap.put("corsAuthenticationFilter", corsAuthenticationFilter());
////        shiroFilter.setFilters(filterMap);
//
//        return shiroFilter;
//    }
//
//    /**
//     * Shiro生命周期处理器 * @return
//     */
//    @Bean
//    public LifecycleBeanPostProcessor lifecycleBeanPostProcessor() {
//        return new LifecycleBeanPostProcessor();
//    }
//
//    /**
//     * 开启Shiro的注解(如@RequiresRoles,@RequiresPermissions),需借助SpringAOP扫描使用Shiro注解的类,并在必要时进行安全逻辑验证 * 配置以下两个bean(DefaultAdvisorAutoProxyCreator(可选)和AuthorizationAttributeSourceAdvisor)即可实现此功能 * @return
//     */
////    @Bean
////    @DependsOn({"lifecycleBeanPostProcessor"})
////    public DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator() {
////        DefaultAdvisorAutoProxyCreator advisorAutoProxyCreator = new DefaultAdvisorAutoProxyCreator();
////        advisorAutoProxyCreator.setProxyTargetClass(true);
////        return advisorAutoProxyCreator;
////    }
////
////    @Bean
////    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
////        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
////        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
////        return authorizationAttributeSourceAdvisor;
////    }
//}