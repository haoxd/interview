package com.bread.coalquality.mvc.dto;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @Description:
 * @Author: haoxd
 * @Version: 1.0
 */
@Data
@ToString
public class UserDTO {




    @NotBlank(message = "名字不可为空")
    @Length(min = 2 ,max = 6 ,message = "名字为2-6位")
    private String userName;

    @NotBlank(message = "密码不可为空")
    @Length(min = 8 ,max = 14 ,message = "密码位8-14位")
    private String passWord;
}
