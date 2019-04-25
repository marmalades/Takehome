// Needed for JDBC classes \\
import java.sql.*;
/**
 * This program creates the CoffeeDB database.
 */
public class FinalCreateDB
{
   public static void main(String[] args)
   {
      // Create a named constant for the URL.
      // NOTE: This value is specific for Java DB.
      final String DB_URL = "jdbc:derby:Final;create=true";
      
      try
      {
         // Create a connection to the database.
         Connection conn =
                DriverManager.getConnection(DB_URL);
					 
			// If the DB already exists, drop the tables.
			dropTables(conn);
			
			// Build all 6 tables
         
                
         buildVendorsTable(conn);

         buildProductsTable(conn); 
                  
			buildCustomersTable(conn);
         
         buildOrdersTable(conn);
                  		
		   buildOrderItemsTable(conn);         	
              
			buildProductNotesTable(conn);

          
         // Close the connection.
         conn.close();
      }
      catch (Exception ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
   }
	
	/**
	 * The dropTables method drops any existing
	 * in case the database already exists.
	 */
	public static void dropTables(Connection conn)
	{
		System.out.println("Checking for existing tables.");
		
		try
		{
			// Get a Statement object.
			Statement stmt  = conn.createStatement();;
         
			
        
         try
			{
	         stmt.execute("DROP TABLE ProductNotes");
				System.out.println("ProductNotes table dropped.");
			}
			catch(SQLException ex)
			{
				// No need to report an error.
				// The table simply did not exist.
			}
         
         try
			{
	         
	         stmt.execute("DROP TABLE OrderItems");
				System.out.println("OrderItems table dropped.");				
			}
			catch(SQLException ex)
			{
				// No need to report an error.
				// The table simply did not exist.
			}
         
         try
			{
	         stmt.execute("DROP TABLE Orders");
				System.out.println("Orders table dropped.");
			}
			catch(SQLException ex)
			{
				// No need to report an error.
				// The table simply did not exist.
			}

         try
			{
	         
	         stmt.execute("DROP TABLE Customers");
				System.out.println("Customers table dropped.");
			}
			catch(SQLException ex)
			{
				// No need to report an error.
				// The table simply did not exist.
			}
         
         try
			{
	         stmt.execute("DROP TABLE Products");
				System.out.println("Products table dropped.");
			}
			catch(SQLException ex)
			{
				// No need to report an error.
				// The table simply did not exist.
			}

			try
			{
	         stmt.execute("DROP TABLE Vendors");
				System.out.println("Vendors table dropped.");				
			}
			catch(SQLException ex)
			{
				// No need to report an error.
				// The table simply did not exist.
			}

			
		}
  		catch(SQLException ex)
		{
	      System.out.println("ERROR: " + ex.getMessage());
			ex.printStackTrace();
		}
	}
	
	  public static void buildVendorsTable(Connection conn)
	{
      try
      {
         // Get a Statement object.
         Statement stmt = conn.createStatement();
			
         // Create the table.
         stmt.execute("CREATE TABLE Vendors " +
				"( VendId  INT NOT NULL PRIMARY KEY, " +
				"  VendName CHAR(50) NOT NULL," +
				"  VendAddress CHAR(50)," +
				"  VendCity CHAR(50)," +
            "  VendState CHAR(5)," +
            "  VendZip CHAR(10)," +
				"  VendCountry CHAR(50) )");
			
       // Insert row #1.
			stmt.execute("INSERT INTO Vendors VALUES ( " +
                      "1001, " +
                      "'Anvils R Us', " +
                      "'123 Main Street', " +
                      "'Southfield', " +
                      "'MI', " +
                      "'48075', " +
                      "'USA'  )" );
	
			// Insert row #2.
			stmt.execute("INSERT INTO Vendors VALUES ( " +
                      "1002, " +
                      "'LT Supplies', " +
                      "'500 Park Street', " +
                      "'Anytown', " +
                      "'OH', " +
                      "'44333', " +
                      "'USA'  )" );

         
         // Insert row #3.
			stmt.execute("INSERT INTO Vendors VALUES ( " +
                      "1003, " +
                      "'ACME', " +
                      "'555 High Street', " +
                      "'Los Angeles', " +
                      "'CA', " +
                      "'90046', " +
                      "'USA'  )" );
         // Insert row #4.
			stmt.execute("INSERT INTO Vendors VALUES ( " +
                      "1004, " +
                      "'Furball Inc.', " +
                      "'1000 5th Avenue', " +
                      "'New York', " +
                      "'NY', " +
                      "'11111', " +
                      "'USA'  )" );
	
			// Insert row #5.
			stmt.execute("INSERT INTO Vendors VALUES ( " +
                      "1005, " +
                      "'Jet Set', " +
                      "'42 Galaxy Road', " +
                      "'London', " +
                      "'none', " +
                      "'N16 6PS', " +
                      "'England'  )" );

         
         // Insert row #6.
			stmt.execute("INSERT INTO Vendors VALUES ( " +
                      "1006, " +
                      "'Jouets Et Ours', " +
                      "'1 Rue Amusement', " +
                      "'Paris', " +
                      "'none', " +
                      "'45678', " +
                      "'France'  )" );
    
         
         
         
         
         System.out.println("Vendors table created.");
		}
		catch (SQLException ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
	}

     public static void buildProductsTable(Connection conn)
	{
      try
      {
         // Get a Statement object.
         Statement stmt = conn.createStatement();
			
         // Create the table.
			stmt.execute("CREATE TABLE Products " +
   				       "( ProdId CHAR(10) NOT NULL PRIMARY KEY, " +
                      "  VendId INT NOT NULL REFERENCES Vendors(VendId), " +
                      "  ProdName CHAR(25) NOT NULL, " +
                      "  ProdPrice DECIMAL(8,2) NOT NULL, " + 
                      "  ProdDesc CHAR(100) )"); 
				
        // Insert row #1.
			stmt.execute("INSERT INTO Products VALUES ( " +
                      "'ANV01', " +
                      "1001, " +
                      "'.5 ton anvil', " +
                      "5.99, " +
                      "'.5 ton anvil, black, complete with handy hook'  )" );
  
        // Insert row #2.
			stmt.execute("INSERT INTO Products VALUES ( " +
                      "'ANV02', " +
                      "1001, " +
                      "'1 ton anvil', " +
                      "9.99, " +
                      "'1 ton anvil, black, complete with handy hook and carrying case'  )" );
 
        // Insert row #3.
			stmt.execute("INSERT INTO Products VALUES ( " +
                      "'ANV03', " +
                      "1001, " +
                      "'2 ton anvil', " +
                      "14.99, " +
                      "'2 ton anvil, black, complete with handy hook and carrying case'  )" );
  
           // Insert row #4.
			stmt.execute("INSERT INTO Products VALUES ( " +
                      "'OL1', " +
                      "1002, " +
                      "'Oil can', " +
                      "8.99, " +
                      "'Oil can, red'  )" );
 
            // Insert row #5.
			stmt.execute("INSERT INTO Products VALUES ( " +
                      "'FU1', " +
                      "1002, " +
                      "'Fuses', " +
                      "3.42, " +
                      "'1 dozen, extra long'  )" );

            // Insert row #6.
			stmt.execute("INSERT INTO Products VALUES ( " +
                      "'SLING', " +
                      "1003, " +
                      "'Fuses', " +
                      "4.49, " +
                      "'Sling, one size fits all'  )" );

            // Insert row #7.
			stmt.execute("INSERT INTO Products VALUES ( " +
                      "'TNT1', " +
                      "1003, " +
                      "'TNT (1 stick)', " +
                      "2.50, " +
                      "'TNT, red, single stick'  )" );
           // Insert row #8.
			stmt.execute("INSERT INTO Products VALUES ( " +
                      "'TNT2', " +
                      "1003, " +
                      "'TNT (5 sticks)', " +
                      "10, " +
                      "'TNT, red, pack of 10 sticks'  )" );
           // Insert row #9.
			stmt.execute("INSERT INTO Products VALUES ( " +
                      "'FB', " +
                      "1003, " +
                      "'Bird seed', " +
                      "10, " +
                      "'Large bag (suitable for road runners'  )" );
          // Insert row #10.
			stmt.execute("INSERT INTO Products VALUES ( " +
                      "'FC', " +
                      "1003, " +
                      "'Carrots', " +
                      "2.50, " +
                      "'Carrots (rabbit hunting season only)ok'  )" );

        // Insert row #11.
			stmt.execute("INSERT INTO Products VALUES ( " +
                      "'SAFE', " +
                      "1003, " +
                      "'Safe', " +
                      "50, " +
                      "'Safe with combination lock'  )" );
                      
       // Insert row #12.
			stmt.execute("INSERT INTO Products VALUES ( " +
                      "'DTNTR', " +
                      "1003, " +
                      "'Detonator', " +
                      "13, " +
                      "'Detonator (plunger powered), fuses not included'  )" );
     
       // Insert row #13.
			stmt.execute("INSERT INTO Products VALUES ( " +
                      "'JP1000', " +
                      "1005, " +
                      "'JetPack 1000', " +
                      "35, " +
                      "'JetPack 1000, intended for single use'  )" );
       
       // Insert row #14.
			stmt.execute("INSERT INTO Products VALUES ( " +
                      "'JP2000', " +
                      "1005, " +
                      "'JetPack 2000', " +
                      "55, " +
                      "'JetPack 2000, multi-use'  )" );

            
			System.out.println("Products table created.");
		}
		catch (SQLException ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
	}

     
     public static void buildCustomersTable(Connection conn)
	{
		try
		{
         // Get a Statement object.
         Statement stmt = conn.createStatement();
         
			// Create the table.
			stmt.execute("CREATE TABLE Customers (" +
   				       "CustId INT NOT NULL PRIMARY KEY, " +
                      "CustName CHAR(50) NOT NULL, " +
                      "CustAddress CHAR(50), " +
                      "CustCity CHAR(50), " +
                      "CustState CHAR(5), " +
                      "CustZip CHAR(10), " +
                      "CustCountry CHAR(50), " +
                      "CustContact CHAR(50), " +                           
                      "CustEmail CHAR(100) )");
                      
 							 
		// Insert row #1.
			stmt.execute("INSERT INTO Customers VALUES ( " +
                      "10001, " +
                      "'Coyote Inc.', " +
                      "'200 Maple Lane', " + 
                      "'Detroit', " +
                      "'MI', " +
                      "'44444', " +
                      "'USA', " +
                      "'Y Lee', " +
                      "'ylee@coyote.com' )" );
			
		// Insert row #2.
			stmt.execute("INSERT INTO Customers VALUES ( " +
                      "10002, " +
                      "'Mouse House', " +
                      "'333 Fromage Lane', " + 
                      "'Columbus', " +
                      "'OH', " +
                      "'43333', " +
                      "'USA', " +
                      "'JerryMouse', " +
                      "'null' )" );


			
      // Insert row #3.
			stmt.execute("INSERT INTO Customers VALUES ( " +
                      "10003, " +
                      "'Wascals', " +
                      "'333 Fromage Lane', " + 
                      "'Muncie', " +
                      "'IN', " +
                      "'42222', " +
                      "'USA', " +
                      "'Jim Jones', " +
                      "'rabbit@wascally.com' )" );
			
      // Insert row #4.
			stmt.execute("INSERT INTO Customers VALUES ( " +
                      "10004, " +
                      "'Yosemite Place', " +
                      "'829 Riverside Drive', " + 
                      "'Phoenix', " +
                      "'AZ', " +
                      "'88888', " +
                      "'USA', " +
                      "'Y Sam', " +
                      "'sam@yosemite.com' )" );
	 
    // Insert row #5.
			stmt.execute("INSERT INTO Customers VALUES ( " +
                      "10005, " +
                      "'E Fudd', " +
                      "'4545 53rd Street', " + 
                      "'Chicago', " +
                      "'IL', " +
                      "'54545', " +
                      "'USA', " +
                      "'E Fudd', " +
                      "'null' )" );



			System.out.println("Customers table created.");
		}
		catch (SQLException ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
	}

           
      public static void buildOrdersTable(Connection conn)
	{
      try
      {
         // Get a Statement object.
         Statement stmt = conn.createStatement();
			
         // Create the table.
         stmt.execute("CREATE TABLE Orders " +
				"( OrderNum INT NOT NULL PRIMARY KEY, "+
				"  OrderDate DATE NOT NULL,"+
				"  CustId INT NOT NULL REFERENCES Customers(CustId) )");
					
		// Insert row #1.
			stmt.execute("INSERT INTO Orders VALUES ( " +
                      "20005, " +
                      "'2005-09-01', " +
                      "10001  )" );
	    // Insert row #2.
			stmt.execute("INSERT INTO Orders VALUES ( " +
                      "20006, " +
                      "'2005-09-12', " +
                      "10003  )" );
       // Insert row #3.
			stmt.execute("INSERT INTO Orders VALUES ( " +
                      "20007, " +
                      "'2005-09-30', " +
                      "10004  )" );
       // Insert row #4.
			stmt.execute("INSERT INTO Orders VALUES ( " +
                      "20008, " +
                      "'2005-10-03', " +
                      "10005  )" );

        // Insert row #5.
			stmt.execute("INSERT INTO Orders VALUES ( " +
                      "20009, " +
                      "'2005-10-08', " +
                      "10001  )" );


      
      	System.out.println("Orders table created.");
		}
		catch (SQLException ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
	}

     
    public static void buildOrderItemsTable(Connection conn)
	{
      try
      {
         // Get a Statement object.
         Statement stmt = conn.createStatement();
         
         // Create the table.
         stmt.execute("CREATE TABLE OrderItems" +
            "( OrderNum INT NOT NULL REFERENCES Orders(OrderNum), " +
            "  OrderItem INT NOT NULL, " +
            "  ProdId CHAR(10) NOT NULL REFERENCES Products(ProdId) , " +
            "  Quantity INT NOT NULL, "    +
            "  ItemPrice DECIMAL(8,2) NOT NULL, "  +
            "  PRIMARY KEY (OrderNum,OrderItem) )");

      
            
        // Add some rows to the new table.
        // Insert row #1.
			stmt.execute("INSERT INTO OrderItems VALUES ( " +
                      "20005, " +
                      "1, " +
                      "'ANV01', " +
                      "10, " +
                      "5.99 )" );

        // Insert row #2.
			stmt.execute("INSERT INTO OrderItems VALUES ( " +
                      "20005, " +
                      "2, " +
                      "'ANV02', " +
                      "3, " +
                      "9.99 )" );

        // Insert row #3.
			stmt.execute("INSERT INTO OrderItems VALUES ( " +
                      "20005, " +
                      "3, " +
                      "'TNT2', " +
                      "5, " +
                      "10 )" );

            // Insert row #4.
			stmt.execute("INSERT INTO OrderItems VALUES ( " +
                      "20005, " +
                      "4, " +
                      "'FB', " +
                      "1, " +
                      "10 )" );

             // Insert row #5.
			stmt.execute("INSERT INTO OrderItems VALUES ( " +
                      "20006, " +
                      "1, " +
                      "'JP2000', " +
                      "1, " +
                      "55 )" );

         // Insert row #6.
			stmt.execute("INSERT INTO OrderItems VALUES ( " +
                      "20007, " +
                      "1, " +
                      "'TNT2', " +
                      "100, " +
                      "10 )" );
                      
        // Insert row #7.
			stmt.execute("INSERT INTO OrderItems VALUES ( " +
                      "20008, " +
                      "1, " +
                      "'FC', " +
                      "50, " +
                      "2.50 )" );
    
        // Insert row #8.
			stmt.execute("INSERT INTO OrderItems VALUES ( " +
                      "20009, " +
                      "1, " +
                      "'FB', " +
                      "1, " +
                      "10 )" );
                      
       // Insert row #9.
			stmt.execute("INSERT INTO OrderItems VALUES ( " +
                      "20009, " +
                      "2, " +
                      "'OL1', " +
                      "1, " +
                      "8.99 )" );
            
         
        // Insert row #10.
			stmt.execute("INSERT INTO OrderItems VALUES ( " +
                      "20009, " +
                      "3, " +
                      "'SLING', " +
                      "1, " +
                      "4.99 )" );

             
       // Insert row #11.
			stmt.execute("INSERT INTO OrderItems VALUES ( " +
                      "20009, " +
                      "4, " +
                      "'ANV03', " +
                      "1, " +
                      "14.99 )" );

             
                        
                      
  

         					
			System.out.println("OrderItems table created.");
		}
		catch (SQLException ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
	}

	
     
   public static void buildProductNotesTable(Connection conn)
	{
      try
      {
         // Get a Statement object.
         Statement stmt = conn.createStatement();
			
         // Create the table.
         stmt.execute("CREATE TABLE ProductNotes " +
				"( NoteId INT NOT NULL PRIMARY KEY, " +
				"  ProdId CHAR(10) NOT NULL REFERENCES Products(ProdId)," +
				"  NoteDate DATE NOT NULL," +
				"  NoteText CHAR(200) )");
			
       // Insert row #1.
			stmt.execute("INSERT INTO ProductNotes VALUES ( " +
                      "101, " +
                      "'TNT2', " +
                      "'2005-08-17', " +
                      "'Customer complaint: Sticks not individually wrapped, too easy to mistakenly detonate all at once. Recommend individual wrapping.'  )" );

         // Insert row #2.
			stmt.execute("INSERT INTO ProductNotes VALUES ( " +
                      "102, " +
                      "'OL1', " +
                      "'2005-08-18', " +
                      "'Can shipped full, refills not available. Need to order new can if refill needed.'  )" );
       // Insert row #3.
			stmt.execute("INSERT INTO ProductNotes VALUES ( " +
                      "103, " +
                      "'SAFE', " +
                      "'2005-08-18', " +
                      "'Safe is combination locked, combination not provided with safe. This is rarely a problem as safes are typically blown up or dropped by customers.'  )" );

         // Insert row #4.
			stmt.execute("INSERT INTO ProductNotes VALUES ( " +
                      "104, " +
                      "'FC', " +
                      "'2005-08-19', " +
                      "'Quantity varies, sold by the sack load. All guaranteed to be bright and orange, and suitable for use as rabbit bait.'  )" );

         // Insert row #5.
			stmt.execute("INSERT INTO ProductNotes VALUES ( " +
                      "105, " +
                      "'TNT2', " +
                      "'2005-08-20', " +
                      "'Included fuses are short and have been known to detonate too quickly for some customers. Longer fuses are available (item FU1) and should be recommended'  )" );

         // Insert row #6.
			stmt.execute("INSERT INTO ProductNotes VALUES ( " +
                      "106, " +
                      "'TNT2', " +
                      "'2005-08-22', " +
                      "'Matches not included, recommend purchase of matches or detonator (item DTNTR).'  )" );

       // Insert row #7
         
			stmt.execute("INSERT INTO ProductNotes VALUES ( " +
                      "107, " +
                      "'SAFE', " +
                      "'2005-08-23', " +
                      "'Please note that no returns will be accepted if safe opened using explosives.ng.'  )" );
     // Insert row #8.
			stmt.execute("INSERT INTO ProductNotes VALUES ( " +
                      "108, " +
                      "'ANV01', " +
                      "'2005-08-25', " +
                      "'Multiple customer returns, anvils failing to drop fast enough or falling backwards on purchaser. Recommend that customer considers using heavier anvils.'  )" );
      // Insert row #9.
			stmt.execute("INSERT INTO ProductNotes VALUES ( " +
                      "109, " +
                      "'ANV03', " +
                      "'2005-09-01', " +
                      "'Item is extremely heavy. Designed for dropping, not recommended for use with slings, ropes, pulleys, or tightropes.'  )" );
      // Insert row #10.
			stmt.execute("INSERT INTO ProductNotes VALUES ( " +
                      "110, " +
                      "'FC', " +
                      "'2005-09-01', " +
                      "'Customer complaint: rabbit has been able to detect trap, food apparently less effective now.'  )" );

       // Insert row #11.
			stmt.execute("INSERT INTO ProductNotes VALUES ( " +
                      "111, " +
                      "'SLING', " +
                      "'2005-09-02', " +
                      "'Shipped unassembled, requires common tools (including oversized hammer).'  )" );
      // Insert row #12.
			stmt.execute("INSERT INTO ProductNotes VALUES ( " +
                      "112, " +
                      "'SAFE', " +
                      "'2005-09-02', " +
                      "'Customer complaint: Circular hole in safe floor can apparently be easily cut with handsaw.'  )" );
      // Insert row #13.
			stmt.execute("INSERT INTO ProductNotes VALUES ( " +
                      "113, " +
                      "'ANV01', " +
                      "'2005-09-05', " +
                      "'Customer complaint: Not heavy enough to generate flying stars around head of victim. If being purchased for dropping, recommend ANV02 or ANV03 instead.'  )" );
      // Insert row #14.
			stmt.execute("INSERT INTO ProductNotes VALUES ( " +
                      "114, " +
                      "'SAFE', " +
                      "'2005-09-07', " +
                      "'Call from individual trapped in safe plummeting to the ground, suggests an escape hatch be added.Comment forwarded to vendor.'  )" );

         	
			System.out.println("ProductNotes table created.");
		}
		catch (SQLException ex)
      {
         System.out.println("ERROR: " + ex.getMessage());
      }
	} 
 
   
	
	 
   
}

