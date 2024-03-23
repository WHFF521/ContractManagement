package com.countervalorantapex.contractmanagement.sys.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@TableName("files")
@ApiModel(value = "files对象", description = "")
public class Files {
    private String fileName;
    private String originName;
    private String type;
    private Long size;
    private String url;
}
