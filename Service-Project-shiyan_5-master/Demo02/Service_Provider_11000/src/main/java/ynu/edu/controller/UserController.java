package ynu.edu.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ynu.edu.entity.CommonResult;
import ynu.edu.entity.User;

@RestController
@RequestMapping("/user")
@RefreshScope
public class UserController {
    //获取配置信息中的name属性值
    @Value("${msg}")
    private String msg;
    @GetMapping("/getUserById/{userId}")
    public CommonResult<User> getUserById(@PathVariable("userId") Integer userId) {
        CommonResult<User> result = new CommonResult<>();
        Integer code = 200;
        String message = "success(11000)";
        try {
            User u = new User(userId, "小明", "123456");
            result.setResult(u);
        } catch (Exception e) {
            code = 500;
            message = "failed";
        }
        result.setMessage(message);
        result.setCode(code);
        return result;
    }
}
