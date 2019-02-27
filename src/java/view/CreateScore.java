/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import entity.Player;
import static java.io.FileDescriptor.out;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Arrays;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import logic.PlayerLogic;
import logic.ScoreLogic;

/**
 *
 * @author Tariq Ali
 * 
 *  This Class shows that how user entered data will be stored in hashMap that we have in ScoreDAO
 */
@WebServlet(name = "CreateScore", urlPatterns = {"/CreateScore"})
public class CreateScore extends HttpServlet {

     /*This method has PrintWriter class that allow us to create dynamic web page.
    By using PrintWriter, we allow user to enter data in html form.
    It has two Parameters, (HttpServelet, Request, Response).
    HttpServeletRequest is a request from user that is sent to server by client. 
    HttpServeletResponse is a response from Server that is requested by client.
            In our case, Our create Score form is HttpServeletRequest.
            while, storing user entered data in HashMap(parameterMap) is HttpServeletResponse.*/
     
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
            out.println("<div class=\"heading\">" );
            out.println("<h1 align=\"center\">CreateScore Form</h1>");
            out.println("</div>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CreateScoreStyle.css\">");
            out.println("<center>");
            out.println("<div class=\"loginbox>");  
            out.println("<div style=\"text-align: center;\">");
            out.println("<div style=\"display: inline-block; text-align: left;\">");
            out.println("<Form action=\"CreateScore\" method=\"post\">");
            out.println("<p>Player ID:</p>");
            out.println("<input type=\"text\" name=\"playerID\" placeholder=\"Plz Enter Existing PlayerID\">" ); 
            out.println("<p>Score:</p>");
            out.println("<input type=\"text\" name=\"score\" placeholder=\"111\" >");
            out.println("<br>");
            out.println("<br>");
            out.println("<input type=\"submit\" value=\"Create Score\">");
            out.println("</center>");
            out.println("</div>");
            out.println("</Form>");
            out.println("<pre>");
            out.println("<center>");
            out.println("<div class=\"map\" style=\"color: white\" >");
            out.println(toStringMap(request.getParameterMap()));
            out.println("</div>");
            out.println("</center>");
            out.println("</pre>");
            out.println("</div>");
            out.println("</div>");
                    
//              ----------------------------------------------------------------------------------------

            
            out.println("</body>");
            out.println("</html>");
        }
    }
    
//    This method is used to see the details that are entered by user
     private String toStringMap(Map<String, String[]> values) {
        StringBuilder builder = new StringBuilder();
        values.forEach((k, v) -> builder.append("Key=").append(k)
                .append(", ")
                .append("Value/s=").append(Arrays.toString(v))
                .append(System.lineSeparator()));
        return builder.toString();
    }
     
     
     //    This method stores all user entered data in Map<String, String[]> values
//        which will be used in doPost or doGet method.
     private void submit(Map<String, String[]> values){
         
         ScoreLogic score = new ScoreLogic();
        
             score.createEntity(values);
        
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
        
     //   By using submit mehtod , It makes user entered data secure. 
    //    Meaning that it will not be showed on the tab bar when user entered data.
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
