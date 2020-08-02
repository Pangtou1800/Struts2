package pt.filter;

import pt.domain.Product;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.UUID;

public class FilterDispatcher implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        request.setCharacterEncoding("UTF-8");

        // 1. 获取ServletPath
        String path = request.getServletPath();
        System.out.println(path);

        // 2. 若ServletPath为input.action，则转发到该页面
        if ("/product-input.action".equals(path)) {
            request.getRequestDispatcher("/WEB-INF/pages/input.jsp").forward(servletRequest, servletResponse);
            return;
        }

        // 3. 若ServletPath为save.action，则保存数据后转到明细查看页面
        if ("/product-save.action".equals(path)) {
            // 1).获取参数
            String productName = request.getParameter("productName");
            String productDescription = request.getParameter("productDescription");
            String productPrice = request.getParameter("productPrice");
            // 2）把参数封装在一个对象中
            Product product = new Product(UUID.randomUUID().toString(), productName, productDescription, productPrice);
            // 3）执行一个保存操作
            System.out.println(product);
            request.setAttribute("product", product);

            request.getRequestDispatcher("/WEB-INF/pages/detail.jsp").forward(servletRequest, servletResponse);
            return;
        }

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
