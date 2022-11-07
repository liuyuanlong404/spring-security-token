package org.lakers.common;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * Created on 2022/11/7 16:25
 *
 * @author lakers
 */
@Data
public class UserVo {
    private Long id;

    private String userName;

    private String nickname;

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
