package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.amazonaws.services.lambda.runtime.Context;

import vo.ComplaintVo;

public class RdsDetails {
	public ComplaintVo getDetailsFromRds(String name, String contact, Context context) throws SQLException {
		ComplaintVo complaintVo = new ComplaintVo();
		Connection con=null;
		try {
		Class.forName("com.mysql.jdbc.Driver");  
		con=DriverManager.getConnection(  
		"jdbc:mysql://sagardbidentifier.czpjy57gisbg.us-east-2.rds.amazonaws.com:3306/SagarDB","root","rootroot");  
		Statement stmt=con.createStatement();  

		ResultSet rs = stmt.executeQuery("SELECT * from complaints where name='"+name+"' and contact='"+contact+"'");
		context.getLogger().log("Entering while loop");
		while(rs.next()) {
			complaintVo.setName(rs.getString("name"));
			complaintVo.setAddress(rs.getString("address"));
			complaintVo.setContact(rs.getString("contact"));
			complaintVo.setS3key(rs.getString("S3key"));
			context.getLogger().log("\nName is :"+complaintVo.getName()+"\n");
			context.getLogger().log("Address is :"+complaintVo.getAddress()+"\n");
			context.getLogger().log("Contact is :"+complaintVo.getContact()+"\n");
			context.getLogger().log("S3Key is :"+complaintVo.getS3key()+"\n");
			
		}
		context.getLogger().log("Exiting while loop");

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		finally {
		con.close();
		}
		
		
	return complaintVo;
	}
}
