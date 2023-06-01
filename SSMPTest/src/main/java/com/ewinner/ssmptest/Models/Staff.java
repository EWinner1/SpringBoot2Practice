package com.ewinner.ssmptest.Models;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class Staff {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String sex;
    private String staffLevel;
    private String description;
}
