package notagoodidea.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import notagoodidea.model.User;

public class DatabaseRegistrar {

    private String query = "INSERT INTO USERS(name, password) VALUES (\"%s\", \"%s\");";
    private String connectionUrl = "jdbc:mysql://localhost:3306/users";

    public void registerOnDatabase(User user) {
        try (Connection connection = DriverManager.getConnection(connectionUrl, "den", "");
                PreparedStatement statement = connection.prepareStatement(
                        String.format(query, user.getName(), user.getPassword()))) {
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
