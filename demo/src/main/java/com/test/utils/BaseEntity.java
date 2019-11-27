package com.test.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class BaseEntity {

    private Integer crtUserId;

    private Integer crtUserName;

    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT-8")
    private Date crtTime;

    private Integer updUserId;

    private Integer updUserName;

    @JsonFormat(pattern = "yyyy-MM-dd", locale = "zh", timezone = "GMT-8")
    private Date updTime;

    public BaseEntity() {
        this.setCrtTime(new Date());
    }
}
