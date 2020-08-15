package cn.liuhp.backup;

import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * @description: 这个尼玛不是有多线程问题吗，存在共享变量。
 * @author: liuhp534
 * @create: 2020-08-15 17:33
 */
public class CustomLocaleResolver extends AcceptHeaderLocaleResolver  {

    private Locale locale;

    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {
        this.locale = locale == null ? request.getLocale() : locale;
    }
}
