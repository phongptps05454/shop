/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.BillDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.Session;

/**
 *
 * @author Admin
 */
public class ManagerBillServlet extends HttpServlet {

    BillDAO billDAO = new BillDAO();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String command = request.getParameter("command");
        String billID = request.getParameter("billID");

        String url = "";
        try {
            switch (command) {
                case "paid_bill":
                    billDAO.paidBill(Long.parseLong(billID));
                    url = "/admin/management_bill.jsp";
                    break;
                case "approve_bill":
                    billDAO.approveBill(Long.parseLong(billID));
                    url = "/admin/management_bill.jsp";
                    break;
                case "delete_bill":
                    billDAO.deleteBill(Long.parseLong(billID));
                    url = "/admin/management_bill.jsp";
                    break;
            }
        } catch (Exception e) {

        }
        RequestDispatcher rd = getServletContext().getRequestDispatcher(url);
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
