package cn.liuhp.common;

import cn.liuhp.backup.CustomLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

import java.util.Locale;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-08-15 13:38
 */
@Configuration
public class ServerConfig extends WebMvcConfigurerAdapter {

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver sessionLocaleResolver = new SessionLocaleResolver();
        // 设置默认的国际化区域
        sessionLocaleResolver.setDefaultLocale(Locale.SIMPLIFIED_CHINESE);
        return sessionLocaleResolver;
    }

/*    @Bean("localeResolver")
    public LocaleResolver localResolver() {
        CustomLocaleResolver customLocaleResolver = new CustomLocaleResolver();
        return customLocaleResolver;
    }*/

    @Bean
    public CustomLocaleChangeInterceptor customLocaleChangeInterceptor() {
        return new CustomLocaleChangeInterceptor();
    }

    /*@Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
        // 设置拦截的参数名
        localeChangeInterceptor.setParamName("language");
        return localeChangeInterceptor;
    }*/


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //registry.addInterceptor(this.localeChangeInterceptor()).addPathPatterns("/**");
        registry.addInterceptor(this.customLocaleChangeInterceptor()).addPathPatterns("/**");
    }
}
