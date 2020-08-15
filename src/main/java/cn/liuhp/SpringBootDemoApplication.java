package cn.liuhp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.web.servlet.LocaleResolver;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-08-15 12:00
 */
@SpringBootApplication
public class SpringBootDemoApplication {


    public static void main(String[] args) {
        //SpringApplication.run(SpringBootDemoApplication.class, args);
        ApplicationContext ac = SpringApplication.run(SpringBootDemoApplication.class, args);
        //Arrays.stream(ac.getBeanNamesForType(LocaleResolver.class)).forEach(System.out::println);
        String[] beanNamesForType = ac.getBeanNamesForType(LocaleResolver.class);
        if(beanNamesForType.length > 0){
            for (String s: beanNamesForType) {
                System.out.println("================>" + s + "=" + s.getClass());
            }
        }

    }

}
