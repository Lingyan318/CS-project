import java.text.ParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Arrays;
import java.sql.*;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BCBenchmark
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
	    	    
			int tt=0;
		    	    System.out.println("--------addStore--------");
		    	    System.out.println("-----------------------------");
		    	   tt = BC.addStore("StoreA","123 first street pittsburgh PA 30034","a",100,200);
		    	   System.out.println(tt);
		    	   tt = BC.addStore("StoreB","456 second street pittsburgh PA 30034","b",432,343);
		    	   System.out.println(tt);
		    	   tt = BC.addStore("StoreC","434 thrid street pittsburgh PA 30034","c",1023,344);
		    	   System.out.println(tt);
		    	   tt = BC.addStore("StoreD","343 forth street pittsburgh PA 30034","d",3420,340);
		    	   System.out.println(tt);
		    	   tt = BC.addStore("StoreE","233 fifth street pittsburgh PA 30034","a",100,200);
		    	   System.out.println(tt);
		    	   tt = BC.addStore("StoreF","254 sixth street pittsburgh PA 30034","b",5650,560);
		    	   System.out.println(tt);
		    	   tt = BC.addStore("StoreG","646 ninth street pittsburgh PA 30034","c",3400,563);
		    	   System.out.println(tt);
		    	   tt = BC.addStore("StoreH","878 a street pittsburgh PA 30034","d",6767,5670);
		    	   System.out.println(tt);
		    	   tt = BC.addStore("StoreI","087 b street pittsburgh PA 30034","a",756,7644);
		    	   System.out.println(tt);
		    	   tt = BC.addStore("StoreJ","676 c street pittsburgh PA 30034","b",1234,7644);
		    	   System.out.println(tt);
		    	   tt = BC.addStore("StoreK","565 d street pittsburgh PA 30034","c",6453,7543);
		    	   System.out.println(tt);
		    	   tt = BC.addStore("StoreL","2465 e street pittsburgh PA 30034","d",4543,4500);
		    	   System.out.println(tt);
		    	   tt = BC.addStore("StoreM","256 street pittsburgh PA 30034","a",4530,4540);
		    	   System.out.println(tt);
		    	   tt = BC.addStore("StoreN","267 g street pittsburgh PA 30034","b",45400,2460);
		    	   System.out.println(tt);
		    	    System.out.println("--------------------------------------------"); 
		    	    
		    	    System.out.println();
		    	    System.out.println();
		    	    
		    	    System.out.println("-----------addCoffee----------");
		    	    System.out.println("--------------------------------------------"); 
		    	    tt =  BC.addCoffee("affogato", "a", 60,7, 10, 30);
		    	    System.out.println(tt);
		    	    tt = BC.addCoffee("cafe mocha", "b", 40, 7,10, 40);
		    	    System.out.println(tt);
		    	    tt = BC.addCoffee("cappuccino","c", 40,16,20,60);
		    	    System.out.println(tt);
		    	    tt = BC.addCoffee("galao","d", 70,9,10,40);
		    	    System.out.println(tt);
		    	    tt = BC.addCoffee("iced coffee","e", 70,6,10,30);
		    	    System.out.println(tt);
		    	    tt = BC.addCoffee("instant coffee","f", 70,10,30,80);
		    	    System.out.println(tt);
		    	    tt = BC.addCoffee("americano","g", 30,14,20,70);
		    	    System.out.println(tt);
		    	    tt = BC.addCoffee("breve","h",50,17,20,40);
		    	    System.out.println(tt);
		    	    tt = BC.addCoffee("coffee milk", "i", 30,8,15, 50);
		    	    System.out.println(tt);
		    	    tt = BC.addCoffee("cortado","l", 30, 9,40, 60);
		    	    System.out.println(tt);
		    	    tt = BC.addCoffee("frappuccino","m",40,15,30,60);
		    	    System.out.println(tt);
		    	    tt = BC.addCoffee("irish coffee", "n ",60,10,30,40);
		    	    System.out.println(tt);
		    	    System.out.println("--------------------------------------------"); 
		    	    
		    	    System.out.println();
		    	    System.out.println();
		    	    
		    	    System.out.println("offer coffee");
		    	    System.out.println("--------------------------------------------"); 
		    	      for(int a=1;a<=14;a++)
		    	    {
		    	    	for(int b=1 ;b<=12;b++)
		    	    	{
		    	    		tt = BC.offerCoffee(a,b);
		    	    		System.out.println(tt);
		    	    	}
		    	    }
		    	    System.out.println("--------------------------------------------"); 
		    	    
		    	    System.out.println();
		    	    System.out.println();
		    	    
		    	    System.out.println("getCoffees List");
		    	    System.out.println("--------------------------------------------"); 
		    	    BC.getCoffees();
		    	    System.out.println("--------------------------------------------"); 
		            
		    	    System.out.println();
		    	    System.out.println();
	
		    	    System.out.println("getCoffeesByKeywords");
		    	    System.out.println("--------------------------------------------"); 
		    	    BC.getCoffeesByKeywords("c","c");
		            BC.getCoffeesByKeywords("a","c");
		            BC.getCoffeesByKeywords("b","c");
		            BC.getCoffeesByKeywords("c","i");
		    	    BC.getCoffeesByKeywords("a","e");
		    	    BC.getCoffeesByKeywords("u","c");
		    	    BC.getCoffeesByKeywords("f","c");
		    	    System.out.println("--------------------------------------------"); 
		    	    
		    	    System.out.println();
		    	    System.out.println();
		    	    
		    	    System.out.println("getcoffee");
		    	    System.out.println("--------------------------------------------"); 
		    	    BC.getCoffees();
		    	   
		    	    System.out.println("--------------------------------------------"); 
		    	    
		    	    System.out.println();
		    	    System.out.println();
		    	    
			
java.sql.Date date_reg = null;
			
			
			
Date startdate = null,enddate = null;
System.out.println("addPromotion");
try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	startdate = df.parse("2018-01-01");
	enddate = df.parse("2018-02-01");
	}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
tt= BC.addPromotion("promotion1",startdate,enddate);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	startdate = df.parse("2017-02-01");
	enddate = df.parse("2017-03-01");
	}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
tt= BC.addPromotion("promotion2",startdate,enddate);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	startdate = df.parse("2017-03-01");
	enddate = df.parse("2017-04-01");
	}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
tt= BC.addPromotion("promotion3",startdate,enddate);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	startdate = df.parse("2017-04-01");
	enddate = df.parse("2017-05-01");
	}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
tt= BC.addPromotion("promotion4",startdate,enddate);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	startdate = df.parse("2017-05-01");
	enddate = df.parse("2017-06-01");
	}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
tt= BC.addPromotion("promotion6",startdate,enddate);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	startdate = df.parse("2017-06-01");
	enddate = df.parse("2017-07-01");
	}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
tt= BC.addPromotion("promotion7",startdate,enddate);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	startdate = df.parse("2017-07-01");
	enddate = df.parse("2017-08-01");
	}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
tt= BC.addPromotion("promotion8",startdate,enddate);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	startdate = df.parse("2017-08-01");
	enddate = df.parse("2017-09-01");
	}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
tt= BC.addPromotion("promotion9",startdate,enddate);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	startdate = df.parse("2017-09-01");
	enddate = df.parse("2017-10-01");
	}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
tt= BC.addPromotion("promotion10",startdate,enddate);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	startdate = df.parse("2017-10-01");
	enddate = df.parse("2017-11-01");
	}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
tt= BC.addPromotion("promotion10",startdate,enddate);
System.out.println(tt);



/***************************hasPromotion**********************************/
System.out.println("hasPromotion");
tt = BC.hasPromotion(1,1);
System.out.println(tt);

tt = BC.hasPromotion(1,2);
System.out.println(tt);

tt = BC.hasPromotion(1,3);
System.out.println(tt);

tt = BC.hasPromotion(1,5);
System.out.println(tt);

tt = BC.hasPromotion(2,1);
System.out.println(tt);

tt = BC.hasPromotion(2,2);
System.out.println(tt);

tt = BC.hasPromotion(2,3);
System.out.println(tt);

tt = BC.hasPromotion(2,4);
System.out.println(tt);

tt = BC.hasPromotion(2,5);
System.out.println(tt);

tt = BC.hasPromotion(2,6);
System.out.println(tt);

tt = BC.hasPromotion(3,1);
System.out.println(tt);

tt = BC.hasPromotion(3,2);
System.out.println(tt);

tt = BC.hasPromotion(3,3);
System.out.println(tt);

tt = BC.hasPromotion(3,4);
System.out.println(tt);

tt = BC.hasPromotion(3,5);
System.out.println(tt);

tt = BC.hasPromotion(3,6);
System.out.println(tt);

tt = BC.hasPromotion(8,1);
System.out.println(tt);

tt = BC.hasPromotion(8,2);
System.out.println(tt);

tt = BC.hasPromotion(8,3);
System.out.println(tt);

tt = BC.hasPromotion(8,4);
System.out.println(tt);

tt = BC.hasPromotion(8,5);
System.out.println(tt);

tt = BC.hasPromotion(8,6);
System.out.println(tt);

tt = BC.hasPromotion(13,1);
System.out.println(tt);

tt = BC.hasPromotion(12,2);
System.out.println(tt);

tt = BC.hasPromotion(13,2);
System.out.println(tt);

tt = BC.hasPromotion(13,3);
System.out.println(tt);

tt = BC.hasPromotion(13,5);
System.out.println(tt);

/*****************************promoteFor()**********************/
System.out.println("promoteFor");
tt = BC.promoteFor(1,2);
System.out.println(tt);

tt = BC.promoteFor(1,3);
System.out.println(tt);

tt = BC.promoteFor(1,4);
System.out.println(tt);

tt = BC.promoteFor(1,5);
System.out.println(tt);

tt = BC.promoteFor(2,1);
System.out.println(tt);

tt = BC.promoteFor(2,2);
System.out.println(tt);

tt = BC.promoteFor(2,3);
System.out.println(tt);

tt = BC.promoteFor(2,4);
System.out.println(tt);

tt = BC.promoteFor(2,5);
System.out.println(tt);

tt = BC.promoteFor(2,6);
System.out.println(tt);

tt = BC.promoteFor(2,7);
System.out.println(tt);

tt = BC.promoteFor(2,8);
System.out.println(tt);

tt = BC.promoteFor(2,11);
System.out.println(tt);

tt = BC.promoteFor(5,1);
System.out.println(tt);

tt = BC.promoteFor(5,3);
System.out.println(tt);

tt = BC.promoteFor(5,4);
System.out.println(tt);

tt = BC.promoteFor(5,7);
System.out.println(tt);

tt = BC.promoteFor(5,10);
System.out.println(tt);

tt = BC.promoteFor(7,8);
System.out.println(tt);

tt = BC.promoteFor(7,9);
System.out.println(tt);

tt = BC.promoteFor(8,1);
System.out.println(tt);

tt = BC.promoteFor(8,2);
System.out.println(tt);

tt = BC.promoteFor(8,3);
System.out.println(tt);

/**********************addMemberLevel**********************/
System.out.println("addMemberLevel");
tt = BC.addMemberLevel("levelTest",1.5);
System.out.println(tt);

tt = BC.addMemberLevel("levelTest",2);
System.out.println(tt);

tt = BC.addMemberLevel("levelTest",2.25);
System.out.println(tt);

tt = BC.addMemberLevel("levelTest",2.5);
System.out.println(tt);

tt = BC.addMemberLevel("levelTest",2.75);
System.out.println(tt);

tt = BC.addMemberLevel("levelTest",3);
System.out.println(tt);


/********************addCustomer***********************/
System.out.println("addCustomer");
tt  = BC.addCustomer("F","L","T@gmail.com",1,100);
System.out.println(tt);
			
tt  = BC.addCustomer("F","L","1@gmail.com",1,100);
System.out.println(tt);

tt  = BC.addCustomer("F","L","2@gmail.com",2,100);
System.out.println(tt);

tt  = BC.addCustomer("F","L","3@gmail.com",3,200);
System.out.println(tt);

tt  = BC.addCustomer("F","L","4@gmail.com",4,100);
System.out.println(tt);

tt  = BC.addCustomer("F","L","5@gmail.com",1,110);
System.out.println(tt);

tt  = BC.addCustomer("F","L","6@gmail.com",2,100);
System.out.println(tt);

tt  = BC.addCustomer("F","L","7@gmail.com",2,100);
System.out.println(tt);

tt  = BC.addCustomer("F","L","8@gmail.com",2,100);
System.out.println(tt);

tt  = BC.addCustomer("F","L","9@gmail.com",2,100);
System.out.println(tt);

tt  = BC.addCustomer("F","L","10@gmail.com",2,100);
System.out.println(tt);

tt  = BC.addCustomer("F","L","11@gmail.com",2,10000);
System.out.println(tt);

tt  = BC.addCustomer("F","L","12@gmail.com",2,100);
System.out.println(tt);

tt  = BC.addCustomer("F","L","13@gmail.com",2,10000);
System.out.println(tt);

tt  = BC.addCustomer("F","L","14@gmail.com",2,10000);
System.out.println(tt);

tt  = BC.addCustomer("F","L","15@gmail.com",2,100);
System.out.println(tt);

tt  = BC.addCustomer("F","L","16@gmail.com",2,100);
System.out.println(tt);

tt  = BC.addCustomer("F","L","17@gmail.com",2,100);
System.out.println(tt);

tt  = BC.addCustomer("F","L","18@gmail.com",2,100);
System.out.println(tt);

tt  = BC.addCustomer("F","L","19@gmail.com",2,1000);
System.out.println(tt);

tt  = BC.addCustomer("F","L","20@gmail.com",3,100);
System.out.println(tt);

/***********************addPurchase***************************/
System.out.println("addPurchase");
Date date = null;

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-04-08");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee = new ArrayList(Arrays.asList(2,3));
List<Integer> purchase = new ArrayList(Arrays.asList(1,1));
List<Integer> redeem = new ArrayList(Arrays.asList(0,0));
tt = BC.addPurchase(1,1,date,coffee,purchase,redeem);
System.out.println(tt);


try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-04-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee1 = new ArrayList(Arrays.asList(4,3));
List<Integer> purchase1 = new ArrayList(Arrays.asList(2,1));
List<Integer> redeem1 = new ArrayList(Arrays.asList(1,0));
tt = BC.addPurchase(2,1,date,coffee1,purchase1,redeem1);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-04-10");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee2 = new ArrayList(Arrays.asList(4,3));
List<Integer> purchase2 = new ArrayList(Arrays.asList(2,1));
List<Integer> redeem2 = new ArrayList(Arrays.asList(0,0));
tt = BC.addPurchase(3,1,date,coffee2,purchase2,redeem2);
System.out.println(tt);



try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-04-10");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee3 = new ArrayList(Arrays.asList(4,3));
List<Integer> purchase3 = new ArrayList(Arrays.asList(2,1));
List<Integer> redeem3 = new ArrayList(Arrays.asList(0,0));
tt = BC.addPurchase(4,1,date,coffee3,purchase3,redeem3);
System.out.println(tt);


try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-04-10");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee4 = new ArrayList(Arrays.asList(4,3));
List<Integer> purchase4 = new ArrayList(Arrays.asList(2,1));
List<Integer> redeem4 = new ArrayList(Arrays.asList(1,0));
tt = BC.addPurchase(5,1,date,coffee4,purchase4,redeem4);
System.out.println(tt);


try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-04-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee5 = new ArrayList(Arrays.asList(4,3));
List<Integer> purchase5 = new ArrayList(Arrays.asList(2,1));
List<Integer> redeem5 = new ArrayList(Arrays.asList(0,0));
tt = BC.addPurchase(6,1,date,coffee5,purchase5,redeem5);
System.out.println(tt);


try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-04-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee6 = new ArrayList(Arrays.asList(4,3));
List<Integer> purchase6 = new ArrayList(Arrays.asList(2,1));
List<Integer> redeem6 = new ArrayList(Arrays.asList(0,0));
tt = BC.addPurchase(7,1,date,coffee6,purchase6,redeem6);
System.out.println(tt);


try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-05-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee7 = new ArrayList(Arrays.asList(4,3));
List<Integer> purchase7 = new ArrayList(Arrays.asList(2,1));
List<Integer> redeem7 = new ArrayList(Arrays.asList(0,0));
tt = BC.addPurchase(8,1,date,coffee7,purchase7,redeem7);
System.out.println(tt);



try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-05-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee8 = new ArrayList(Arrays.asList(4,3));
List<Integer> purchase8 = new ArrayList(Arrays.asList(2,1));
List<Integer> redeem8 = new ArrayList(Arrays.asList(0,0));
tt = BC.addPurchase(1,2,date,coffee8,purchase8,redeem8);
System.out.println(tt);


try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-05-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee9 = new ArrayList(Arrays.asList(4,3));
List<Integer> purchase9 = new ArrayList(Arrays.asList(2,1));
List<Integer> redeem9 = new ArrayList(Arrays.asList(0,0));
tt = BC.addPurchase(8,10,date,coffee9,purchase9,redeem9);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-06-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee10 = new ArrayList(Arrays.asList(4,3));
List<Integer> purchase10 = new ArrayList(Arrays.asList(2,1));
List<Integer> redeem10 = new ArrayList(Arrays.asList(0,0));
tt = BC.addPurchase(8,10,date,coffee10,purchase10,redeem10);
System.out.println(tt);


try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-05-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee11 = new ArrayList(Arrays.asList(4,3));
List<Integer> purchase11 = new ArrayList(Arrays.asList(2,1));
List<Integer> redeem11 = new ArrayList(Arrays.asList(0,0));
tt = BC.addPurchase(8,11,date,coffee11,purchase11,redeem11);
System.out.println(tt);


try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-05-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee12 = new ArrayList(Arrays.asList(4,3));
List<Integer> purchase12 = new ArrayList(Arrays.asList(2,1));
List<Integer> redeem12 = new ArrayList(Arrays.asList(0,0));
tt = BC.addPurchase(7,1,date,coffee12,purchase12,redeem12);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-05-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee13 = new ArrayList(Arrays.asList(4,3));
List<Integer> purchase13 = new ArrayList(Arrays.asList(2,1));
List<Integer> redeem13 = new ArrayList(Arrays.asList(0,0));
tt = BC.addPurchase(7,2,date,coffee13,purchase13,redeem13);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-05-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee14 = new ArrayList(Arrays.asList(4,3));
List<Integer> purchase14 = new ArrayList(Arrays.asList(2,1));
List<Integer> redeem14 = new ArrayList(Arrays.asList(1,0));
tt = BC.addPurchase(7,3,date,coffee7,purchase14,redeem14);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-05-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee15 = new ArrayList(Arrays.asList(4,3,6));
List<Integer> purchase15 = new ArrayList(Arrays.asList(2,1,1));
List<Integer> redeem15 = new ArrayList(Arrays.asList(0,0,0));
tt = BC.addPurchase(6,1,date,coffee15,purchase15,redeem15);
System.out.println(tt);


try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-05-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee16 = new ArrayList(Arrays.asList(9,3,6));
List<Integer> purchase16 = new ArrayList(Arrays.asList(2,1,1));
List<Integer> redeem16 = new ArrayList(Arrays.asList(0,0,0));
tt = BC.addPurchase(6,1,date,coffee16,purchase16,redeem16);
System.out.println(tt);


try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-05-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee17 = new ArrayList(Arrays.asList(1,3,6));
List<Integer> purchase17 = new ArrayList(Arrays.asList(2,1,1));
List<Integer> redeem17 = new ArrayList(Arrays.asList(0,1,0));
tt = BC.addPurchase(6,1,date,coffee15,purchase15,redeem15);
System.out.println(tt);



try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-05-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee18 = new ArrayList(Arrays.asList(1,3,6));
List<Integer> purchase18 = new ArrayList(Arrays.asList(2,1,1));
List<Integer> redeem18 = new ArrayList(Arrays.asList(0,0,0));
tt = BC.addPurchase(5,9,date,coffee15,purchase15,redeem15);
System.out.println(tt);

try{
	java.text.SimpleDateFormat df = new java.text.SimpleDateFormat("yyyy-MM-dd");
	date = df.parse("2018-05-09");
}
catch (ParseException e){
	System.out.println("Error parsing the date. Machine Error: " + e.toString());
}
		
List<Integer> coffee19 = new ArrayList(Arrays.asList(1,3,6));
List<Integer> purchase19 = new ArrayList(Arrays.asList(2,1,1));
List<Integer> redeem19 = new ArrayList(Arrays.asList(0,0,0));
tt = BC.addPurchase(4,9,date,coffee19,purchase19,redeem19);
System.out.println(tt);
		    	    System.out.println("getPointsByCustomerId");
		    	    System.out.println("--------------------------------------------"); 
		    	   for(int i=1; i<=20;i++)
		    	   {
		    		 BC.getPointsByCustomerId(i);
		    		 
		    	   }
		    	    System.out.println("--------------------------------------------"); 
		    	    
		    	    System.out.println();
		    	    System.out.println();
		    	    
		    	    System.out.println("getTopKStoresInPastXMonth");
		    	    System.out.println("--------------------------------------------"); 
		    	    List<Integer> testList;
			    testList= BC.getTopKStoresInPastXmonth(1,1);
		    	    System.out.println(testList);
		    	    testList = BC.getTopKStoresInPastXmonth(1,4);
		    	    System.out.println(testList);
		    	    testList = BC.getTopKStoresInPastXmonth(3,3);
		    	    System.out.println(testList);
		    	    testList= BC.getTopKStoresInPastXmonth(5,6);
		    	    System.out.println(testList);
		    	    testList = BC.getTopKStoresInPastXmonth(6,6);
		    	    System.out.println(testList);
		    	    System.out.println("--------------------------------------------"); 
		    	    
		    	    System.out.println();
		    	    System.out.println();
		    	    
		    	    System.out.println("getTopKCustomerInPastXmonth");
		    	    System.out.println("--------------------------------------------");
			     List<Integer> testList1;
		    	    testList1 = BC.getTopKCustomersInPastXMonth(1,2);
		    	    System.out.println(testList1);
		    	    testList1 = BC.getTopKCustomersInPastXMonth(2,6);
		    	    System.out.println(testList1);
		    	    testList1 = BC.getTopKCustomersInPastXMonth(4,6);
		    	    System.out.println(testList1);
		    	    testList1 = BC.getTopKCustomersInPastXMonth(3,7);
		    	    System.out.println(testList1);
		    	    testList1= BC.getTopKCustomersInPastXMonth(6,6);
		    	    System.out.println(testList1);
		    	    System.out.println("--------------------------------------------");
		    	    
			   
		    	    
		    	    
		    	    
  	
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
