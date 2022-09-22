package com.xxl.job.executor;

import com.xxl.job.executor.common.util.Springcontextutil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */
@SpringBootApplication
public class XxlJobExecutorApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext = SpringApplication.run(XxlJobExecutorApplication.class, args);
		Springcontextutil.setapplicationcontext(applicationContext);
	}

}
