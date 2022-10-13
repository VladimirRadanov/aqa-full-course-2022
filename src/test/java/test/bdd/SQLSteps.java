package test.bdd;

import org.springframework.beans.factory.annotation.Autowired;
import test.dto.PersonNameDto;
import test.dto.ResultsDto;
import io.cucumber.java.en.Given;
import test.main.util.DataHolder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLSteps extends BaseStep {

    @Autowired
    private DataHolder dataHolder;

    private final static String INSERT_QUERY =
            "insert into Persons (LastName, FirstName, Address, City)\n" +
                    "VALUES ('%s', '%s', 'Street 1', 'London')";

    @Given("save random user {string} to DB")
    public void saveUser(String alias) throws SQLException, ClassNotFoundException {
        ResultsDto searchResult = dataHolder.get(alias, ResultsDto.class);
        insertToDB(searchResult.getResults().get(0).getName());
    }

    private void insertToDB(PersonNameDto personNameDto) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con =
                DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
        Statement stmt = con.createStatement();

        stmt.execute(String.format(INSERT_QUERY, personNameDto.getLast(), personNameDto.getFirst()));
    }
}
