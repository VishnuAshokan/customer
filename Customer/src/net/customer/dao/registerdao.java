package net.customer.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import net.customer.model.register;

public class registerdao {
	
	public int userReg(register reg) throws ClassNotFoundException {
		String INSERT = "INSERT INTO `register` (firstName,lastName,email,phoneNumber,password) "+ 
				"values(?,?,?,?,?);";
		
		int result = 0;
		Class.forName("com.mysql.jdbc.Driver");
		try(Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_database?useSSL=false","root","");
				PreparedStatement prep = con.prepareStatement(INSERT)){
			
			prep.setNString(1, reg.getfName());
			prep.setNString(2, reg.getlName());
			prep.setNString(3, reg.getEmail());
			prep.setNString(4, reg.getPhone());
			prep.setNString(5, reg.getPassword());
			
			System.out.println(prep+"insertion successful");
			
			result=prep.executeUpdate();
			
		} catch(SQLException e) {
			
		}
		return result;
			
		
	}

}
