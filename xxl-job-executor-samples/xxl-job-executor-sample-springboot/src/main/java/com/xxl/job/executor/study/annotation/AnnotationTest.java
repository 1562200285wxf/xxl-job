package com.xxl.job.executor.study.annotation;

import java.lang.reflect.Field;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-09-23 10:52
 * @description：自测注解类
 */
public class AnnotationTest {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Student student = new Student();
        Class<Student> studentClass = Student.class;
        Field studentField = studentClass.getDeclaredField("name");
        if(studentField.getAnnotationsByType(AnnotationModel.class) != null){
            studentField.setAccessible(true);
            studentField.set(student,"名称");
        }
        System.out.println(student.toString());

    }
}
