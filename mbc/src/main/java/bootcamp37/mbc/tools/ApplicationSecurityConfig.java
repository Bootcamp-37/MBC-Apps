/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bootcamp37.mbc.tools;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 *
 * @author User
 */
@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter  {
    
    private final PasswordEncoder passwordEncoder;
   
    @Autowired
    public ApplicationSecurityConfig(PasswordEncoder passwordEncoder){
        this.passwordEncoder = passwordEncoder;
    }
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder(10);
//    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("templates/**","/css/**","/js/**","/fonts/**","/img/**","/scss/**","/jquery-ui/**","/jquery-knob/**","/jquery-easy-pie-chart/**","/contactform/**","/ckeditor/**","/chart-master/**","/fullcalendar/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
//        http.formLogin().permitAll();
//        http.logout().permitAll();
        http.authorizeRequests()
//                .antMatchers("/**","index","/register","/save").permitAll()
//                .antMatchers("/css/*","/js/*").permitAll()
//                .antMatchers("/trainer").hasAnyRole(ApplicationUserRole.TRAINER.name())
                .antMatchers("/employee").hasAnyRole(ApplicationUserRole.KARYAWAN.name())
                .antMatchers("/admin").hasAnyRole(ApplicationUserRole.ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
//                .httpBasic();
                .and()
                .logout().permitAll();
        http.csrf().disable();
    }
    
    
    
    @Override
    @Bean
    protected UserDetailsService userDetailsService(){
        UserDetails iqwal = User.builder()
                .username("iqwal")
                .password(passwordEncoder.encode("iqwal"))
                .roles(ApplicationUserRole.KARYAWAN.name())
                .build();
        UserDetails zakky = User.builder()
                .username("zakky")
                .password(passwordEncoder.encode("zakky"))
                .roles(ApplicationUserRole.KARYAWAN.name())
                .build();
        UserDetails admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("admin"))
                .roles(ApplicationUserRole.ADMIN.name())
                .build();
        return new InMemoryUserDetailsManager(iqwal,zakky,admin);
    }
    
    
    
    
}
