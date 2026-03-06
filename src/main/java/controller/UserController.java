package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/user/*")
public class UserController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public UserController() {
        super();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String path = request.getPathInfo();

        if (path == null || path.equals("/")) {
            response.sendRedirect(request.getContextPath() + "/user/orders_his");
            return;
        }

        String url;

        switch (path) {
            case "/orders_his":
                url = "/WEB-INF/views/orders_his.html";
                break;
            case "/orders_shipping":
                url = "/WEB-INF/views/orders_shipping.html";
                break;
            case "/orders_delivered":
                url = "/WEB-INF/views/orders_delivered.html";
                break;
            case "/settings":
                url = "/WEB-INF/views/settings.html";
                break;
            case "/security":
                url = "/WEB-INF/views/settings_security.html";
                break;
            case "/address":
                url = "/WEB-INF/views/settings_address.html";
                break;
            case "/help":
                url = "/WEB-INF/views/help.html";
                break;
            default:
                response.sendError(HttpServletResponse.SC_NOT_FOUND);
                return;
        }

        request.getRequestDispatcher(url).forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}

