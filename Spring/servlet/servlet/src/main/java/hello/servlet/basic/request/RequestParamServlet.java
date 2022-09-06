package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Map;

@WebServlet(name="requestParamServlet", urlPatterns = "/request-param")
public class RequestParamServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username"); //단일 파라미터 조회

         Enumeration<String> parameterNames = request.getParameterNames(); //파라미터 이름들 모두 조회

        Map<String, String[]> parameterMap = request.getParameterMap(); //파라미터를 Map 으로 조회

        String[] usernames = request.getParameterValues("username"); //복수 파라미터 조회
        for(String name : usernames) {
            System.out.println("username =" + name);
        }

        response.getWriter().write("ok");
    }
}
