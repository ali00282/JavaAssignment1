/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

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

/**
 *
 * @author Tariq Ali
 * 
 * This Class shows that how user entered data will be stored in hashMap that we have in PlayerDAO
 
 */
@WebServlet(name = "CreatePlayer", urlPatterns = {"/CreatePlayer"})

//    To make this class HttpServelet, We extends class from SuperClass(HttServelet).
public class CreatePlayer extends HttpServlet {

    
    /*This method has PrintWriter class that allow us to create dynamic web page.
    By using PrintWriter, we allow user to enter data in html form.
    It has two Parameters, (HttpServelet, Request, Response).
    HttpServeletRequest is a request from user that is sent to server by client. 
    HttpServeletResponse is a response from Server that is requested by client.
            In our case, Our create player form is HttpServeletRequest.
            while, storing user entered data in HashMap(parameterMap) is HttpServeletResponse.*/
            
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet CreatePlayer</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<div class=\"heading\">" );
            out.println("<h1 align=\"center\">CreatePlayer Form</h1>");
            out.println("</div>");
            out.println("<link rel=\"stylesheet\" type=\"text/css\" href=\"CreatePlayerStyle.css\">");
            out.println("<center>");
            out.println("<div class=\"loginbox>");            
            out.println("<div style=\"text-align: center;\">");
            out.println("<div style=\"display: inline-block; text-align: left;\">");
            out.println("<Form action=\"CreatePlayer\" method=\"post\">");
            out.println("<p>Player ID:</p>");
            out.println("<input type=\"text\" name=\"id\" placeholder=\"123\">" );
            out.println("<p>First Name:</p>");
            out.println("<input type=\"text\" name=\"firstName\" placeholder=\"Muhmmad\" >");
            out.println("<p>Last Name:</p>");
            out.println("<input type=\"text\" name=\"lastName\" placeholder=\"Salah\">");  
            out.println("<p>Username:</p>");
            out.println("<input type=\"text\" name=\"username\" placeholder=\"Simple Name\">");
            out.println("<p>Email:</p>");
            out.println("<input type=\"text\" name=\"email\" placeholder=\"abc@abc.com\" >"); 
            out.println("<br><br>");
            out.println("<input type=\"submit\" value=\"Create Player\" style=\"color:green\">");
            out.println("</center>");
            out.println("</div>");
            out.println("</Form>");
            out.println("<pre>");
            out.println("<center>");
            out.println("<div class=\"map\" style=\"color: wheat\" >");
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
    
    
//    This method stores all user entered data in Map<String, String[]> values
//        which will be used in doPost or doGet method.
    private void submit(Map<String, String[]> values){
        
        PlayerLogic logic = new PlayerLogic();
        
        logic.createEntity(values);
        
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
        
//        By using submit mehtod, It makes user entered data secure. 
//        Meaning that it will not be showed on the tab bar when user entered data.

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
