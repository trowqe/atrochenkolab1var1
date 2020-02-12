package com.bsuir.lab1;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletClass extends HttpServlet {
    Utils utils = new Utils();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();


        String header = request.getParameter("header");
        String rows = request.getParameter("rows");
        String columns = request.getParameter("columns");
        String color = request.getParameter("backgroundColor");

        String columnsWeight = request.getParameter("columnsWeight");
        String bordersWeight = request.getParameter("bordersWeight");

        out.println("<html>");
        out.println("<body>");

        boolean validRows = utils.isNumberFrom1to100(rows);
        out.println("validRows: "+ utils.isNumberFrom1to100(rows)+ " " + rows);
        if (!validRows) {
            return;
        }

        boolean validColumns= utils.isNumberFrom1to100(rows);
        out.println("validColumns: " + utils.isNumberFrom1to100(rows) + " " + columns);
        if (!validColumns) {
            return;
        }

        boolean validColumnsWeight= utils.isNumberFrom1to100(columnsWeight);
        out.println("validColumnsWight: " + utils.isNumberFrom1to100(columnsWeight)+ " " + columnsWeight);
        if (!validColumnsWeight) {
            return;
        }

        boolean validBordersWeight= utils.isNumberFrom1to100(bordersWeight);
        out.println("validBordersWight: " + utils.isNumberFrom1to100(bordersWeight)+ " " + bordersWeight);
        if (!validBordersWeight) {
            return;
        }

        out.println("<h3>"+header+"</h3>");

        generateTable(out, Integer.parseInt(rows), Integer.parseInt(columns), color, Integer.parseInt(columnsWeight), Integer.parseInt(bordersWeight));

        out.println("</body>");
        out.println("</html>");


    }

    private void generateTable(PrintWriter out, Integer rows, Integer columns, String color, Integer columnWeight, Integer bordersWeight){
        out.println("<table style='width:"+columnWeight+"%"+";background-color:"+color+";border:"+bordersWeight+"px solid black'>");
        for (int i=0; i < rows; i++) {
            out.println("<tr>");
            for (int j=0; j < columns; j++) {
                out.println("<td>"+i+"/"+j+"</td>");
            }
            out.println("</tr>");
        }
        out.println("</table>");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet " + this.getServletName() + " has started");
    }

    @Override
    public void destroy() {
        System.out.println("Servlet " + this.getServletName() + " has stopped");
    }
}
