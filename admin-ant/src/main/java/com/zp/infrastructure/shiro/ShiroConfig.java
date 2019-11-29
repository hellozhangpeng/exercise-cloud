package com.zp.infrastructure.shiro;

import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.mgt.WebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @Auther: ZhangPeng
 * @Date: 2019/11/29 14:08
 * @Description:
 */
@Configuration
public class ShiroConfig {
    @Bean
    public CredentialsMatcher credentialsMatcher() {
        ShiroCredentialsMatcher credentialsMatcher = new ShiroCredentialsMatcher();
        credentialsMatcher.setHashAlgorithmName(Sha256Hash.ALGORITHM_NAME);
        return credentialsMatcher;
    }

    @Bean
    public AuthorizingRealm authorizingRealm(CredentialsMatcher credentialsMatcher) {
        AuthorizingRealm realm = new ShiroRealm();
        realm.setCredentialsMatcher(credentialsMatcher);
        return realm;
    }

    @Bean
    public WebSecurityManager securityManager(AuthorizingRealm authorizingRealm) {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(authorizingRealm);
        return securityManager;
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(WebSecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, Filter> filtersMap = shiroFilterFactoryBean.getFilters();
        filtersMap.put("ShiroJwtFilter", new ShiroJwtFilter());// 自定义拦截器
        shiroFilterFactoryBean.setFilters(filtersMap);

        Map<String, String> filterChainDefinitionMap = new LinkedHashMap();
        shiroFilterFactoryBean.setLoginUrl("/User/logon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }
}
