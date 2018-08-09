package edu.poly.shop.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import edu.poly.shop.constants.ActionConstant;
import edu.poly.shop.domain.User;
import edu.poly.shop.service.UserService;
import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.InterceptorRef;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.interceptor.SessionAware;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.Map;
import java.util.Optional;
public class LoginAction extends ActionSupport implements Preparable, SessionAware, ModelDriven<User> {
    private User user;
    private Map<String, Object> session;

    @Autowired
    private UserService userService;

    @Action(value = "login", results = {
            @Result(name = "login", location = "/login.jsp"),
            @Result(name = "success", location = "/index.jsp")
    }, interceptorRefs = {
            @InterceptorRef(value = "defaultStack")
    })
    public String login() {
        if (user != null && user.getUsername() != null) {
            Optional<User> usr = userService.findByUsername(user.getUsername());

            if (usr == null) {
                return ActionConstant.LOGIN;
            }

            if (usr.get().getPassword().equals(user.getPassword())) {
                session.put("USER", usr.get());
                return SUCCESS;
            }
        }

        return ActionConstant.LOGIN;
    }

    @Override
    public User getModel() {
        return user;
    }

    @Override
    public void prepare() throws Exception {
        if (user == null)
            user = new User();
    }

    @Override
    public void setSession(Map<String, Object> session) {
        this.session = session;
    }
}
