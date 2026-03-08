package controller;

import dao.ProductVariantsDao;
import dao.ProductsDao;
import model.Cart;
import model.CartItems;
import model.ProductVariants;
import model.Products;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/cart")
public class CartController extends HttpServlet {

    public CartController() {
        super();
        // TODO Auto-generated constructor stub
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.getRequestDispatcher("/WEB-INF/views/cart.html").forward(request, response);

    }






}
