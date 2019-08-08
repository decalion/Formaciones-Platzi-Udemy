package com.bolsadeideas.springboot.app;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import com.bolsadeideas.springboot.app.auth.filter.JWTAuthenticationFilter;
import com.bolsadeideas.springboot.app.auth.filter.JWTAuthorizationFilter;
import com.bolsadeideas.springboot.app.auth.handle.LoginSuccesHandler;
import com.bolsadeideas.springboot.app.auth.service.JWTService;
import com.bolsadeideas.springboot.app.models.service.JpaUserDetailsService;

@EnableGlobalMethodSecurity(securedEnabled = true)
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private LoginSuccesHandler successHandler;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Autowired
	private JpaUserDetailsService userDetailsService;
	
	@Autowired
	private JWTService jwtService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/","/css/**", "/js/**","/images/**","/listar**","/locale").permitAll()
		/*.antMatchers("/ver/**").hasAnyRole("USER")
		.antMatchers("/uploads/**").hasAnyRole("USER")
		.antMatchers("/form/**").hasAnyRole("ADMIN")
		.antMatchers("/eliminar/**").hasAnyRole("ADMIN")
		.antMatchers("/factura/**").hasAnyRole("ADMIN")*/
		.anyRequest().authenticated()
		/*.and()
			.formLogin()
				.successHandler(successHandler)
				.loginPage("/login")
			.permitAll()
		.and()
		.logout().permitAll()
		.and()
		.exceptionHandling().accessDeniedPage("/error_403")*/
		.and()
		//El metodo authenticationManager es un metodo de la clase WebSecurityConfigurerAdapter
		.addFilter(new JWTAuthenticationFilter(authenticationManager(), jwtService))
		.addFilter(new JWTAuthorizationFilter(authenticationManager(),jwtService))
		//deshabilitar csrf para usar JWT
		.csrf().disable()
		//Deshabilitar el uso de sessiones para JWT
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}



	
	
	@Autowired
	public void configurerGlobal(AuthenticationManagerBuilder builder) throws Exception {
	
		//Configurando jpa
		builder.userDetailsService(userDetailsService)
		.passwordEncoder(passwordEncoder);
		
		
		/*
		//Configurar JDBC
		builder.jdbcAuthentication()
		.dataSource(dataSource)
		.passwordEncoder(passwordEncoder)
		.usersByUsernameQuery("Select username, password, enable from users where username=?")
		.authoritiesByUsernameQuery("select u.username,a.authority from authorities a inner join users u on(a.user_id=u.id) where u.username=?");
		
		*/
		
		/*	
		//Codificar la contraseña
		PasswordEncoder encoder = this.passwordEncoder;
		
		//Se configura la forma en que se encripta la contraseña de los usurios
		UserBuilder user = User.builder().passwordEncoder(password -> encoder.encode(password));
		
		//Guardar los usuario en memoria
		builder.inMemoryAuthentication()
		.withUser(user.username("admin").password("12345").roles("ADMIN","USER"))
		.withUser(user.username("ismael").password("ismael23").roles("USER"));
		*/
	}

}
