package com.amazonaws.lambda.demo;

import org.json.JSONObject;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import test.RdsDetails;
import vo.ComplaintVo;

public class LambdaFunctionHandler implements RequestHandler<Object, String> {
	String message;
	ComplaintVo cv1 = new ComplaintVo();
	ComplaintVo cv;
    @Override
    public String handleRequest(Object input, Context context) {
        context.getLogger().log("Input: " + input);
        JSONObject obj; 
		try {
			obj = new JSONObject(input.toString());
			cv1.setName(obj.getString("name"));
			cv1.setContact(obj.getString("contact"));
			RdsDetails rds = new RdsDetails();
			cv = rds.getDetailsFromRds(cv1.getName(), cv1.getContact(),context);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		message = "Name: "+cv.getName()+" Contact: "+cv.getContact()+ " Address: "+ cv.getAddress()+"S3 key: "+cv.getS3key();
		
        return message ;
    }

}
