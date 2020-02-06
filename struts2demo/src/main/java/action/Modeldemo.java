package action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Modeldemo extends ActionSupport implements ModelDriven<User> {
    User user=new User();
    @Override
    public User getModel() {
        return user;
    }
}
