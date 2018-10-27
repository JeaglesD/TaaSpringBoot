package taa.springboot.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	DataSource dataSource;
	
	private static final String[] AUTH_WHITELIST = {
            // -- swagger ui
//			"/**",
            "/v2/api-docs",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
	};
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth)throws Exception {
		auth.inMemoryAuthentication()
			.withUser("admin")
			.password("{noop}@dm1n")
			.roles("ADMIN");
	   auth.jdbcAuthentication().dataSource(dataSource)
		   .usersByUsernameQuery(
		    "select pseudo,password, enabled from users where pseudo=?")
		   .authoritiesByUsernameQuery(
		    "select pseudo, role from user_roles where pseudo=?");
		
	}
	
	@Override
	protected void configure(HttpSecurity http)throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers(AUTH_WHITELIST).permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
}