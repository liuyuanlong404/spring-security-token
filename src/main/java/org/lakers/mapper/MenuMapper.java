package org.lakers.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lakers.domain.Menu;

import java.util.List;

/**
 * Created on 2022/11/3 14:04
 * @author lakers
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {

    List<String> selectPermsByUserId(@Param("id") Long id);
}
