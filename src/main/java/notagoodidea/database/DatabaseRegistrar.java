package notagoodidea.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import notagoodidea.model.User;

@Component
public class DatabaseRegistrar {

    private JdbcTemplate jdbcTemplate;

    public DatabaseRegistrar(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private String query = "INSERT INTO USERS(name, password) VALUES (\"%s\", \"%s\");";

    public void registerOnDatabase(User user) {
        jdbcTemplate.update(query.formatted(user.getName(), user.getPassword()));
    }
}
