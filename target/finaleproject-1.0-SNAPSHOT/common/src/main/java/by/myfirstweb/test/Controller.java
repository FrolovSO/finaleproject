package by.myfirstweb.test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
public class Controller extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        processRequest(request, response);
    }
    protected void doPost(HttpServletRequest request, HttpServletResponse
            response) throws ServletException, IOException {
        processRequest(request, response);
    }
    private void processRequest(HttpServletRequest request, HttpServletResponse
            response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head>");
        out.println("<%@ page language=\"java\" contentType=\"text/html; charset=utf-8\"\n" +
                "    %>");
        out.println("<title>Title</title>");
        out.println("</head><body>");
        out.println("<h1> Hello, world!!! </h1>");
        out.println("</body></html>");
    }
}
