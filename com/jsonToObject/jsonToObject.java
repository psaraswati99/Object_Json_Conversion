package com.jsonToObject;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.employeeDetail.employee;

public class jsonToObject {
	
	private static ObjectMapper mapper;
	static
	{
		mapper=new ObjectMapper();
	}
	static<T> T jTo(String data,Class<T> cls) throws JsonParseException, JsonMappingException, IOException
	{
		T result=null;
		result=mapper.readValue(data, cls);
		return result;
	}
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader=new BufferedReader(new FileReader("emp.js"));
		String st=null;
		String data = null;
		while((st=bufferedReader.readLine())!=null)
		{
			data=st;
		}
		System.out.println(data);
		
		employee emp=jTo(data,employee.class);
		System.out.println(emp.getName()+" "+emp.getAge()+" "+emp.getDesg()+" "+emp.getSal());
		
	}
}
