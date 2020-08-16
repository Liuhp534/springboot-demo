package cn.liuhp.pojo;


import cn.liuhp.annotation.EnumI18n;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.util.StringUtils;

import java.util.Arrays;
import java.util.List;
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
@EnumI18n
public enum ResponseEnum implements EnumInterface, EnumValuesInterface {

    /**
     * 枚举在变量之前
     */
    Success("0", "成功{0},{1},{2}","success"),
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

    @Override
    public String getCode() {
        return code;
    }

    @Override
    public String getZh() {
        return zh;
    }

    @Override
    public String getEn() {
        return en;
    }


    @Override
    public EnumInterface[] enumToList() {
        return ResponseEnum.values();
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
        /*EnumInterface enumInterface = ResponseEnum.Fail;
        System.out.println(enumInterface.getCode());
        System.out.println(enumInterface.getZh());
        System.out.println(enumInterface.getEn());
        System.out.println(ResponseEnum.Fail.getI18nMsg());*/

        System.out.println(ResponseEnum.Fail.getI18nMsg());
        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000; i ++) {
            ResponseEnum.Fail.getI18nMsg();
            //ResponseEnum.Success.getI18nMsg("one", "two", "xxxxxxxxxxxxxxxxxxxxx");
        }
        System.out.println(System.currentTimeMillis() - start);

    }



}
 