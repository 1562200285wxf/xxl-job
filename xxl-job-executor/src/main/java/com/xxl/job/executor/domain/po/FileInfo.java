package com.xxl.job.executor.domain.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-18 13:38
 * @description：文件信息
 */
@TableName("file_info")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {
    @TableId("serials_no")
    String serialsNo;
    String channelCode;
    String fileName;
    String fileType;
    String realPath;
    String ossPath;

    Date createDate;
    Date modifyDate;

    @TableLogic
    String delFlag;
}
