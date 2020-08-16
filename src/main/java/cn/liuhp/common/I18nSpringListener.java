package cn.liuhp.common;

import cn.liuhp.pojo.EnumInterface;
import cn.liuhp.pojo.ResponseEnum;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-08-15 22:01
 */
@Component
public class I18nSpringListener implements ApplicationListener<ContextRefreshedEvent> {


    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        final Map<String, EnumInterface> i18nMap = I18nContextHolder.getI18nMap();

        List<EnumInterface> allEnums = ClassScaner.analysisPackage("cn.liuhp.**");
        for (EnumInterface enumInterface : allEnums) {
            i18nMap.put(enumInterface.getCode(), enumInterface);
        }

    }
}
