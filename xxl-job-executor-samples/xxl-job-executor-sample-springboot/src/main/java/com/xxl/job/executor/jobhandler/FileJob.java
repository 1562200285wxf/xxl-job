package com.xxl.job.executor.jobhandler;

import com.xxl.job.core.handler.annotation.XxlJob;
import com.xxl.job.executor.common.util.DateUtils;
import com.xxl.job.executor.service.FileInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-18 18:02
 * @description：
 */
@Component
public class FileJob {

    @Resource
    FileInfoService fileInfoService;

    @XxlJob("FileTranHandler")
    public void fileTran(String flag){
        Date startDate = null;
        Date endDate = null;
        if(StringUtils.isBlank(flag)) {
            Date beforeDate = DateUtils.getDayBefore(new Date());
            startDate = DateUtils.getYYYYMMDD000000(beforeDate);
            endDate = DateUtils.getYYYYMMDD235959(beforeDate);
        }
        fileInfoService.fileTran(startDate,endDate);
    }

}
