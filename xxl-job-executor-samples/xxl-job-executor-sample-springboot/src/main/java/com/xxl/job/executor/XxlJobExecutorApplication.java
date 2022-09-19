package com.xxl.job.executor;

import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xuxueli 2018-10-28 00:38:13
 */
@SpringBootApplication
public class XxlJobExecutorApplication {

	public static void main(String[] args) {
		ConfigurableListableBeanFactory configurableListableBeanFactory = SpringApplication.run(XxlJobExecutorApplication.class, args).getBeanFactory();
		System.out.println("test");

	}

}
