package com.xxl.job.executor.study.annotation;

import lombok.Data;
import lombok.ToString;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-09-23 10:46
 * @description：注解---学生对象信息处理类
 */
@Data
@ToString
public class Student {

    @AnnotationModel
    String name;

    @AnnotationModel
    String sex;


}
