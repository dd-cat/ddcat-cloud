package com.ddcat.entity.dict;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author dd-cat
 */
@Data
public class DictDTO {

    private Long id;
    /**
     * 类型
     */
    @Length(max = 20, message = "类型长度为[1-20]")
    @NotBlank(message = "类型必填")
    private String type;
    /**
     * 名称
     */
    @Length(max = 20, message = "名称长度为[1-20]")
    @NotBlank(message = "名称必填")
    private String name;
}
