package config;

import entities.Role;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import services.AuthClientService;
import services.role.RoleService;
import services.user.UserService;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * Created by Corentin on 19/06/2017.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Resource(name = "authClientService")
    private AuthClientService authClientService;

    @Resource(name = "userService")
    private UserService userService;

    @Resource(name = "roleService")
    private RoleService roleService;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeRequests()
                .antMatchers( "/login/", "/login/action", "/login/change").permitAll()
                .antMatchers("/stats/**", "/session/**","/user/**" ).fullyAuthenticated()
                .and()
                .formLogin()
                .loginPage("/login/")
                .loginProcessingUrl("/login.do")
                .usernameParameter("username")
                .passwordParameter("password")
                .defaultSuccessUrl("/login/action/success/")
                .failureUrl("/login/")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login/")
                .and()
                .sessionManagement()
                .invalidSessionUrl("/login/")
                .maximumSessions( 1 );

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authClientService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(roleService.findByName("ROLE_USER") == null){
            Role role = new Role();
            role.setName("ROLE_USER");
            roleService.save(role);
        }
        if(roleService.findByName("ROLE_ADMIN") == null){
            Role role = new Role();
            role.setName("ROLE_ADMIN");
            roleService.save(role);
        }
        if(roleService.findByName("ROLE_REDACTOR") == null){
            Role role = new Role();
            role.setName("ROLE_REDACTOR");
            roleService.save(role);
        }
        if(userService.findByUsername("Admin") == null){
            User user = new User("Admin", passwordEncoder.encode("azerty"), 22);
            user.setRoles(Arrays.asList(roleService.findByName("ROLE_ADMIN")));
            userService.save(user);
        }
        if(userService.findByUsername("Redactor") == null){
            User user = new User("Redactor", passwordEncoder.encode("azerty"), 22);
            user.setRoles(Arrays.asList(roleService.findByName("ROLE_REDACTOR")));
            userService.save(user);
        }
        if(userService.findByUsername("User") == null){
            User user = new User("User", passwordEncoder.encode("default"), 22);
            user.setRoles(Arrays.asList(roleService.findByName("ROLE_USER")));
            userService.save(user);
        }
        builder.userDetailsService(authClientService).passwordEncoder(passwordEncoder);
    }
}
