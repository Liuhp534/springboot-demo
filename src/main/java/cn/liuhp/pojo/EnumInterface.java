package cn.liuhp.pojo;

import org.springframework.context.i18n.LocaleContextHolder;

import java.util.Locale;

public interface EnumInterface {

    String code();

    String zhMsg();

    String enMsg();

      /*
     * 方式一，通过枚举内部进行处理
     * */
      default String getMsg() {
        Locale locale = LocaleContextHolder.getLocale();
        if ("zh".equalsIgnoreCase(locale.getLanguage())) {
            return this.zhMsg();
        } else {
            return this.enMsg();
        }
    }

}
