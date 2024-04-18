package hotel.demo;

import java.util.Locale;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@Configuration
public class ProjectConfig implements WebMvcConfigurer {

    @Bean
    public LocaleResolver localeResolver() {
        var slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.getDefault());
        slr.setLocaleAttributeName("session.current.locale");
        slr.setTimeZoneAttributeName("session.current.timezone");
        return slr;
    }

    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        var lci = new LocaleChangeInterceptor();
        lci.setParamName("lang");
        return lci;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registro) {
        registro.addInterceptor(localeChangeInterceptor());
    }

    @Bean("messageSource")
    public MessageSource messageSource() {
        ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
        messageSource.setBasenames("messages");
        messageSource.setDefaultEncoding("UTF-8");
        return messageSource;
    }

    /* Los siguiente métodos son para implementar el tema de seguridad dentro del proyecto */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/login").setViewName("login");
        registry.addViewController("/mensaje").setViewName("mensaje");
    }

   @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {http.authorizeHttpRequests((request) -> request.requestMatchers("/", "/index","/mensaje", "/errores/**", "/js/**","/css/**","/images/**", "/webjars/**","/registro/**","/reserva/**","/reserva/listado","/reserva/modificar/**", "/reserva/eliminar/**",
                        "/hotel/nuevo","/hotel/guardar","/hotel/listado",
                        "/hotel/modificar/**", "/hotel/eliminar/**",
                        "/usuario/nuevo", "/usuario/guardar","/usuario/listado",
                        "/usuario/modificar/**","/usuario/eliminar/**").permitAll()
                .requestMatchers("/reserva/reserva", "/reserva/guardar","/reserva/mensaje").hasRole("USER").requestMatchers(
                        "/reserva/**","/reserva/listado","/reserva/modificar/**", "/reserva/eliminar/**",
                        "/hotel/nuevo","/hotel/guardar","/hotel/listado",
                        "/hotel/modificar/**", "/hotel/eliminar/**",
                        "/usuario/nuevo", "/usuario/guardar","/usuario/listado",
                        "/usuario/modificar/**","/usuario/eliminar/**").hasRole("ADMIN")).formLogin((form) -> form.loginPage("/login").permitAll()).logout((logout) -> logout.permitAll());
        return http.build();
    }
    
    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    public void configurerGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());

    }
}
