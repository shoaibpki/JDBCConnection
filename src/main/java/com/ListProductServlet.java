package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.simplilear.util.DBConnection;
/**
 * Servlet implementation class ListProductServlet
 */
@WebServlet("/listProduct")
public class ListProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		DBConnection dbconnection = new DBConnection();
		Connection connection = dbconnection.getConnection();
		
		try {
			//Step 3: Create Statement Object
			Statement stmt = connection.createStatement();
			
			//Step 4 : Execute query
			ResultSet rs = stmt.executeQuery("select * from eproduct");
			
			PrintWriter out = response.getWriter();
			out.println("<html><body>");
			while (rs.next()) {
				Integer id = rs.getInt("eproduct_id");
				String name = rs.getString("eproduct_name");
				Double price = rs.getDouble("eproduct_price");
				out.println(id);
				out.println(name);
				out.println(price + "<br>");
				
			}
			out.println("</html></body>");
			
			//Step 5 closing connection
			stmt.close();
			connection.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
