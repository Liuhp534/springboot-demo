package cn.liuhp.core.controller;

import cn.liuhp.pojo.Response;
import cn.liuhp.pojo.ResponseEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-08-15 12:02
 */
@RestController
@RequestMapping("/local")
public class LocalController {

    private Logger logger = LoggerFactory.getLogger(LocalController.class);

    @Autowired
    private MessageSource messageSource;

    @RequestMapping("/hello")
    public Response local() {
        // 后台获取国际化区域
        Locale locale = LocaleContextHolder.getLocale();
        String message = messageSource.getMessage("user.name", null, locale);
        Response response = new Response();
        response.fail(ResponseEnum.Fail);
        return response;
    }

}
