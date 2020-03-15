


//import java.util.*;
import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.sql.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BoutiqueCoffee
{
	private static Connection connection; //used to hold the jdbc connection to the DB
    private Statement statement; //used to create an instance of the connection
    private PreparedStatement prepStatement; //used to create a prepared statement, that will be later reused
    private ResultSet resultSet; //used to hold the result of your query (if one
    // exists)
    private String query;  //this will hold the query we are using
    public BoutiqueCoffee(Connection connectionout)
    {
    		connection = connectionout;
    }
    public void test()
    {
    		System.out.println("test");
    }
    public int addStore(String name, String address, String storeType, 
    		long gpsLong, long gpsLast)
    {
    		int store_id = 0;
    		int counter = 1;
    		try
    		{
    			statement = connection.createStatement();
    			String selectQuery = "select store_seq.nextval from dual";
    		    resultSet = statement.executeQuery(selectQuery);
    		    if (resultSet.next())
    		    {
    		    		store_id = resultSet.getInt(1);
    		    }
    		    resultSet.close();
    		    
    		    query = "insert into Store values (?,?,?,?,?,?)";
    		    prepStatement = connection.prepareStatement(query);
    		    prepStatement.setInt(1, store_id);
    		    prepStatement.setString(2, name);
    		    prepStatement.setString(3, address);
    		    prepStatement.setString(4, storeType);
    		    prepStatement.setLong(5, gpsLong);
    		    prepStatement.setLong(6,gpsLast);
    		    prepStatement.executeUpdate();
    		
    		}
    		catch(SQLException Ex) 
    		{
    			System.out.println("Error running the sample queries.  Machine Error: " +
			       Ex.toString());
    			return -1;
    		} 
    		/*
    		catch (ParseException e) 
    		{
    			System.out.println("Error parsing the date. Machine Error: " +
    					e.toString());
    			//return -1;
    		}*/
    		finally
    		{
    			try 
    			{
    				if (statement != null) statement.close();
    				if (	prepStatement != null) prepStatement.close();
    			} catch (SQLException e)
    			{
			System.out.println("Cannot close Statement. Machine error: "+e.toString());
    			}
    		}
    		return store_id;
    }
    
    
    
    public int hasPromotion(int storeID, int promotionID)
    {
    		
    		int counter = 1;
    		try
    		{
    			query = "insert into hasPromotion values (?,?)";
    		    prepStatement = connection.prepareStatement(query);
    		    prepStatement.setInt(1, storeID);
    		    prepStatement.setInt(2, promotionID);
    		    prepStatement.executeUpdate();
    		}
	    	catch(SQLException Ex) 
    		{
    			System.out.println("Error running the sample queries.  Machine Error: " +
			       Ex.toString());
    			return -1;
    		} 
    		/*
    		catch (ParseException e) 
    		{
    			System.out.println("Error parsing the date. Machine Error: " +
    					e.toString());
    			return -1;
    		}*/
    		finally
    		{
    			try 
    			{
    				if (statement != null) statement.close();
    				if (	prepStatement != null) prepStatement.close();
    			} catch (SQLException e)
    			{
			System.out.println("Cannot close Statement. Machine error: "+e.toString());
    			}
    		}
    		return 1;
    }
    public int promoteFor(int promotionID, int coffeeID)
    {
    		
    		int counter = 1;
    		try
    		{
    			query = "insert into promoteFor values (?,?)";
    		    prepStatement = connection.prepareStatement(query);
    		    prepStatement.setInt(1, promotionID);
    		    prepStatement.setInt(2, coffeeID);
    		    prepStatement.executeUpdate();

    		}
	    	catch(SQLException Ex) 
    		{
    			System.out.println("Error running the sample queries.  Machine Error: " +
			       Ex.toString());
    			return -1;
    		} 
    		/*
    		catch (ParseException e) 
    		{
    			System.out.println("Error parsing the date. Machine Error: " +
    					e.toString());
    			return -1;
    		}*/
    		finally
    		{
    			try 
    			{
    				if (statement != null) statement.close();
    				if (	prepStatement != null) prepStatement.close();
    			} catch (SQLException e)
    			{
			System.out.println("Cannot close Statement. Machine error: "+e.toString());
    			}
    		}
    		return 1;
    }
    
    public List<Integer> getCoffees()
    {
    		List<Integer> listResult = new ArrayList<Integer>	();
    		
    		try{
    			statement = connection.createStatement();
    			String selectQuery = "Select coffee_id from coffee";
    			resultSet = statement.executeQuery(selectQuery);
    			while(resultSet.next())
    			{
    				listResult.add(resultSet.getInt(1));
    			}
    			resultSet.close();	
    		}catch(SQLException Ex) 
    		{
    			System.out.println("Error running the sample queries.  Machine Error: " +
			       Ex.toString());
    			return null;
    		} 
    		/*
    		catch (ParseException e) 
    		{
    			System.out.println("Error parsing the date. Machine Error: " +
    					e.toString());
    		}*/
    		finally
    		{
    			try 
    			{
    				if (statement != null) statement.close();
    				if (	prepStatement != null) prepStatement.close();
    			} catch (SQLException e)
    			{
			System.out.println("Cannot close Statement. Machine error: "+e.toString());
    			}
    		}
    		System.out.println(listResult);
    		return listResult;	
    }
    
    public List<Integer> getCoffeesByKeywords(String keyword1, String keyword2)
    {
                List<Integer> listResult = new ArrayList<Integer>       ();
                
                try{
                        String selectQuery = "Select coffee_id from coffee "+
                        "where name like ? and name like ?";

                        prepStatement = connection.prepareStatement(selectQuery);
            prepStatement.setString(1,"%"+ keyword1+"%");
            prepStatement.setString(2, "%"+keyword2+"%");
                        resultSet = prepStatement.executeQuery();
	
			while(resultSet.next())
			{
				listResult.add(resultSet.getInt(1));
			}
			resultSet.close();	
		}catch(SQLException Ex) 
		{
			System.out.println("Error running the sample queries.  Machine Error: " +
		       Ex.toString());
			return null;
		} 
		/*
		catch (ParseException e) 
		{
			System.out.println("Error parsing the date. Machine Error: " +
					e.toString());
		}*/
		finally
		{
			try 
			{
				if (statement != null) statement.close();
				if (	prepStatement != null) prepStatement.close();
			} catch (SQLException e)
			{
				System.out.println("Cannot close Statement. Machine error: "+e.toString());
			}
		}
		System.out.println(listResult);
		return listResult;
    }
    
	
    public double getPointsByCustomerId(int customerId)
    {
                float point = -1;
        
        try{
                String selectQuery = "Select total_points from customer "+
                "where customer_id = ?";

                prepStatement = connection.prepareStatement(selectQuery);
                
                prepStatement.setInt(1, customerId);
        
                resultSet = prepStatement.executeQuery();

		while(resultSet.next())
		{
			point = resultSet.getFloat(1);
		}
		resultSet.close();	
	}catch(SQLException Ex) 
	{
		System.out.println("Error running the sample queries.  Machine Error: " +
	       Ex.toString());
		return -1;
	} 
	/*
	catch (ParseException e) 
	{
		System.out.println("Error parsing the date. Machine Error: " +
				e.toString());
		return -1;
	}*/
	finally
	{
		try 
		{
			if (statement != null) statement.close();
			if (	prepStatement != null) prepStatement.close();
		} catch (SQLException e)
		{
			System.out.println("Cannot close Statement. Machine error: "+e.toString());
		}
	}
	System.out.println(point);
	return point;
}
    public int addPurchase(int customerId, int storeId, Date purchaseTime, List<Integer> coffeeIds,
    		List<Integer> purchaseQuantities, List<Integer> redeemQuantities)
    {
    		int purchase_id = 0;
    		int counter = 1;
    		int coffee_id,purchase_Q,redeem_Q;
    		
    		try
    		{
    			statement = connection.createStatement();
    			String selectQuery = "select purchase_seq.nextval from dual";
    		    resultSet = statement.executeQuery(selectQuery);
    		    if (resultSet.next())
    		    {
    		    		purchase_id = resultSet.getInt(1);
    		    }
    		    resultSet.close();
    		    
    		    java.sql.Date date_reg = new java.sql.Date (purchaseTime.getTime());

    		    query = "insert into Purchase values (?,?,?,?)";
    		    prepStatement = connection.prepareStatement(query);
    		    prepStatement.setInt(1, purchase_id);
    		    prepStatement.setInt(2, customerId);
    		    prepStatement.setInt(3, storeId);
    		    prepStatement.setDate(4, date_reg);		  
    		    prepStatement.executeUpdate();
    		    
    		    for(int i=0;i<coffeeIds.size();i++)
    		    {
	    		    coffee_id = coffeeIds.get(i);
	    		    purchase_Q = purchaseQuantities.get(i);
	    		    redeem_Q = redeemQuantities.get(i);
    		    		query = "insert into buycoffee values(?,?,?,?)";
	    		    prepStatement = connection.prepareStatement(query);
	    		    prepStatement.setInt(1, purchase_id);
	    		    prepStatement.setInt(2, coffee_id);
	    		    prepStatement.setInt(3, purchase_Q);
	    		    prepStatement.setInt(4, redeem_Q);
	    		    prepStatement.executeUpdate();
	    		    
    		    }
    		
    		}catch(SQLException Ex) 
    		{
    			System.out.println("Error running the sample queries.  Machine Error: " +
			       Ex.toString());
    			return -1;
    		}
    		
    		finally
    		{
    			try 
    			{
    				if (statement != null) statement.close();
    				if (	prepStatement != null) prepStatement.close();
    			} catch (SQLException e)
    			{
			System.out.println("Cannot close Statement. Machine error: "+e.toString());
    			}
    		}
    		return purchase_id;
    }
    public int addMemberLevel(String name, double boosterFactor)
	{
	int memberID = 0;
		try
		{
		connection.setAutoCommit(false);	    
		statement = connection.createStatement();
		query = "select memberlevel_seq.nextval from dual";
		ResultSet rs = statement.executeQuery(query);
		
		if(rs != null && rs.next())
		{
		memberID = rs.getInt(1);

		}
		  rs.close();
		query = "insert into memberlevel values(?,?,?) ";
		prepStatement = connection.prepareStatement(query);
		prepStatement.setInt(1,memberID);
		prepStatement.setString(2,name);
		prepStatement.setDouble(3, boosterFactor);
		prepStatement.executeUpdate();
		
		}
		catch(SQLException Ex) {
			    System.out.println("Error running the sample queries.  Machine Error: " + Ex.toString());
			    return -1;
			    }
				finally{
						try {
							if (statement != null) statement.close();
							if (prepStatement != null) prepStatement.close();
						} catch (SQLException e) {
							System.out.println("Cannot close Statement. Machine error: "+e.toString());
						}
					}
		return memberID;
					
	}
    public int addCustomer(String firstName, String lastName, String email, int memberLevelId, double totalPoint)
	{
		
		int customerID = 0;
		try
		{
		connection.setAutoCommit(false);	    
		statement = connection.createStatement();
		query = "select customer_seq.nextval from dual";
		ResultSet rs = statement.executeQuery(query);
		
		if(rs != null && rs.next())
		{
		customerID = rs.getInt(1);
		 
		}
		
		 rs.close();
		
		query = "insert into Customer values(?,?,?,?,?,?) ";
		prepStatement = connection.prepareStatement(query);
		prepStatement.setInt(1,customerID);
		prepStatement.setString(2, firstName);
		prepStatement.setString(3, lastName);
		prepStatement.setString(4, email);
		prepStatement.setInt(5, memberLevelId);
		prepStatement.setDouble(6, totalPoint);
		
		
		prepStatement.executeUpdate();
		
		}
		catch(SQLException Ex) {
			    System.out.println("Error running the sample queries.  Machine Error: " + Ex.toString());
			    return -1;}
				finally{
						try {
							if (statement != null) statement.close();
							if (prepStatement != null) prepStatement.close();
						} catch (SQLException e) {
							System.out.println("Cannot close Statement. Machine error: "+e.toString());
						}
				
		
				}
	    			return customerID;
	}
    public int addPromotion (String name, Date startDate, Date endDate)
    {
    int 	promotion_id =0;
    	try{
    		query = "insert into Promotion values(?, ?, ?, ?)";
    		prepStatement = connection.prepareStatement(query);
    		
    		statement = connection.createStatement();
    		
    		String selectQuery = "select promotion_seq.nextval from dual";
    		resultSet = statement.executeQuery(selectQuery);
    		if (resultSet.next())
            	{
            		promotion_id = resultSet.getInt(1);
            	}
            	resultSet.close();
            	
            	java.sql.Date start_reg = new java.sql.Date (startDate.getTime());
            	java.sql.Date end_reg = new java.sql.Date (startDate.getTime());
            	prepStatement.setInt(1, promotion_id);
            	prepStatement.setString(2, name);
            	prepStatement.setDate(3, start_reg);
            	prepStatement.setDate(4, end_reg);
            
            	prepStatement.executeUpdate();
            }
            
            catch(SQLException Ex) {
    	    System.out.println("Error running the sample queries.  Machine Error: " +
    			       Ex.toString());
    	    return -1;
    	} 
    	finally{
    		try {
    			if (statement != null) statement.close();
    			if (prepStatement != null) prepStatement.close();
    		} catch (SQLException e) {
    			System.out.println("Cannot close Statement. Machine error: "+e.toString());
    		}
    	}
    	return promotion_id;
    }
    
    public int addCoffee (String name, String description, int intensity, 
			double price, double rewardPoints, double redeemPoints)
	{
		int coffee_id=0;
		try
		{
			query = "insert into Coffee values (?,?,?,?,?,?,?)";
			prepStatement = connection.prepareStatement(query);
			
			statement = connection.createStatement(); //create an instance
			  
			String selectQuery = "select coffee_seq.nextval from dual";
			resultSet = statement.executeQuery(selectQuery);
			if (resultSet.next())
			{
				coffee_id = resultSet.getInt(1);
			}
			resultSet.close();
			
			prepStatement.setInt(1, coffee_id);
			prepStatement.setString(2, name);
			prepStatement.setString(3, description);
			prepStatement.setInt(4, intensity);
			prepStatement.setDouble(5, price);
			prepStatement.setDouble(6, rewardPoints);
			prepStatement.setDouble(7, redeemPoints);
			
			prepStatement.executeUpdate();
		
		}	
		
		catch(SQLException Ex) {
		System.out.println("Error running the sample queries.  Machine Error: " +
			       Ex.toString());
		return -1;
		} 
		finally{
		try {
			if (statement != null) statement.close();
			if (prepStatement != null) prepStatement.close();
		} catch (SQLException e) {
			System.out.println("Cannot close Statement. Machine error: "+e.toString());
		}
	}
	return coffee_id;
}
    public int offerCoffee (int storeId, int coffeeId)
    {
	    	int counter = 1;
	    	
	    	try{
	    		query = "insert into OfferCoffee values(?, ?)";
	    		prepStatement = connection.prepareStatement(query);
	    		
	    		statement = connection.createStatement(); //create an instance
	    		
	    		prepStatement.setInt(1, storeId);
	            prepStatement.setInt(2, coffeeId);
	            
	            prepStatement.executeUpdate();
	        }
	        
	        catch(SQLException Ex) {
	    	    System.out.println("Error running the sample queries.  Machine Error: " +
	    			       Ex.toString());
	    	    return -1;
	    	}
	    	finally{
	    		try {
	    			if (statement != null) statement.close();
	    			if (prepStatement != null) prepStatement.close();
	    		} catch (SQLException e) {
	    			System.out.println("Cannot close Statement. Machine error: "+e.toString());
	    		}
	    	}
	    	return 1;
    	
    }
   
    public List<Integer> getTopKCustomersInPastXMonth(int k, int x){
    	 long y = (long)x*30;
    	 Date curDate = new Date();
    	 Date date = new Date((long)curDate.getTime()-(long)(y*24*3600*1000));
    	 java.sql.Date beginDate = new java.sql.Date(date.getTime());
    	 
    	 ArrayList<Integer> result = new ArrayList<Integer>();
    	 
    	 try{
    	  statement = connection.createStatement();
    	  query = "select distinct CustomerID, expense "+
    	    "from (select C.Customer_ID CustomerID, E.expense expense "+
    	    "from ((select Customer_ID, sum(coffee.price*buycoffee.purchase_Quantity) as expense "+
    	    "from purchase join buycoffee on purchase.Purchase_ID = BuyCoffee.Purchase_ID "+
    	    "join coffee on BuyCoffee.Coffee_ID = Coffee.Coffee_ID "+
    	    "where purchase.Purchase_time >= to_date('"+beginDate+"','YYYY-MM-DD') "+
    	    "group by Customer_ID) C "+
    	    "inner join "+
    	    "(select* from(select sum(Coffee.Price * buyCoffee.Purchase_Quantity) as expense "+
    	    "from purchase join buycoffee on purchase.Purchase_ID = buycoffee.Purchase_ID "+
    	    "join coffee on buycoffee.Coffee_ID = coffee.Coffee_ID "+
    	    "where purchase.purchase_time >= to_date('"+beginDate+"','YYYY-MM-DD') "+
    	    "group by customer_ID "+
    	    "order by expense desc)) E "+
    	    "on e.expense = c.expense)) "+
    	    "order by expense desc";
    	    
    	  resultSet = statement.executeQuery(query);
    	 
    	   
    	  int i = 0;
    	  int temp = 0;
    	  while (i<k&&resultSet.next()){
    	   result.add(resultSet.getInt("CustomerID"));
    	   temp = resultSet.getInt("expense");
    	
    	   i++;
    	  }
    	  while(resultSet.next()){
    	   if(temp == resultSet.getInt("expense"))
    	    result.add(resultSet.getInt("CustomerID"));
    	   else
    	    break;
    	  }
    	  resultSet.close();	
    	 }catch(Exception Ex){
    	  System.out.println("Error getting top customers. Machine Error: " +Ex.toString());
    	 }finally{
    	  try{
    	   if(statement != null)statement.close();
    	  }catch(SQLException e){
    	   System.out.println("Cannot close Statement. Machine error: " + e.toString());
    	  }
    	 }
    	 
    	 return result;
    	}
    public List<Integer>getTopKStoresInPastXmonth(int k, int x)
    {
     long y= x*30;
        Date curdate = new Date();
        Date date =new Date ((long)curdate.getTime() - (long)(y*24*3600*1000));
        java.sql.Date beginDate = new java.sql.Date(date.getTime());
        ArrayList<Integer> result = new ArrayList<Integer>();
     try{
      statement = connection.createStatement();
      query = "select distinct storeID, revenue from "
        + "(select a.store_ID storeID, b.revenue revenue from "
        + "((select store_ID, sum(coffee.price*buycoffee.purchase_Quantity) as revenue "
        + "from purchase join buycoffee on purchase.purchase_ID = BuyCoffee.purchase_ID "
        + "join coffee on BuyCoffee.Coffee_ID = Coffee.Coffee_ID "
        + "where purchase.purchase_time >= to_date('"+beginDate+"','YYYY-MM-DD') "
        + "group by store_ID) a "
        + "inner join "
        + "(select* from(select sum(Coffee.price * buyCoffee.Purchase_Quantity) as revenue "
        + "from purchase join buycoffee on purchase.purchase_ID = buycoffee.purchase_ID "
        + "join coffee on BuyCoffee.coffee_ID = Coffee.Coffee_ID "
        + "where purchase.purchase_time >= to_date('"+beginDate+"','YYYY-MM-DD') "
        + "group by store_ID "
        + "order by revenue desc) "
        + "where rownum <="+ k +") b "
        + "on a.revenue = b.revenue)) "
        + "order by revenue desc";
      
      resultSet =statement.executeQuery(query);
      int i = 0;
            int temp = 0;

         while (i<k&&resultSet.next()){
              result.add(resultSet.getInt("storeID"));
              temp = resultSet.getInt("revenue");
              i++;
             }
             while(resultSet.next()){
              if(temp == resultSet.getInt("revenue"))
               result.add(resultSet.getInt("storeID"));
              else
               break;
             }
             resultSet.close();	

     }catch(SQLException Ex) 
     {
      System.out.println("Error running the sample queries.  Machine Error: " +
            Ex.toString());
      return null;
     } 
     /*
     catch (ParseException e) 
     {
      System.out.println("Error parsing the date. Machine Error: " +
        e.toString());
     }*/
     finally
     {
      try 
      {
       if (statement != null) statement.close();
       if ( prepStatement != null) prepStatement.close();
      } catch (SQLException e)
      {
       System.out.println("Cannot close Statement. Machine error: "+e.toString());
      }
     }
           return result;

    }
    
    
   
    public static void main(String args[]) throws SQLException
    {
	    	String username, password;
	    	username = "chs201"; //This is your username in oracle
	    	password = "4063021"; //This is your password in oracle
	    	
	    	try{
	    	    // Register the oracle driver.  
	    	    DriverManager.registerDriver (new oracle.jdbc.driver.OracleDriver());
	    	    
	    	    //This is the location of the database.  This is the database in oracle
	    	    //provided to the class
	    	    String url = "jdbc:oracle:thin:@class3.cs.pitt.edu:1521:dbclass"; 
	    	    
	    	    //create a connection to DB on class3.cs.pitt.edu
	    	    connection = DriverManager.getConnection(url, username, password); 
	    	    BoutiqueCoffee demo = new BoutiqueCoffee(connection);
	    	    System.out.println(demo.getTopKCustomersInPastXMonth(2,100));
	    	}
	    	catch(Exception Ex)  {
	    	    System.out.println("Error connecting to database.  Machine Error: " +
	    			       Ex.toString());
	    	}
	    	finally
	    	{
	    		/*
	    		 * NOTE: the connection should be created once and used through out the whole project;
	    		 * Is very expensive to open a connection therefore you should not close it after every operation on database
	    		 */
	    		connection.close();
	    	}
    }
}
