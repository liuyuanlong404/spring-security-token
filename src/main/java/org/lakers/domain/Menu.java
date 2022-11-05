package org.lakers.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Created on 2022/11/4 13:38
 *
 * @author lakers
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName(value = "sys_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private Long id;

    private String menuName;

    private String path;

    private String component;

    private Integer status;

    private Integer visible;

    private String perms;

    private String icon;
}
