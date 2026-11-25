package application;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class EmploymentFormDao {

//method to get info and send to data base
    public int saveEmploymentForm(EmploymentForm employment) throws SQLException {

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //get   connections form database class
            connection = Database.getDBConnection();
         
            String query = "INSERT INTO user(username, last_name, first_name, password) " + "VALUES(?, ?, ?, ?)";
          //prepared statement
            statement = connection.prepareStatement(query);

            statement.setString(1, employment.getUsername());
            statement.setString(2, employment.getLastName());
            statement.setString(3, employment.getFirstName());
            statement.setString(4, employment.getPassword());

            //run sql command
            statement.executeUpdate();

            //if successfull return 1
            return 1;
        } finally {

            //close statement and connection when when finished
            if (statement != null) {
                statement.close();
            }

            if (connection != null) {
                connection.close();
            }
        }
    }
}