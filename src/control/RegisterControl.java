package control;

import model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Pulkit.singh on 1/9/2015.
 */

@Controller
public class RegisterControl {
    @RequestMapping("/register")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserDao dao = (UserDao) applicationContext.getBean("udao");

        User user = new User();
        user.setValues(username, password);

        boolean status = dao.authenticateUser(user);
        if (status) {
            return new ModelAndView("err", "message", "User Already registered");
        } else {
            dao.makeEntry(user);
            return new ModelAndView("welcome", "username", user.getUsername());
        }
    }
}
