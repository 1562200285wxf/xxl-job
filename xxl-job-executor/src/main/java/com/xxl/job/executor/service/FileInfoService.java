package com.xxl.job.executor.service;

import java.util.Date;
import java.util.concurrent.ExecutionException;

public interface FileInfoService {

    String fileTran(Date startDate, Date endDate);
}
