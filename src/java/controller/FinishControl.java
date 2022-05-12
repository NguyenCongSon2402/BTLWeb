/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BillDAO;
import dao.CartDAO;
import dao.ShipDAO;
import dao.UserDAO;
import entity.Account;
import entity.Cart;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ADMIN
 */
@WebServlet(name = "FinishControl", urlPatterns = {"/finish"})
public class FinishControl extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        request.setCharacterEncoding("UTF-8");
        CartDAO dao = new CartDAO();
        UserDAO udao = new UserDAO();
        BillDAO bill = new BillDAO();
        HttpSession session = request.getSession(); //Dùng session để gọi đến id
        Account a = (Account) session.getAttribute("account"); //Gọi đến account -> Phải ép kiểu để thành Object
        String fname = request.getParameter("firstname");
        String lname = request.getParameter("lastname");
        String email = request.getParameter("email");
        String address = request.getParameter("address");
        int id= a.getId();
        udao.addInfor(fname, lname, email, address, id);
        List<Cart> list = dao.getCart(id); //Truyền vào id của account
        int total = 0;

//        ShipDAO ShipDAO = new ShipDAO();
//        String cityName = request.getParameter("city");
//int city=Integer.parseInt(cityName);
//        System.out.println(city);
//        int shipValue = ShipDAO.getShipPriceByCityName(cityName);
//        System.out.println(shipValue);
//        System.out.println(list);
        for(Cart cart : list) {
            String nameP=cart.getP().getName();
            String image=cart.getP().getImage();
            int amount=cart.getAmount();
            int price = cart.getP().getPrice() * cart.getAmount();
            bill.addBill(id, nameP, image, amount, price);
            
        }
        dao.deleteCart1(a.getId());
        
        response.sendRedirect("Finish.jsp");
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
