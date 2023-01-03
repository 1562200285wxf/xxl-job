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
		SpringApplication.run(XxlJobExecutorApplication.class, args);
	}

}
