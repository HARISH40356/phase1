package favorite;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DeleteRecords
 */
@WebServlet("/DeleteRecords")
public class DeleteRecords extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteRecords() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse
    		response)
    		throws ServletException, IOException {
    		String id = request.getParameter("id");
    		// Check if ID is provided
    		if (id != null && !id.isEmpty()) {
    		try {
    		// Database connection details
    		String url = "jdbc:mysql://127.0.0.1:3306/railway";
    		String user = "root";
    		String password = "VHcse@9940691556";
    		// Create database connection
    		Connection conn = DriverManager.getConnection(url, user, password);
    		// Prepare and execute the delete statement
    		String sql = "DELETE FROM adminhome WHERE id = ?";
    		PreparedStatement pstmt = conn.prepareStatement(sql);
    		pstmt.setString(1, id);
    		pstmt.executeUpdate();
    		// Close resources
    		pstmt.close();
    		conn.close();
    		// Redirect back to delete.jsp with success message
    		response.sendRedirect("adminhome.jsp");
    		} catch (SQLException e) {
    		e.printStackTrace();
    		// Handle database errors
    		response.sendRedirect("delete.jsp?error=true");
    		}
    		} else {
    		// ID is not provided, redirect back to delete.jsp with error message
    		response.sendRedirect("delete.jsp?error=true");
    		}
    		}
    		}
    		