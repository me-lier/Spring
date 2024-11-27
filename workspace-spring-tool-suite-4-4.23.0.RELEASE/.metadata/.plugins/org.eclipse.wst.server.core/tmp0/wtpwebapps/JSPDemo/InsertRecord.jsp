<%@ page import="java.sql.*" %>
<%@ page import="java.io.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert User</title>
</head>
<body>
    <h2>Insert New User</h2>
    <form action="InsertRecord.jsp" method="post">
    	<label for="id">ID:</label>
        <input type="number" id="id" name="id" required><br><br>
        
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required><br><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" required><br><br>

        <label for="country">Country:</label>
        <input type="text" id="country" name="country" required><br><br>

        <label for="age">Age:</label>
        <input type="number" id="age" name="age" required><br><br>

        <input type="submit" value="Insert">
    </form>


    <%
        // Process form data (Insert into the database)
        if (request.getMethod().equalsIgnoreCase("POST")) {
        	String id = request.getParameter("id");
            String username = request.getParameter("username");
            String email = request.getParameter("email");
            String country = request.getParameter("country");
            String age = request.getParameter("age");

            Connection conn = null;
            PreparedStatement stmt = null;

            String url = "jdbc:mysql://localhost:3306/practice";  // Database URL
            String dbUser = "root";  // Database username
            String dbPassword = "vidhi2312";  // Database password

            try {
                // Load the MySQL JDBC driver
                Class.forName("com.mysql.cj.jdbc.Driver");

                // Establish the connection to the database
                conn = DriverManager.getConnection(url, dbUser, dbPassword);

                // Prepare the SQL insert statement
                String sql = "INSERT INTO users VALUES (?, ?, ?, ?, ?)";
                stmt = conn.prepareStatement(sql);
                stmt.setInt(1, Integer.parseInt(id));
                stmt.setString(2, username);
                stmt.setString(3, email);
                stmt.setString(4, country);
                stmt.setInt(5, Integer.parseInt(age));

                // Execute the insert operation
                int rowsInserted = stmt.executeUpdate();

                if (rowsInserted > 0) {
                    out.println("<h3>User inserted successfully!</h3>");
                    String q = "SELECT * FROM users";
                    Statement cstmt = conn.createStatement();
                    ResultSet rs = cstmt.executeQuery(q);

                    out.println("<h2>User Records:</h2>");
                    out.println("<table border='1'><tr><th>ID</th><th>Username</th><th>Email</th><th>Country</th><th>Age</th></tr>");

                    // Loop through the result set and display the records
                    while (rs.next()) {
                        int uid = rs.getInt("id");
                        String name = rs.getString("name");
                        String email_id = rs.getString("email");
                        String con = rs.getString("country");
                        int u_age = rs.getInt("age");

                        out.println("<tr><td>" + uid + "</td><td>" + name + "</td><td>" + email_id + "</td><td>" + con + "</td><td>" + u_age + "</td></tr>");
                    }

                    out.println("</table>");
                } else {
                    out.println("<h3>Error inserting user.</h3>");
                }
            } catch (Exception e) {
                out.println("Error: " + e.getMessage());
            } finally {
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            }
        }
    %>
</body>
</html>
