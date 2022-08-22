package com.xxl.job.executor.service.impl;

import com.xxl.job.executor.common.util.ConstantStatus;
import com.xxl.job.executor.domain.po.FileInfo;
import com.xxl.job.executor.mapper.FileInfoMapper;
import com.xxl.job.executor.service.FileInfoService;
import com.xxl.job.executor.service.OssService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;
import java.io.File;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-18 13:47
 * @description：
 */
@Service
public class FileInfoServiceImpl implements FileInfoService {

    @Resource
    FileInfoMapper fileInfoMapper;
    @Resource
    OssService ossService;

    @Override
    @Transactional
    public String fileTran(Date startDate, Date endDate) {

        List<FileInfo> fileInfoList = fileInfoMapper.selectFileInfoByDate(startDate,endDate);
        for (FileInfo fileInfo : fileInfoList) {
            File file = new File(fileInfo.getRealPath());
            String objectName = "oss/"+fileInfo.getFileName();
            String url = ossService.uploadObject(objectName,file);
            if(!Objects.isNull(url)){
                FileInfo updateDto = new FileInfo();
                updateDto.setSerialsNo(fileInfo.getSerialsNo());
                updateDto.setModifyDate(new Date());
                updateDto.setOssPath(url);
                fileInfoMapper.updateById(updateDto);
            }
        }

        return null;
    }

}
