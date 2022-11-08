package org.lakers.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created on 2022/11/3 13:44
 *
 * @author lakers
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    @ApiModelProperty(value = "用户名")
    @NotBlank(message = "用户名不能为空！")
    private String userName;

    private String nickname;

    @ApiModelProperty(value = "密码")
    @NotBlank(message = "密码不能为空！")
    private String password;

    private String status;

    private String email;

    private String phoneNumber;

    private String sex;

    private String avatar;

    private String userType;

    private Long createBy;

    private LocalDateTime createTime;

    private Long updateBy;

    private Integer delFlag;
}
