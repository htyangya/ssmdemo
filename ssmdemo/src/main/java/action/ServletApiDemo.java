package action;

import com.opensymphony.xwork2.ActionSupport;
import org.apache.struts2.interceptor.ServletRequestAware;

import javax.servlet.http.HttpServletRequest;

public class ServletApiDemo extends ActionSupport implements ServletRequestAware{
    private HttpServletRequest request;

    @Override
    public void setServletRequest(HttpServletRequest httpServletRequest) {
        this.request=httpServletRequest;
    }

    @Override
    public String execute() throws Exception {
        return super.execute();
    }
}
