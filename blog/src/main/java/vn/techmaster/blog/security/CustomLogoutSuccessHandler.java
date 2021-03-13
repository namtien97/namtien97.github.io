package vn.techmaster.blog.security;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.SimpleUrlLogoutSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CustomLogoutSuccessHandler extends SimpleUrlLogoutSuccessHandler {
    @Override
    public void onLogoutSuccess(final HttpServletRequest request,final HttpServletResponse response,final Authentication authentication) throws IOException, ServletException {
        final String refererUrl = request.getHeader("Referer");
        System.out.println(refererUrl);
        super.onLogoutSuccess(request, response, authentication);
    }
}
