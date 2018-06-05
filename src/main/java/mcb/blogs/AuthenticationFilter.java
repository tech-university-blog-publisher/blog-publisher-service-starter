package mcb.blogs;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.web.context.support.WebApplicationContextUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@Component
@Configuration
public class AuthenticationFilter extends GenericFilterBean {

    @Override
    protected void initFilterBean() throws ServletException {
        super.initFilterBean();
    }

    @Override
    public void doFilter(ServletRequest r, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        // inject BlogUser for request

        var blogUser = WebApplicationContextUtils
                .getRequiredWebApplicationContext(getFilterConfig().getServletContext())
                .getAutowireCapableBeanFactory().getBean(BlogUser.class);
        HttpServletRequest request = (HttpServletRequest) r;
        blogUser.setUsername(request.getHeader("Authorization"));
        chain.doFilter(r, response);
    }
}
