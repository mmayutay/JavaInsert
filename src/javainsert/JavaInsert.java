/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javainsert;

import static java.lang.Thread.sleep;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 *
 * @author yorongra_sd2081
 */
public class JavaInsert {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            // create a mysql database connection
            String myDriver = "com.mysql.jdbc.Driver";
            String myUrl = "jdbc:mysql://localhost/insertlastinjava";
            Class.forName(myDriver);
            Connection conn = DriverManager.getConnection(myUrl, "root", "");

            Statement st = conn.createStatement();
            int count = 0;
            System.out.println("Time Start: " + java.time.LocalTime.now());
            while (count != 1000) {
                int one = 1, two = 2, three = 3, four = 4, five = 5;
                String sqlString = "insert into tblinserted (first, second, third, forth, fifth, time)"
                        + " values " + "(" + one + "," + two + "," + three + "," + four + "," + five + ",'" + java.time.LocalTime.now() + "')";
                // note that i'm leaving "date_created" out of this insert statement
                st.executeUpdate(sqlString);
                count ++;
            }
            System.out.println("Time Ends: " + java.time.LocalTime.now());
            conn.close();
        } catch (Exception e) {
            System.err.println("Got an exception!");
            System.err.println(e.getMessage());
        }
    }

}
