package controller;

import dao.ProductsDao;
import model.Category;
import model.ProductVariants;
import model.Products;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/shop")
public class ShopController extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public ShopController() {
        super();
        // TODO Auto-generated constructor stub
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/sproduct.jsp").forward(request,response);

    }







}
