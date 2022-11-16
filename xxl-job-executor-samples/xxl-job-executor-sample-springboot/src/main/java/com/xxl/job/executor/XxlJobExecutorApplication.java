package com.xxl.job.executor;

import com.xxl.job.executor.common.util.Springcontextutil;
import com.xxl.job.executor.service.impl.FileEncryptServiceImpl;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */
@SpringBootApplication
public class XxlJobExecutorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(XxlJobExecutorApplication.class, args);
		FileEncryptServiceImpl fileEncryptService = new FileEncryptServiceImpl();
		//将三方实例对象注入到spring容器中--在对于层层递进的，
		applicationContext.getBeanFactory().registerSingleton("fileEncryptService",fileEncryptService);

		FileEncryptServiceImpl fileEncryptService1 = (FileEncryptServiceImpl)applicationContext.getBean("fileEncryptService");
		System.out.println("111");

		List<String> list =  new ArrayList<>()
;
	list.remove(3);
	}

}
