package producer.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@Api(description = "健康检查服务主入口")
@RequestMapping("/health")
public class HelloController {

    @ApiOperation(value = "健康检查接口")
    @RequestMapping(value = "status",method = RequestMethod.POST)
    public String health() {
        return "OK";
    }
}
