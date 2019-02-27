/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Player;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.PlayerLogic;

/**
 *
 * @author Tariq Ali
 */
@WebServlet(name = "PlayerTable", urlPatterns = {"/PlayerTable"})
public class PlayerTable extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
//    This method shows the Player Table in a Table form
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet PlayerTable</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"heading\" >");
            out.println("<h1 align=\"center\"> Player Table</h1>");
            out.println("</div>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"TableDisplayStyle.css\">");
            PlayerLogic logic = new PlayerLogic();
            List<Player> courses = logic.getAllPlayers();
            out.println("<table align=\"center\" border=\"2\" >");
//            out.println("<caption>Player Table</>");
            out.println("<tr>");
            out.println("<th>id</th>");
            out.println("<th>first_name</th>");
            out.println("<th>last_name</th>");
            out.println("<th>joined</th>");
            out.println("<th>email</th>");
            out.println("</tr>");
            for (Player course: courses){
                out.printf("<tr><td>%s</td><td>%s</td><td>%s</td><td>%s</td><td>%s</td></tr>", 
                        course.getId(), course.getFirstName(),course.getLastName(),course.getJoined(),course.getEmail());
            }
            out.println("</table>");
            out.println("</body>");
            out.println("</html>");
        }
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
