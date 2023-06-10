package com.itp.client;
import java.util.Scanner;

import com.itp.beans.Employee;
import com.itp.dao.StudentDao;

public class StartApp {

	public static void main(String[] args) {
		System.out.println("******************** Welcome to Employee Management System. ********************\n");
      while(true)
      { 
    	  System.out.println("1.  Press 1 to insert employee record.");
          System.out.println("2.  Press 2 to display all employees records.");
          System.out.println("3.  Press 3 to update employee record. ");
          System.out.println("4.  press 4 to delete employee record. ");
          System.out.println("5.  press 5 exit from app.");
          
         Scanner sc=new Scanner(System.in);
         System.out.println("please enter your choice:");
         int choice=sc.nextInt();  //here we will get user input in form of integer.
         
         switch(choice)
         {
         
         case 1: {
      	   
      	   System.out.println("please enter employee details to insert..\n");
      	   System.out.println("please enter emp id:");
      	   int eid=sc.nextInt();
      	   
      	   System.out.println("please enter emp name");
      	   String ename=sc.next();
      	   
      	   System.out.println("please enter emp designantion");
      	   String desig=sc.next();
      	   
      	   System.out.println("please enter emp address");
      	   String adress=sc.next();
      	   
      	   Employee emp=new Employee(eid, ename, desig, adress);
      	   
      	   if(StudentDao.insertDataIntoDB(emp))
      	   {   System.out.println("data inserted successfully!!");
  	       StudentDao.displayAllEmployees();}
  	       else
  	       {
  	    	   System.out.println("filed to insert data!!");
  	       }
         }
        break;
         
         case 2: StudentDao.displayAllEmployees();
                 break;
         
         case 3://update the records
        	 break;
        	 
         case 4: //delete the records
        	 break;
        	 
         case 5: //will exit from app
        	 System.exit(0);
        	 
        	 default:
        		 System.out.println("please enter valid input");
         
         System.out.println("do you want to exit the app  Y/y?");
         char ch=sc.next().charAt(0);
         
         if(ch=='Y' || ch =='y')
         {
        	 System.exit(0);
         }
         
         }}
	}

}
