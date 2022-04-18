package cn.wr.modules.distribution.entity.enums;

public enum DistributionStatusEnum {

    /**
     * 申请中
     */
    APPLY("申请中"),
    /**
     * 已清退
     */
    RETREAT("已清退"),
    /**
     * 审核拒绝
     */
    REFUSE("审核拒绝"),
    /**
     * 审核通过
     */
    PASS("审核通过");

    private final String description;

    DistributionStatusEnum(String description) {
        this.description = description;
    }
}
