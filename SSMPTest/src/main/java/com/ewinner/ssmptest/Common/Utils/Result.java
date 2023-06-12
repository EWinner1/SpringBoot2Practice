package com.ewinner.ssmptest.Common.Utils;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.ibatis.annotations.ConstructorArgs;

@Data
@AllArgsConstructor
public class Result {
    private Boolean flag;
    private Object data;
}
