package com.test.utils.pager;

public class Pager {
    private int pageNum;
    private int pageSize;
    private int start;

    public int getPageNum() {
        if(pageNum<1)
            pageNum = 1;
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        if(pageSize == 0)
            pageSize  = 10;
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getStart() {
        return (getPageNum()-1) * getPageSize();
    }

    public void setStart(int start) {
        this.start = start;
    }

}
