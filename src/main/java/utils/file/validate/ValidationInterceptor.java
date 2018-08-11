package utils.file.validate;

import org.apache.log4j.Logger;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;

// 实现HandlerInterceptor 接口  才是一个spring mvc的拦截器
public class ValidationInterceptor implements HandlerInterceptor {

    private Logger logger = Logger.getLogger(ValidationInterceptor.class);

    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
        Boolean flag = true; //默认放行 不拦截
        // 1.取得HandlerMethod对象，这样可以取得相关的Action信息
        HandlerMethod handlerMethod = (HandlerMethod) o;
        // 2.通过要调用的业务名称以及要调用的业务方法与定义好的“rules”一起拼出的取出的验证规则
        String validationKey = handlerMethod.getBean().getClass().getSimpleName() + "."
                + handlerMethod.getMethod().getName() + ".rules";

        try {
            // 3. 现在取得验证规则的key的信息之后实际上并无法知道该key的具体内容是什么，而得到内容需要依靠
            // AbstractAction的getValue方法
            Method getValueMethod = handlerMethod.getBean().getClass().getMethod("getValue", String.class);
            String validationValue = (String) getValueMethod.invoke(handlerMethod.getBean(), validationKey);
            if (validationValue == null) {
                logger.info("[***********]");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        logger.info("[*****     preHandle *********]beanName=" + handlerMethod.getBean().getClass().getSimpleName() +
                ",methodName =" +
                handlerMethod.getMethod().getName());
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("[*****     postHandle    *********]" + o.getClass() + "modelAndView ===" + modelAndView);
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
        logger.info("[*****     afterCompletion    *********]" + o.getClass());
    }
}
