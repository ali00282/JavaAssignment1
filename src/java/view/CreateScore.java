/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.ScoreLogic;

/**
 *
 * @author Tariq Ali
 */
@WebServlet(name = "CreateScore", urlPatterns = {"/CreateScore"})
public class CreateScore extends HttpServlet {

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
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreateScore</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1 align=\"center\">Servlet CreateScore </h1>");
            
            out.println("<div style=\"text-align: center;\">");
            out.println("<div style=\"display: inline-block; text-align: left;\">");
            out.println("<Form action=\"CreateScore\" method=\"post\">");
            out.println("Player ID:");
            out.println("<br>");
            out.println("<input type=\"text\" name=\"playerID\" placeholder=\"123\">" );
            out.println("<br>");
            out.println("Score:<br>");
            out.println("<input type=\"text\" name=\"score\" placeholder=\"111\" ><br>");
            out.println("Submission:<br>");
//            out.println("<input type=\"date\" name=\"sub\" placeholder=\"LastName\"><br>");  
//            out.println("Join Date:<br>");
//            out.println("<input type=\"date\" name=\"joined\" placeholder=\"01-12-2000\" ><br>");
//            out.println("Email<br>");
//            out.println("<input type=\"text\" name=\"email\" placeholder=\"abc@abc.com\" ><br><br>");    
            out.println("<input type=\"submit\" value=\"Create Score\">");
            out.println("</Form>");
            out.println("<pre>");
            out.println(toStringMap(request.getParameterMap()));
            out.println("</pre>");
            out.println("</div>");
            out.println("</div>");
                    
//              ----------------------------------------------------------------------------------------

            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
     private String toStringMap(Map<String, String[]> values) {
        StringBuilder builder = new StringBuilder();
        values.forEach((k, v) -> builder.append("Key=").append(k)
                .append(", ")
                .append("Value/s=").append(Arrays.toString(v))
                .append(System.lineSeparator()));
        return builder.toString();
    }
     
     private void submit(Map<String, String[]> values){
         
         ScoreLogic score = new ScoreLogic();
         if (score.createEntity(values) == null){
            
             System.out.println("nothing");
         }
        
         else {
             
             score.createEntity(values);
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
        submit(request.getParameterMap());
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
