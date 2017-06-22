package config;

import entities.Role;
import entities.User;
import org.springframework.beans.factory.annotation.Autowired;
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

import java.util.Arrays;

/**
 * Created by Corentin on 19/06/2017.
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

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
                .sessionManagement()
                .invalidSessionUrl("/login/")
                .maximumSessions( 1 );

    }

    @Autowired
    private AuthClientService authClientService;
    @Autowired
    private UserService userService;
    @Autowired
    private RoleService roleService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authClientService).passwordEncoder(new BCryptPasswordEncoder());
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        if(roleService.findById(User.ROLE_USER) == null){
            Role role = new Role();
            role.setRoleId(User.ROLE_USER);
            role.setRoleName("ROLE_USER");
            roleService.save(role);
        }
        if(roleService.findById(User.ROLE_ADMIN) == null){
            Role role = new Role();
            role.setRoleId(User.ROLE_ADMIN);
            role.setRoleName("ROLE_ADMIN");
            roleService.save(role);
        }
        if(roleService.findById(User.ROLE_READER) == null){
            Role role = new Role();
            role.setRoleId(User.ROLE_READER);
            role.setRoleName("ROLE_READER");
            roleService.save(role);
        }
        if(userService.findByUsername("Admin") == null){
            User user = new User("Admin", passwordEncoder.encode("azerty"), 22);
            user.setRoles(Arrays.asList(roleService.findById(User.ROLE_ADMIN)));
            userService.save(user);
        }
        if(userService.findByUsername("User") == null){
            User user = new User("User", passwordEncoder.encode("default"), 22);
            user.setRoles(Arrays.asList(roleService.findById(User.ROLE_USER)));
            userService.save(user);
        }
        builder.userDetailsService(authClientService).passwordEncoder(passwordEncoder);
    }
}
