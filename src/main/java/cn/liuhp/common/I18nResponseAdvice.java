package cn.liuhp.common;

import cn.liuhp.pojo.Response;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Locale;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-08-15 21:54
 */
@ControllerAdvice
public class I18nResponseAdvice implements ResponseBodyAdvice {

    @Override
    public boolean supports(MethodParameter returnType, Class converterType) {
        if (returnType.hasMethodAnnotation(RequestMapping.class)) {
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType,
                                  MediaType selectedContentType, Class selectedConverterType, ServerHttpRequest request, ServerHttpResponse response) {
        if (null != body && body instanceof Response) {
            Response i18nResponse = (Response) body;
            Locale locale = LocaleContextHolder.getLocale();
            String msg = I18nContextHolder.convertMsg(i18nResponse.getCode(), locale.getLanguage(), i18nResponse.getResArgs());
            i18nResponse.setMsg(msg);
            return i18nResponse;
        }
        return body;
    }
}
