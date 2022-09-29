package main.sub;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import selenium.CloudFlarePage;
import selenium.GooglePage;

public class Main {

  public static void main(String... args) throws ClassNotFoundException, SQLException {
    Class.forName("com.mysql.cj.jdbc.Driver");
    Connection con =
        DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "user", "password");
    Statement stmt = con.createStatement();

    stmt.execute("insert into Persons (LastName, FirstName, Address, City)\n" +
        "VALUES ('Doe', 'John', 'Street 1', 'London')");

    ResultSet rs = stmt.executeQuery("select * from Persons where City = 'London'");

    while (rs.next()) {
      System.out.print(rs.getString("FirstName") + " ");
      System.out.print(rs.getString("LastName") + " ");
      System.out.print(rs.getString("City") + " ");
      System.out.println(rs.getString("Address"));
    }
    con.close();

  }

  public static void cloudFlareCookiesTest(CloudFlarePage cloudFlarePage) {
    cloudFlarePage.loadPage();
    cloudFlarePage.waitForAcceptCookiesBtn().click();
  }

  public static void testGoogleOne(GooglePage googlePage) {
    googlePage.loadPage();
    googlePage.acceptCookies();
    googlePage.setSearchValue("news Ukraine");
    googlePage.pressSearchButton();
  }

  public static void testGoogleTwo(GooglePage googlePage) {
    googlePage.loadPage();
    googlePage.setSearchValue("news World");
    googlePage.pressFeelingLucky();
  }

}