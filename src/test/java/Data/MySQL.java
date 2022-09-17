package Data;

import org.testng.annotations.DataProvider;

import java.sql.*;

public class MySQL
{
    @DataProvider
    public static Object[][] Info() throws SQLException
    {

        Object [][] data = new Object[1][2];

        Connection connection = DriverManager.getConnection("JDBC:MySQL://localhost:3306/pk","root","root");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("select * from info");
        while (result.next())
        {
            data[0][0] = result.getObject("User_id");
            data[0][1] =result.getObject("Password");
        }

        return data;
    }
}
