package controller;

import model.Emp;
import model.User;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import service.UserService;

import javax.annotation.Resource;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @author:lidetian
 * @date: 2018/7/20
 * @system name:马达贷
 * @copyright:长安新生（深圳）金融投资有限公司
 */
@Controller
@RequestMapping("/user")
public class UserController {

    public static Logger logger = Logger.getLogger(UserController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("add")
    public String add(Emp emp) {  // 此时作为一个参数，并没有实例化
        logger.info(emp);
        return "";
    }
    @InitBinder        // 这个注解很重要  代表的是要初始化一个转换器
    public void initBinder(WebDataBinder binder) { // 方法名称自己随便写
        // WebDataBinder  代表的是web的数据的转化处理
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // 本方法的处理指的是追加有一个自定义的转换编辑器，如果遇见的操作目标类型为java.util.Data类
        // 则使用定义好的SimpleDateFormat类进行格式化处理，并切允许此参数的内容为空。
        binder.registerCustomEditor(java.util.Date.class, new CustomDateEditor(sdf, true));
    }

    @RequestMapping("/get")
    public Object get (HttpServletRequest request, HttpServletResponse response , int eid) {

        HttpSession session = request.getSession();  // 获取Session对象
        ServletContext application = session.getServletContext(); // 获取Application对象

        logger.info("***** contextPath = " + request.getContextPath());
        logger.info("**** sessionId =  "+ session.getId());
        logger.info("**** realPath  = " +application.getRealPath("/"));
        try {
            response.getWriter().println("Hello World ! ");
        } catch (IOException e) {
            e.printStackTrace();
        }
        Map map = new HashMap();
        map.put("asd","asd");

        return map;
    }

    @RequestMapping("list")
    public String test (@RequestParam(value = "cp",defaultValue = "1") int currp) {
        logger.info(currp);
        return "";
    }

    @RequestMapping("/findAllUser")
    public String findAllUser(HttpServletRequest request) {
        logger.info("11111111!!!!!!!!!!!!!!!!!!!!");
        List<User> listUser = userService.findAllUser();
        request.setAttribute("listUser",listUser);
        logger.info("!!!!!!!!!!!!!!!!!!!!");
        return "allUser";
    }
}
