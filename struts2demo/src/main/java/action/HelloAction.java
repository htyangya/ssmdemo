package action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.HttpParameters;

import javax.servlet.http.HttpServletRequest;

public class HelloAction extends ActionSupport {
    private  String userName;
    private String passWord;

    public String getUserName() {
        return userName;
    }

    public String getPassWord() {
        return passWord;
    }

    @Override
    public String execute(){
        System.out.println("hello 执行了！");
        ActionContext actionContext = ActionContext.getContext();
        ValueStack valueStack = actionContext.getValueStack();
        HttpParameters parameters = actionContext.getParameters();//获取request中的传递参数
        actionContext.put("xx",1);//request.add
        actionContext.getSession().put("xx",1);//session.add
        actionContext.getApplication().put("xx",1);//app.add

        HttpServletRequest request = ServletActionContext.getRequest();
        ValueStack v = (ValueStack) request.getAttribute(ServletActionContext.VALUE_STACK);
        return SUCCESS;
    }

    @Override
    public void validate() {
        if(userName==null || userName.length()==0){
            this.addFieldError("userName","用户名不能为空！");
        }
    }
}
