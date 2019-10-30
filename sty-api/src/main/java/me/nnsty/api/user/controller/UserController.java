package me.nnsty.api.user.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import me.nnsty.api.user.service.IUserService;
import me.nnsty.common.msg.ResultMsg;
import me.nnsty.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Date;
import java.util.UUID;

/**
 * 用户管理
 * @author admin
 * @create 2018/12/17 17:03
 **/
@Api(tags = "用户管理",value = "用户管理", description = "用户管理接口")
@RequestMapping("/api/user")
@Slf4j
@RestController
public class UserController {

    @Autowired
    private IUserService userService;

    @ApiOperation(value = "用户列表")
    @PostMapping("/list")
    public ResultMsg list(HttpServletRequest request) throws IOException {
        return ResultMsg.ok(userService.getUserList());
    }

    @ApiOperation(value = "用户详情")
    @PostMapping("/detail/{id}")
    public ResultMsg detail(HttpServletRequest request,
                          @ApiParam(value = "用户ID",required = true) @PathVariable Long id) throws IOException {
        log.info(String.valueOf(id));
        return ResultMsg.ok(userService.getUser(id));
    }

    @ApiOperation(value = "新增用户")
    @PostMapping("/addUser")
    public ResultMsg addUser(HttpServletRequest request,
                             @ApiParam(value = "用户名",required = true) @RequestParam(value = "userName") String userName,
                             @ApiParam(value = "密码",required = true) @RequestParam(value = "password") String password,
                             @ApiParam(value = "用户email",required = false) @RequestParam(value = "email") String email,
                             @ApiParam(value = "手机号",required = true) @RequestParam(value = "phone") String phone) throws IOException {
        User user = new User();
        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCreateTime(new Date());
        user.setEnabled(1L);

        return ResultMsg.ok(userService.addUser(user));
    }

    @ApiOperation(value = "编辑用户")
    @PostMapping("/updateUser")
    public ResultMsg updateUser(HttpServletRequest request,
                                @ApiParam(value = "id",required = true) @RequestParam(value = "id") Long id,
                                @ApiParam(value = "用户名",required = true) @RequestParam(value = "userName") String userName,
                                @ApiParam(value = "密码",required = true) @RequestParam(value = "password") String password,
                                @ApiParam(value = "用户email",required = false) @RequestParam(value = "email") String email,
                                @ApiParam(value = "状态：1启用、0禁用",required = true) @RequestParam(value = "enabled") Long enabled,
                                @ApiParam(value = "手机号",required = true) @RequestParam(value = "phone") String phone) throws IOException {
        User user = new User();
        user.setId(id);
        user.setUsername(userName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        user.setCreateTime(new Date());
        user.setEnabled(enabled);

        return ResultMsg.ok(userService.updateUser(user));
    }

    @ApiOperation(value = "删除用户")
    @PostMapping("/delete/{id}")
    public ResultMsg deleteUser(HttpServletRequest request,
                                @ApiParam(value = "用户ID",required = true) @PathVariable Long id) throws IOException {
        return ResultMsg.ok(userService.deleteUser(id));
    }

}
