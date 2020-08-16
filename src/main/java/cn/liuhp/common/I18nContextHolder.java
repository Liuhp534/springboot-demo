package cn.liuhp.common;

import cn.liuhp.pojo.EnumInterface;
import cn.liuhp.pojo.ResponseEnum;

import java.text.MessageFormat;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-08-15 22:03
 */
public final class I18nContextHolder {

    private static volatile Map<String, EnumInterface>  i18nMap ;


    public static String convertMsg(String code, String locale, Object ... args) {
        EnumInterface enumInterface = i18nMap.get(code);
        if ("zh".equalsIgnoreCase(locale)) {
            return MessageFormat.format(enumInterface.getZh(), args);
        } else {
            return MessageFormat.format(enumInterface.getEn(), args);
        }
    }


    public static Map<String, EnumInterface> getI18nMap() {
        if (null == i18nMap) {
            synchronized (I18nContextHolder.class) {
                if (null == i18nMap) {
                    i18nMap = new ConcurrentHashMap<>(256);
                }
            }
        }
        return i18nMap;
    }

}
