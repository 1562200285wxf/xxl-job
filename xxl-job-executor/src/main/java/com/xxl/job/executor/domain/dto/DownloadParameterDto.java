package com.xxl.job.executor.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DownloadParameterDto {

    private String host;//服务器连s接ip
    private String username;//用户名
    private String password;//密码
    private Integer port = 22;//端口号
    private int sftpSoTimeout;
}
