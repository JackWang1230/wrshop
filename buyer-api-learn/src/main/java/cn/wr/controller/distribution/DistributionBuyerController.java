package cn.wr.controller.distribution;

import cn.wr.modules.distribution.service.DistributionService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author RWang
 * @Date 2022/4/18
 */

@RestController
@Api(tags = "买家端，分销员接口")
@RequestMapping("/buyer/distribution/distribution")
public class DistributionBuyerController {

    @Autowired
    private DistributionService distributionService;
}
