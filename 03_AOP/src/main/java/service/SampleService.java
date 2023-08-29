package service;

import org.aspectj.lang.annotation.AfterThrowing;
import org.springframework.stereotype.Service;

@Service
public class SampleService {

	
	public Integer adoAdd(String str1, String str2)throws Exception{
		
		return Integer.parseInt(str1)+ Integer.parseInt(str2);
		
	}
	@AfterThrowing(pointcut="", throwing="exception(* com.kh.service.SampleService*.*(..))", throws)
	public void logException(Exception exception) {
		log.info("Exception...!!");
		log.info("exception : " + exception);
	}

}
