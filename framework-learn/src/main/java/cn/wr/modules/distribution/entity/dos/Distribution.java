package cn.wr.modules.distribution.entity.dos;

import cn.wr.modules.distribution.entity.dto.DistributionApplyDTO;
import cn.wr.modules.distribution.entity.enums.DistributionStatusEnum;
import cn.wr.mybatis.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @author RWang
 * @Date 2022/4/18
 */

@Data
@ApiModel(value = "分销员")
@TableName("li_distribution")
@NoArgsConstructor
public class Distribution extends BaseEntity {

    private static final long serialVersionUID = -3290549525653737289L;

    public  Distribution(String memberId, String memberName, DistributionApplyDTO distributionApplyDTO){
        this.memberId = memberId;
        this.memberName = memberName;
        distributionOrderCount=0;
        this.distributionStatus = DistributionStatusEnum.APPLY.name();

    }

    private String memberId;
    private String memberName;
    private String name;
    private String idNumber;
    private Double rebateTotal;

    @ApiModelProperty(value = "可提现金额")
    private Double canRebate = 0D;

    @ApiModelProperty(value = "冻结金额")
    private Double commissionFrozen = 0D;

    @ApiModelProperty(value = "分销订单数")
    private Integer distributionOrderCount;

    /**
     * @see
     */
    @ApiModelProperty(value = "分销员状态", required = true)
    private String distributionStatus;

    @Length(min = 1, max = 200, message = "结算银行开户行名称长度为1-200位")
    @NotBlank(message = "结算银行开户行名称不能为空")
    @ApiModelProperty(value = "结算银行开户行名称")
    private String settlementBankAccountName;

    @Length(min = 1, max = 200, message = "结算银行开户账号长度为1-200位")
    @NotBlank(message = "结算银行开户账号不能为空")
    @ApiModelProperty(value = "结算银行开户账号")
    private String settlementBankAccountNum;

    @Length(min = 1, max = 200, message = "结算银行开户支行名称长度为1-200位")
    @NotBlank(message = "结算银行开户支行名称不能为空")
    @ApiModelProperty(value = "结算银行开户支行名称")
    private String settlementBankBranchName;


}
