package com.zf.util;


public class DoPaging {

    public static int getTotalPages(int pageSize,int totalRows){
        int totalPages = totalRows%pageSize==0?totalRows/pageSize:totalRows/pageSize+1;
        //如果总行数除以页容量除得尽，总页数就等于商；除不尽，页数就等于商再加上1；
        return  totalPages;
    }
}
