package com.test.utils;

import lombok.Data;

/**
 * 返回给前台分页查询的信息
 *
 * @param <T>
 */
@Data
public class TableResultResponse<T> {

    /*
    总页数
     */
    private Long totalRows;

    /*
    查询的数据
     */
    private T list;

    public TableResultResponse() {

    }

    public TableResultResponse(Long totalRows, T list) {
        this.totalRows = totalRows;
        this.list = list;
    }
}
