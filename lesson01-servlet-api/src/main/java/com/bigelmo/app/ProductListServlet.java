package com.bigelmo.app;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/products/*")
public class ProductListServlet extends HttpServlet {

    private ServletConfig config;
    private List<Product> list;

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        this.config = servletConfig;
    }

    @Override
    public ServletConfig getServletConfig() {
        return config;
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getQueryString() == null) {
            setList(new ArrayList<>());
            for (int i = 1; i <= 10; i++) {
                getList().add(new Product(i, "Product-"+i, Math.random()*100 + 50));
            }
            StringBuilder body = new StringBuilder();
            for (Product p : getList()) {
                body.append("<a href=\"/servlet-app/products?").append(p.getId()).append("\">").append(p).append("</a><br>");
            }
            resp.getWriter().println(body);
        } else {
            int id = Integer.parseInt(req.getQueryString());
            resp.getWriter().println(list.get(id-1));
        }
    }

    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {

    }

    public List<Product> getList() {
        return list;
    }

    public void setList(List<Product> list) {
        this.list = list;
    }
}
