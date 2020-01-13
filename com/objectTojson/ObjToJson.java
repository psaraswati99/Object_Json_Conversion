package com.objectTojson;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.employeeDetail.employee;

public class ObjToJson {
	private static ObjectMapper mapper;
	static 
	{
		mapper=new ObjectMapper();
	}
	private static String getData(Object object) throws JsonGenerationException, JsonMappingException, IOException
	{
		String data=mapper.writeValueAsString(object);
		return data;
	}
	public static void main(String[] args) throws JsonGenerationException, JsonMappingException, IOException {
		
		File file=new File("emp.js");
		FileOutputStream fileOutputStream=new FileOutputStream(file);
		
		employee emp=new employee();
		emp.setName("shanu");
		emp.setAge(78);
		emp.setDesg("manager");
		emp.setSal(87600);
		
		String jsonData=getData(emp);
		System.out.println(jsonData);
		byte b[]=jsonData.getBytes();
		fileOutputStream.write(b);
		fileOutputStream.close();
		

	}

}
