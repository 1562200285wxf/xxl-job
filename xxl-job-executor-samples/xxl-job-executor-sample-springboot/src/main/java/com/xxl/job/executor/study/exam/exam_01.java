package com.xxl.job.executor.study.exam;

/**
 * @author ：wang xiaofeng
 * @date ：Created in 2022-12-06 14:28
 * @description：分割字串-并将大小写进行转换
 */
public class exam_01 {
    public static void main(String[] args) {
        int k = 3;
        String string = "12abc-abCABc-4aB@";
        StringBuilder result = new StringBuilder();
        String[] strings = string.split("-");
        result.append(strings[0]);
        for (int i = 1; i < strings.length; i++) {
            int count = strings[i].length()/k;
            int remain = strings[i].length()%k;
            for (int j = 0; j < count; j++) {
                result.append("-");
                int index = k*j;
                result.append(reverse(strings[i].substring(index,index+k)));
            }
            if(remain!=0){
                result.append("-");
                result.append(reverse(strings[i].substring(strings[i].length()-remain)));
            }

            System.out.println(result.toString());
        }
    }

    private static String reverse(String str){
       char[] chars =  str.toCharArray();
       int lowInt = 0;
       int upInt = 0;
        for (char aChar : chars) {
            if(aChar>='a' && aChar<='z'){
                lowInt++;
            }
            else if(aChar>='A' && aChar<='Z'){
                upInt++;
            }
        }
        if(lowInt>upInt){
            return str.toLowerCase();
        }else if(lowInt<upInt)
            return str.toUpperCase();
        else return str;
    }
}
