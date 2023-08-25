package com.kh.di;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

// HelloFactory는 hello.properties(부가정보, meta-data)의 내용을 읽어 
// Hello 객체를 생성하고 return하는 역할 공장이니 싱글톤 패턴으로만듦
public class HelloFactory {

	private Hello hello;
	private Properties properties;

	private static HelloFactory helloFactory;

	private HelloFactory() {
	}

	public synchronized static HelloFactory getInstance() { // synchronized는 동기화땜에 사용
		// 동기화는 작업하나가 끝날때까지 다른작업이 들어오지 못하게 하는 이유로 함
		if (helloFactory == null) {
			helloFactory = new HelloFactory();
		}
		return helloFactory;
	}
	// properties file을 추상화, 캡슐화 java.util.Properties 객체 생성
	public void setConfigResource(String configResource) {
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(configResource);
			properties = new Properties();
			try {
				properties.load(fis);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		}
	// name에 해당하는 객체 생성하는 역할
		private void newInstanceHello(String name) {
			
	String className = properties.getProperty(name).trim();// trim은 앞뒤 공간이 있을까봐 제거하는용도
	System.out.println("hello.properties에서 추출한 className : " +className);
	
	try {
		Class cls = Class.forName(className);
		Object obj = cls.newInstance();
		if(obj instanceof Hello) {
			this.hello=(Hello) obj;
		}		
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}catch(Exception e) {
		e.printStackTrace();
	}
	
	}
		// Hello 객체 생성하는 newInstanceHello() 호출 및 Hello 객체를 return
		public Hello getBean(String name) {
			this.newInstanceHello(name);
			return hello;
		}
}
