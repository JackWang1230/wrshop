package cn.wr.mybatis;

import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author RWang
 * @Date 2022/4/18
 */

@Data
@JsonIgnoreProperties(value = {"handler","fieldHandler"})
@AllArgsConstructor //使用后添加一个构造函数，该构造函数含有所有已声明字段属性参数
@NoArgsConstructor // 使用后创建一个无参构造函数
public class BaseIdEntity implements Serializable {

    private static final long serialVersionUID = 6141339289315569422L;

    @TableId // 该注解用于将某个成员变量指定为数据表主键
    @ApiModelProperty(value = "唯一标识",hidden = true)
    private String id;
}
