package com.s_giken.training.webapp;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Spring Securityの設定クラス
 */
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    /**
     * Spring Securityの設定
     * ルート以下のアクセスは認証が必要
     * ログインページはカスタムの /login
     * 
     * @param http HttpSecurityオブジェクト
     * @return SecurityFilterChainオブジェクト
     * @throws Exception 例外全般
     */
    @Bean
    public SecurityFilterChain webSecurityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(csrf -> csrf.disable()) // CSRF対策を無効化
                .headers((header) -> header.frameOptions().disable())
                .securityMatcher("/h2-console/**")
                .formLogin((form) -> form
                        .defaultSuccessUrl("/")
                        .loginProcessingUrl("/login")
                        .loginPage("/login")
                        .failureUrl("/login?error")
                        .permitAll())
                .logout((logout) -> logout
                        .logoutSuccessUrl("/"))
                .authorizeHttpRequests((authorize) -> authorize
                        .anyRequest().authenticated());

        return http.build();
    }

    /**
     * ログインユーザー情報を設定する
     * ユーザ名user、パスワードpasswordでログインできるようになる。
     * ※パスワードはハッシュ化せずにそのまま設定
     * 
     * @return ログインユーザー情報
     */
    @Bean
    public UserDetailsService users() {
        var user = User
                .builder()
                .username("user")
                .password("$2a$10$Jjf89PMWEuE1JOFF57rw2.Ny64pJbWTnvJB5PBLSbP27R6.nKOC1e") // password
                .roles("USER")
                .build();
        return new InMemoryUserDetailsManager(user);
    }

    /**
     * パスワードをBcryptでハッシュ化するオブジェクトを生成する
     * 
     * @return パスワードをハッシュ化するエンコーダーのオブジェクト
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
