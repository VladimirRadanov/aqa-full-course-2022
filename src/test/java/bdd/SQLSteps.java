package bdd;

import dto.PersonNameDto;
import dto.ResultsDto;
import io.cucumber.java.en.Given;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class SQLSteps extends BaseStep {

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
