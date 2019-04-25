// all you have to do is add SELECT CLAUSES and replace the printf STATEMENTS

// YOU WILL HAVE TO LOOK AT THE "MysqlCreateDB" JAVA PROGRAM TO GET THE NEEDED
// FIELD NAMES FOR THE SELECTS AND FIELD TYPES AND FIELD SIZES FOR THE printf statements

// you must name the class your LAST NAME with Mysql - for example - GuynesMysql
// and the name of the java program to match - for example GuynesMysql.java

import java.util.Scanner;
import java.sql.*;
public class TakehomeFinal
{
    public static void main(String[] args)
    {
// Create a named constant for the URL.
        final String DB_URL = "jdbc:derby:Final; create=true";
        try
        {
// Create a connection to the database.
            Connection conn = DriverManager.getConnection(DB_URL);
// Create a Statement object.
            Statement stmt = conn.createStatement();
// leave the above code alone except for renaming the public class statement




// replace the following SELECT with the 1ST QUERY and name it sqlStatement1
            String sqlStatement1 =
                    "SELECT VendId, COUNT(*) AS NumProds FROM Products GROUP BY VendId";

// name the results from the query result1
            ResultSet result1 = stmt.executeQuery(sqlStatement1);
            System.out.println("\nThe output from Page 112: ");

            while (result1.next())
            {
// REPLACE THE FOLLOWING CODE WITH THE CORRECT FORMATS AND DATA NAMES FROM YOUR QUERY
                System.out.printf("%25s %25s\n",
                        result1.getString("VendId"),
                        result1.getString("NumProds"));
            }



            String sqlStatement2 =
                    "SELECT CustId, COUNT(*) AS Orders FROM Orders GROUP BY CustId HAVING COUNT(*) >= 2";

            ResultSet result2 = stmt.executeQuery(sqlStatement2);
            System.out.println(" ");
            System.out.println("\nThe output from Page 114: ");

            while (result2.next())
            {
                System.out.printf("%25s %25s\n",
                        result2.getString("CustId"),
                        result2.getString("Orders"));
            }


            String sqlStatement3 =
                    "SELECT VendId, COUNT(*) AS NumProds FROM Products WHERE ProdPrice >= 10 GROUP BY VendId HAVING COUNT(*) >= 2";

            ResultSet result3 = stmt.executeQuery(sqlStatement3);
            System.out.println("\nThe output from Page 115: ");

            while (result3.next())
            {
                System.out.printf("%25s %25s\n",
                        result3.getString("VendId"),
                        result3.getString("NumProds"));
            }


            String sqlStatement4 =
                    "SELECT VendId, COUNT(*) AS NumProds FROM Products GROUP BY VendId HAVING COUNT(*) >= 2";

            ResultSet result4 = stmt.executeQuery(sqlStatement4);
            System.out.println("\nThe output from Page 116: ");

            while (result4.next())
            {
                System.out.printf("%25s %25s\n",
                        result4.getString("VendId"),
                        result4.getString("NumProds"));
            }

            String sqlStatement5 =
                    "SELECT OrderNum, SUM(Quantity * ItemPrice) AS OrderTotal FROM OrderItems GROUP BY OrderNum HAVING SUM(Quantity * ItemPrice) >= 50";

            ResultSet result5 = stmt.executeQuery(sqlStatement5);
            System.out.println("\nThe output from Page 117: ");

            while (result5.next())
            {
                System.out.printf("%25s %25s\n",
                        result5.getString("OrderNum"),
                        result5.getString("OrderTotal"));
            }




            String sqlStatement6 =
                    "SELECT OrderNum, SUM(Quantity * ItemPrice) AS OrderTotal FROM OrderItems GROUP BY OrderNum HAVING SUM (Quantity * ItemPrice) >=50 ORDER BY OrderTotal";

            ResultSet result6 = stmt.executeQuery(sqlStatement6);
            System.out.println("\nThe output from Page 118: ");

            while (result6.next())
            {
                System.out.printf("%25s %25s\n",
                        result6.getString("OrderNum"),
                        result6.getString("OrderTotal"));
            }


















// LEAVE THE REST OF THE CODE ALONE!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            conn.close();
        }
        catch(Exception ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}

