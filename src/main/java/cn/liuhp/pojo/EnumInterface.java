package cn.liuhp.pojo;

import cn.liuhp.annotation.EnumI18n;
import org.springframework.context.i18n.LocaleContextHolder;

import java.text.MessageFormat;
import java.util.Locale;

public interface EnumInterface {

    String getCode();

    String getZh();

    String getEn();

      /*
       * 方式一，通过枚举内部进行处理
       * */
    default String getI18nMsg() {
        return this.getI18nMsg(null);
    }

    /*
     * 方式一，通过枚举内部进行处理
     * */
    default String getI18nMsg(Object ... args) {
        Locale locale = LocaleContextHolder.getLocale();
        if ("zh".equalsIgnoreCase(locale.getLanguage())) {
            return MessageFormat.format(this.getZh(), args);
        } else {
            return MessageFormat.format(this.getEn(), args);
        }
    }

}
