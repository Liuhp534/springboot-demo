package cn.liuhp.pojo;


import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.StringUtils;

import java.util.Locale;

/**
 * <p>
 * <p>
 * <p>
 * 行星枚举：使用的规则，常用的方法配制。
 * 枚举不可变的、
 * </p>
 *
 * @author hz16092620
 * @date 2018年9月5日 下午8:09:34
 */
public enum ResponseEnum {

    /**
     * 枚举在变量之前
     */
    Success("0", "成功","success"),
    Fail("999", "失败", "fail");

    /**
     * 枚举不可变的，变量设置成final，添加对应的访问方法
     */
    private final String code;

    private final String zh;

    private final String en;


    /**
     * 不需要权限修饰符修饰，构造函数
     */
    ResponseEnum(String code, String zh, String en) {
        this.code = code;
        this.zh = zh;
        this.en = en;
    }



    public String getCode() {
        return code;
    }

    public String getZh() {
        return zh;
    }

    public String getEn() {
        return en;
    }

    public String getMsg() {
        Locale locale = LocaleContextHolder.getLocale();
        if ("zh".equalsIgnoreCase(locale.getLanguage())) {
            return this.zh;
        } else {
            return this.en;
        }
    }

    /**
     * 根据value获取对应的枚举
     */
    public static ResponseEnum getByValue(String value) {
        ResponseEnum result = null;
        if (StringUtils.isEmpty(value)) {
            return result;
        }
        for (ResponseEnum tempEnum : ResponseEnum.values()) {
            if (value.equals(tempEnum.code)) {
                result = tempEnum;
                break;
            }
        }
        return result;
    }


    public static void main(String[] args) {
        System.out.println(ResponseEnum.Fail.getMsg());
    }


}
 