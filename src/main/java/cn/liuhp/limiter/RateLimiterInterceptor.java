package cn.liuhp.limiter;

import cn.liuhp.core.controller.LocalController;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Description:
 * Company: 顺丰科技有限公司国际业务科技部
 *
 * @Author: 01399178
 * Date: 2020/8/17 14:40
 */
public class RateLimiterInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(RateLimiterInterceptor.class);

    private RateLimiter rateLimiter = RateLimiter.create(1);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        if (rateLimiter.tryAcquire()) {
            logger.info("======成功请求======");
            return Boolean.TRUE;
        }
        logger.info("======失败请求======");
        return Boolean.FALSE;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);
    }
}
