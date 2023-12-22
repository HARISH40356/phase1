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
 * Servlet implementation class RemoveFromFavorite
 */
@WebServlet("/RemoveFromFavorite")
public class RemoveFromFavorite extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RemoveFromFavorite() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse
    		response)
    		throws ServletException, IOException {
    		String id = request.getParameter("id");
    		// Perform necessary operations to remove the item from favorites
    		try {
    		// Establish database connection
    		Class.forName("com.mysql.jdbc.Driver");
    		Connection connection =
    		DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/railway","root","VHcse@9940691556");
    		// Prepare SQL statement to delete the favorite crossing
    		String sql = "DELETE FROM favorites WHERE id = ?";
    		PreparedStatement statement = connection.prepareStatement(sql);
    		statement.setString(1, id);
    		// Execute the SQL statement
    		int rowsAffected = statement.executeUpdate();
    		// Close the database connection
    		statement.close();
    		connection.close();
    		// Redirect the user back to the user home page
    		response.sendRedirect("favorite.jsp");
    		} catch (ClassNotFoundException | SQLException e) {
    		e.printStackTrace();
    		}
    		}
    		}
