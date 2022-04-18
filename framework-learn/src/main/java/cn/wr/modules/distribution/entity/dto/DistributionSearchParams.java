package cn.wr.modules.distribution.entity.dto;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

/**
 * @author RWang
 * @Date 2022/4/18
 */

@Data
public class DistributionSearchParams {

    @ApiModelProperty(value = "会员名称")
    private String memberName;

    @ApiModelProperty(value = "分销员状态",allowableValues = "APPLY,RESTART,REFUSE,PASS")
    private String distributionStatus;

    public <T>QueryWrapper<T> queryWrapper(){

        QueryWrapper<T> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.isNotBlank(memberName),"member_name",memberName);
        queryWrapper.eq(StringUtils.isNotEmpty(distributionStatus), "distribution_status", distributionStatus);
        return queryWrapper;


    }
}
