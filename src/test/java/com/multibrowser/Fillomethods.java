package com.multibrowser;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;

public class Fillomethods {
	
	public static ThreadLocal<Dictionary> TestData = new ThreadLocal<Dictionary>();
	 public static ThreadLocal<String> CurrentDir = new ThreadLocal<String>();
	 public static ThreadLocal<String> TestData_File = new ThreadLocal<String>();
	
	
 	public static Object ReadExcel(String data) {
	        try {
	        	
	        	CurrentDir.set(System.getProperty("user.dir").replace("\\", "/")); 
	        	TestData_File.set(CurrentDir.get() + "/Test Data/TestdataDB.xlsx"); 
	        	
	            String Screen = "Login";
	            Dictionary<String, String> dict = new Hashtable<String, String>();
	            String TestDataPath = TestData_File.get();
	            //fUpdateLog(TestDataPath);
	            Fillo fillo = new Fillo();
	            Connection connection = fillo.getConnection(TestDataPath);
	            String strQuery = "Select * from " + Screen + "  Where URL = \'" + data + "\'";  
	 

	            Recordset rs = connection.executeQuery(strQuery);
	            int noOfColumns = rs.getFieldNames().size();
	            int noOfRows = rs.getCount();
	            ArrayList<String> fieldnames = rs.getFieldNames();
	            rs.moveNext();
	            for (int readloop = 0; readloop < noOfColumns; readloop++) {
	                String colname = fieldnames.get(readloop);
	                // if (!colname.equals("Application_Details")) {
	                String dat = rs.getField(readloop).value();
	                if (dat == null) {
	                    dict.put(colname, "");
	                } else {
	                    dict.put(colname, dat);
	                }
	                // }
	            }
	            rs.close();	
	            connection.close();
	            return dict;
	        } catch (Exception e) {
	            e.printStackTrace();
	            return null;
	        }
	    }
	    public static String getdata(String colname) {
	        String c = "";
	        try {
	            TestData.set((Dictionary<?, ?>) ReadExcel("https://parabank.parasoft.com/parabank/register.htm"));
	            c = TestData.get().get(colname).toString();
	            return c;
	        } catch (Exception e) {
	            return c;
	        }
	    }

}
