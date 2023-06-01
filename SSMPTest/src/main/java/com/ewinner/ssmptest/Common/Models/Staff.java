package com.ewinner.ssmptest.Common.Models;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Staff {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String sex;
    private Integer staffLevel;
    private String description;
}
