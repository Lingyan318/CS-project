
//import java.util.*;
//Since this program is testing corner cases, most of its queries would possibly return -1.
import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.sql.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BCDriver 
{
	private static Connection connection; //used to hold the jdbc connection to the DB
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
	    	    BoutiqueCoffee BC = new BoutiqueCoffee(connection);
	    	    Scanner reader = new Scanner(System.in);
	    	   
	    	    
	    	    while(true)
	    	    {
		    	    System.out.println("Which method do you want to test?");
		    	    System.out.println("Selections:\n1: addstore\n2: hasPromotion\n3: promoteFor\n4: getCoffees"+
		    	    "\n5: getCoffeesByKeywords\n6: getPointsBuycustomerId\n7: addPurchase\n8: addMeberLevel\n"+
		    	    	"9: addCustomer\n10: addPromotion\n11: addCoffee\n12: offerCoffee\n13: getTopKCustomersInpastXmonth\n14: getTopKStoresInpastXmonth");
		    	    int select = -1;
			    System.out.print("Your selection: ");
		    	    select = reader.nextInt();
			    System.out.println("The return result: ");
		    	    int tt=0;//output the result
		    	   
			    	    switch (select)
			    		{
			    			case 1:
			    				tt=BC.addStore("StoreTest","StateTest","test",100,200);
			    				System.out.println(tt);
			    				break;
			    			case 2:
			    				tt = BC.hasPromotion(1,4);//if the promotion has at least one coffee that the store doesn't offer
			    										//the insertion would fail.
			    				System.out.println(tt);
			    				break;
			    			case 3:
			    				
			    				tt = BC.promoteFor(1,1);
			    				System.out.println(tt);
			    				break;
			    			case 4:
			    				BC.getCoffees();
			    				break;
			    			case 5:
			    				BC.getCoffeesByKeywords("z","abc");
			    				break;
			    			case 6:
			    				BC.getPointsByCustomerId(21);
			    				break;
			    			case 7://if the store doesn't coffer the purchase coffee, or if there is not enough redeem point
			    				//the insertion would fail.
			    				java.sql.Date date_reg = null;
			    				Date date = null;
			    				try{java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
			    			    // This is how you format a date so that you can use the setDate format below
			    				date = df.parse("2018-04-08");
			    			    
			    				}catch (ParseException e) {
			    					System.out.println("Error parsing the date. Machine Error: " +
			    							e.toString());
			    				}
		
			    				List<Integer> coffee = new ArrayList(Arrays.asList(4,4));
			    				List<Integer> purchase = new ArrayList(Arrays.asList(1,1));
			    				List<Integer> redeem = new ArrayList(Arrays.asList(0,0));
			    				tt = BC.addPurchase(1,1,date,coffee,purchase,redeem);
			    				System.out.println(tt);
			    				break;
			    			case 8:
			    				
			    				tt = BC.addMemberLevel("levelTest",4);
			    				System.out.println(tt);
			    				break;
			    			case 9:
			    				tt  = BC.addCustomer("F","L","T@gmail.com",1,100);
			    				System.out.println(tt);
			    				break;
			    			case 10:
			    				date_reg = null;
			    				Date startdate = null,enddate = null;
			    				try{java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
			    			    // This is how you format a date so that you can use the setDate format below
			    				startdate = df.parse("2018-01-01");
			    			    enddate = df.parse("2018-02-01");
			    				}catch (ParseException e) {
			    					System.out.println("Error parsing the date. Machine Error: " +
			    							e.toString());
			    				}
			    				tt= BC.addPromotion("promotion5",startdate,enddate);
			    				System.out.println(tt);
			    				break;
			    			case 11:
			    				tt = BC.addCoffee("TESTCoffee","test",1,2,2,10);
			    				System.out.println(tt);
			    				break;
			    			case 12:
			    				tt= BC.offerCoffee(2,3);
			    				System.out.println(tt);
			    				break;
			    			case 13://parallel value at K would all be printed;
			    				List<Integer> testList = BC.getTopKCustomersInPastXMonth(2,100);
			    				System.out.println(testList);
			    				break;
			    			case 14://parallel value at K would all be printed;
			    				List<Integer>testList2 = BC.getTopKStoresInPastXmonth(2,100);
			    				System.out.println(testList2);
			    				break;
			    			default:
			    			    System.out.println("Example not found for your entry: ");
			    			    try {
			    				connection.close();
			    			    }
			    			    catch(Exception Ex)  {
			    				System.out.println("Error connecting to database.  Machine Error: " +
			    						   Ex.toString());
			    			    }
			    			    break;  			
			    		}
			    	    System.out.println("Type to continue...");
			    	    reader.next();
			    	    String s = reader.nextLine();
		    	    }
		    	    
		    	    
  	
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
