package com.xxl.job.executor.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xxl.job.executor.domain.po.FileInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

@Mapper
public interface FileInfoMapper extends BaseMapper<FileInfo> {

    List<FileInfo> selectFileInfoByDate(@Param("startDate") Date startDate,@Param("endDate") Date endDate);
}
