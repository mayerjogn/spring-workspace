package service;

import org.springframework.stereotype.Service;

@Service
public class SampleService {

	
	public Integer adoAdd(String str1, String str2)throws Exception{
		
		return Integer.parseInt(str1)+ Integer.parseInt(str2);
		
	}
}
