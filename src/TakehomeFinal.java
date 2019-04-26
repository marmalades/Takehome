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


            String sqlStatement7 =
                    "SELECT CustId FROM Orders WHERE OrderNum IN (SELECT OrderNum FROM OrderItems WHERE ProdId = 'TNT2')";

            ResultSet result7 = stmt.executeQuery(sqlStatement7);
            System.out.println("\nThe output from Page 123: ");

            while (result7.next())
            {
                System.out.printf("%25s\n",
                        result7.getString("CustId"));
            }


            String sqlStatement8 =
                    "SELECT CustName, CustContact FROM Customers WHERE CustId IN (SELECT CustId FROM Orders WHERE OrderNum IN (SELECT OrderNum FROM OrderItems WHERE ProdId = 'TNT2'))";

            ResultSet result8 = stmt.executeQuery(sqlStatement8);
            System.out.println("\nThe output from Page 124: ");

            while (result8.next())
            {
                System.out.printf("%25s %25s\n",
                        result8.getString("CustName"),
                        result8.getString("CustContact"));
            }


            String sqlStatement10 =
                    "SELECT CustName, CustState, (SELECT COUNT(*) FROM Orders WHERE CustId = CustId) AS Orders FROM Customers ORDER BY CustName";

            ResultSet result10 = stmt.executeQuery(sqlStatement10);
            System.out.println("\nThe output from Page 128: ");

            while (result10.next())
            {
                System.out.printf("%25s %25s %25s\n",
                        result10.getString("CustName"),
                        result10.getString("CustState"),
                        result10.getString("Orders"));
            }



            String sqlStatement11 =
                    "SELECT VendName, ProdName, ProdPrice FROM Vendors, Products WHERE Vendors.VendId = Products.VendId ORDER BY VendName, ProdName";

            ResultSet result11 = stmt.executeQuery(sqlStatement11);
            System.out.println("\nThe output from Page 134: ");

            while (result11.next())
            {
                System.out.printf("%25s %25s %25s\n",
                        result11.getString("VendName"),
                        result11.getString("ProdName"),
                        result11.getString("ProdPrice"));
            }



            String sqlStatement12 =
                    "SELECT VendName, ProdName, ProdPrice FROM Vendors INNER JOIN Products ON Vendors.VendID = Products.VendId";

            ResultSet result12 = stmt.executeQuery(sqlStatement12);
            System.out.println("\nPage 139: NO OUTPUT - INNER JOIN TABLES ONLY ");
            //*** No output since INNER JOIN ***


            String sqlStatement13 =
                    "SELECT ProdName, VendName, ProdPrice, Quantity FROM OrderItems, Products, Vendors WHERE Products.VendId = Vendors.VendId AND OrderItems.ProdId = Products.ProdId AND OrderNum = 20005";
            ResultSet result13 = stmt.executeQuery(sqlStatement13);
            System.out.println("\nThe output from Page 140: ");

            while (result13.next())
            {
                System.out.printf("%25s %25s %25s\n",
                        result13.getString("ProdName"),
                        result13.getString("VendName"),
                        result13.getString("ProdPrice"),
                        result13.getString("Quantity"));
            }



            String sqlStatement14 =
                    "SELECT CustName, CustContact FROM Customers, Orders, OrderItems WHERE Customers.CustId = Orders.CustId AND OrderItems.OrderNum = Orders.OrderNum AND ProdId = 'TNT2'";
            ResultSet result14 = stmt.executeQuery(sqlStatement14);
            System.out.println("\nThe output from Page 141: ");

            while (result14.next())
            {
                System.out.printf("%25s %25s\n",
                        result14.getString("CustName"),
                        result14.getString("CustContact"));
            }

            conn.close();
        }
        catch(Exception ex)
        {
            System.out.println("ERROR: " + ex.getMessage());
        }
    }
}

