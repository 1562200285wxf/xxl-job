package com.xxl.job.executor.common.util;

import com.jcraft.jsch.*;
import com.xxl.job.executor.domain.dto.DownloadParameterDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.Vector;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-08-18 13:49
 * @description：
 */
public class SftpUploadUtil {
    protected static Logger logger = LoggerFactory.getLogger(SftpUploadUtil.class);

    //服务器链接IP
    private static String host = "120.27.208.72";
    private static String username = "root";//用户名
    private static String password = Base64Util.decode("MDMwODEwLmd6eQ==");//密码
    private static Integer port = 22;//端口号
    private static int sftpSoTimeout = 1000;

    public static ChannelSftp sftpConnect() {
        try {
            logger.info("==========即将连接SFTP==========");
            JSch jsch = new JSch();
            Session session = jsch.getSession(username, host,port);
            session.setPassword(password);
            Properties config = new Properties();
            config.put("StrictHostKeyChecking", "no");
            //跳过Kerberos校验
            config.put("PreferredAuthentications", "publickey,keyboard-interactive,password");
            session.setConfig(config);
            session.setTimeout(sftpSoTimeout);
            session.connect();
            ChannelSftp channel = (ChannelSftp) session.openChannel("sftp");
            channel.connect(sftpSoTimeout);
            logger.info("==========SFTP登录成功==========");
            return channel;
        } catch (JSchException e) {
            logger.error("==========SFTP登录时出现异常==========", e);
        }
        return null;
    }

    public static void main(String[] args) {
        ChannelSftp channelSftp = SftpUploadUtil.sftpConnect();
        ChannelSftp channelSftp1 = SftpUploadUtil.sftpConnect();
        SftpUploadUtil.downloadAndUpload(channelSftp,channelSftp1,"/data/1.txt","/data/oss/","1.txt");
    }
    public static void closeRemoteConnection(ChannelSftp sftpClient) {
        try {
            if (sftpClient != null) {
                Session session = sftpClient.getSession();
                sftpClient.disconnect();
                if (session != null) {
                    session.disconnect();
                }
            }
            logger.info("==========SFTP资源关闭成功==========");
        } catch (JSchException e) {
            logger.error("SFTP关闭异常", e);
        }
    }

    public static void createDir(String newPath, ChannelSftp sftp) {
        try {
            if (!isDirExist(newPath, sftp)) {
                String paths[] = newPath.split("/");
                StringBuffer filePath = new StringBuffer("/");
                for (String path : paths) {
                    if ("".equals(path)) {
                        continue;
                    }
                    filePath.append(path + "/");
                    if (!isDirExist(filePath.toString(), sftp)) {
                        sftp.mkdir(filePath.toString());
                    }
                    sftp.cd(filePath.toString());
                }
            }
        } catch (SftpException e) {
        }
    }

    private static boolean isDirExist(String directory, ChannelSftp sftp) {
        boolean isDirExistFlag = false;
        try {
            SftpATTRS sftpATTRS = sftp.lstat(directory);
            isDirExistFlag = true;
            return sftpATTRS.isDir();
        } catch (Exception e) {
            if ("no such file".equals(e.getMessage().toLowerCase())) {
                isDirExistFlag = false;
            }
        }
        return isDirExistFlag;
    }

    public static void uploadFileToSftp(ChannelSftp sFtpClient, String src, String dst) {
        try {
            createDir(dst, sFtpClient);
            sFtpClient.put(src, dst);
            logger.debug("上传文件:{}到地址:{}成功", src, dst);
        } catch (SftpException e) {
        }
    }

    public static void uploadFileToSftp(ChannelSftp sFtpClient, InputStream src, String dst) {
        try {
            String[] split = StringUtils.split(dst, "/");
            String directory = "";
            for (int i = 0; i < split.length - 1; i++) directory += "/" + split[i];
            createDir(directory, sFtpClient);
            sFtpClient.put(src, dst);
            logger.debug("上传文件到地址:{}成功", src, dst);
        } catch (SftpException e) {
        }
    }


    /**
     * 从sftp获取文件上传到新sftp
     *
     * @param sftpDown     下载sftp链接
     * @param sftpUp       上传sftp链接
     * @param downFIlePath 下载路径
     * @param upFilePath   上传路径
     * @param fileName     文件名
     * @return 成功、失败
     */
    public static boolean downloadAndUpload(ChannelSftp sftpDown, ChannelSftp sftpUp, String downFIlePath,
                                            String upFilePath, String fileName) {

        InputStream inputStream = null;
        try {
            inputStream = sftpDown.get(downFIlePath);
            if (inputStream != null) {
                SftpUploadUtil.uploadFileToSftp(sftpUp, inputStream, upFilePath + fileName);
            }
        } catch (SftpException e) {
            logger.error("从sftp获取文件上传到新sftp出现异常，打印异常为{}", e);
            return false;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error("输入流关闭异常", e);
                }
            }
        }
        return true;
    }
}
