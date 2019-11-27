package com.test.utils.pager;

import lombok.Data;

import java.util.List;

@Data
public class PagerData {

    private Pager pager;
    private List<?> rows;
    private long totalRows;

    private int pageNum;
    private int pageSize;

    public PagerData(){

    }
    public PagerData(Pager pager, List<?> rows){
        this.pager = pager;
        this.rows = rows;
    }

    public Pager getPager() {
        return pager;
    }

    public void setPager(Pager pager) {
        this.pager = pager;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }

    public long getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(long totalRows) {
        this.totalRows = totalRows;
    }
}
