package com.xuan.erp.security;

import com.xuan.erp.jwt.JwtAuthenticationEntryPoint;
import com.xuan.erp.jwt.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true) //开启security注解
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	/**
	 * 解决提示AuthenticationManager没有注入
	 */
    @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
    
    /**
     * 注入BCrypt密码编码器
     */
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    /**
     * 注入用户信息服务
     */    
	@Autowired
	private UserDetailsService userDetailsService;

    /**
     * 注入Jwt认证异常
     */    	
    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;
    
    /**
     * 安全设置
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //web.ignoring().antMatchers("/api-docs", "/swagger-resources/**", "/swagger-ui.html**", "/webjars/**");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
    }
    
    /**
     * HTTP访问URL安全设置
     */
    protected void configure(HttpSecurity http) throws Exception { 
        http     
        	// 登录异常处理
        	.exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
        	
			//http.authorizeRequests()方法有多个子节点，每个macher按照他们的声明顺序执行  
			.authorizeRequests()
				//指定任何用户都可以访问多个URL的模式。
				//任何用户都可以访问以"/resources/","/signup", 或者 "/about"开头的URL
	            .antMatchers("/resources/**", "/login", "/auth/**", "/hello/**").permitAll()
	            
	            //以 "/admin/" 开头的URL只能让拥有 "ROLE_ADMIN"角色的用户访问
	            //注意使用 hasRole 方法，没有使用 "ROLE_" 前缀
	            //.antMatchers("/admin/**").hasRole("ADMIN")  
	                        
	            //尚未匹配的任何URL都要求用户进行身份验证
	            .anyRequest().authenticated()
	            .and()
	            
	         //指定自定义登录页的路径
	        .formLogin()
	        	 //允许所有用户访问登录URL
	            .loginPage("/login").permitAll()
	             //指定登录成功后跳转到/index页面
	            .defaultSuccessUrl("/index")
	             //指定登录失败后跳转到/login?error页面
	            .failureUrl("/login?error")
	            .and()
	            
	         //开启cookie储存用户信息，并设置有效期为14天，指定cookie中的密钥
	        .rememberMe().tokenValiditySeconds(1209600).key("mykey")
	        	.and()
	        
	        //指定登出的url
	        .logout()
	        	//允许所有用户访问登出URL
	        	.logoutUrl("/api/user/logout").permitAll()
	        	//指定登场成功之后跳转的url
	        	.logoutSuccessUrl("/index");
        
        //关闭csrf防止循环定向
        http.csrf().disable();        
        
        // 设置JWT认证过滤器
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);     
        
    }

    /**
     * 1. 注入UserDetailsService接口获取用户相关数据
     * 2. 注入密码加密器，加密和验证用户密码
     *
     * @param auth
     * @throws Exception
     */
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService)
            .passwordEncoder(bCryptPasswordEncoder());
    }
    
    /**
     * 注入Jwt认证过滤器
     * @return
     */
    @Bean
    public JwtAuthenticationTokenFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationTokenFilter();
    }    
}