package com.itp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.itp.beans.Employee;
import com.itp.client.ConnectionProvider;

public class StudentDao {
	
	//retire all records..
	public static void displayAllEmployees() {
		
		System.out.println("list of all employees are as follows:  ");
		//step 1: get the connection
		Connection con=ConnectionProvider.getConnection();
		
		//step 2:  Statement Object
		try {
			Statement st=con.createStatement();
			
			String query="select * from emp";
			ResultSet resultset=st.executeQuery(query);
			//step 3: process the result
			
			while(resultset.next())
			{
				System.out.println("employee id: "+resultset.getInt(1));
				System.out.println("employee name: "+resultset.getString(2));
				System.out.println("employee design: "+resultset.getString(3));
				System.out.println("employee address: "+resultset.getString(4));
				System.out.println();
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static boolean insertDataIntoDB(Employee emp)  {
		
		boolean flag=false;
		Connection con=ConnectionProvider.getConnection();
		
		String query="insert into emp values (?,?,?,?)";
		
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, emp.getEmpId());
			ps.setString(2,emp.getEmpName());
			ps.setString(3, emp.getEmpDesignation());
			ps.setString(4, emp.getEmpAddress());
			
			if(ps.executeUpdate()>0)
				flag=true;	
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
		
	}

	public static boolean updateDb(Employee emp) {
		Connection con=ConnectionProvider.getConnection();
		boolean flag=false;
		String query="update emp set ename=?,edesign=?,eaddress=? where eid=?";
		PreparedStatement ps;
		try {
			ps = con.prepareStatement(query);
			ps.setInt(4, emp.getEmpId());
			ps.setString(1,emp.getEmpName());
			ps.setString(2, emp.getEmpDesignation());
			ps.setString(3, emp.getEmpAddress());
			
			
			if(ps.executeUpdate()>0)
				flag=true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return flag;
	}

	public static void deleteRecord(int eid) {
	Connection con=	ConnectionProvider.getConnection();
	String query="delete from emp where eid=?";
	PreparedStatement ps;
	try {
		ps = con.prepareStatement(query);
		ps.setInt(1, eid);
		if(ps.executeUpdate()>0)
			System.out.println("deleted successfully");
		else
			System.out.println("failed to delete the record");
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

	public static void displayEmployeeById(int eid) {
		Connection con=ConnectionProvider.getConnection();
		String query="select * from emp where eid=?";
		try {
			PreparedStatement ps=con.prepareStatement(query);
			ps.setInt(1, eid);
		ResultSet resultset=ps.executeQuery();
		while(resultset.next())
		{
			System.out.println("employee id: "+resultset.getInt(1));
			System.out.println("employee name: "+resultset.getString(2));
			System.out.println("employee design: "+resultset.getString(3));
			System.out.println("employee address: "+resultset.getString(4));
			System.out.println();
		}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

//	public static void displayEmployeeById(String eid) {
//		System.out.println("not recommended way.....................");
//		Connection con=ConnectionProvider.getConnection();
//		String query="select * from emp where eid="+eid;
//		System.out.println(query);
//		try {
//			Statement statement=con.createStatement();
//			
//		ResultSet resultset=statement.executeQuery(query);
//		
//		while(resultset.next())
//		{
//			System.out.println("employee id: "+resultset.getInt(1));
//			System.out.println("employee name: "+resultset.getString(2));
//			System.out.println("employee design: "+resultset.getString(3));
//			System.out.println("employee address: "+resultset.getString(4));
//			System.out.println();
//		}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
}
