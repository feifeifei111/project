package com.zf.util;


public class DoPaging {

    public static int getTotalPages(int pageSize,int totalRows){
        int totalPages = totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
        //�������������ҳ�������þ�����ҳ���͵����̣���������ҳ���͵������ټ���1��
        return  totalPages;
    }
}
