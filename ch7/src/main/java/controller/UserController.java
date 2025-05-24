package controller;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import entity.MyUser;
import mapper.UserMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

    // 查询所有用户（直接通过Mapper）
    @GetMapping("/getAll")
    public List<MyUser> getAll() {
        return userMapper.selectList(null);
    }

    // 查询所有用户（通过Service层）
    @GetMapping("/listAll")
    public List<MyUser> listAll() {
        return userService.list();
    }

    // 分页查询用户
    @GetMapping("/page")
    public IPage<MyUser> page(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        Page<MyUser> page = new Page<>(pageNum, pageSize);
        return userService.page(page);
    }

    // 根据ID查询用户
    @GetMapping("/get/{id}")
    public MyUser getById(@PathVariable Integer id) {
        return userService.getById(id);
    }

    // 添加用户
    @PostMapping("/add")
    public boolean addUser(@RequestBody MyUser user) {
        return userService.save(user);
    }

    // 更新用户
    @PutMapping("/update")
    public boolean updateUser(@RequestBody MyUser user) {
        return userService.updateById(user);
    }

    // 删除用户
    @DeleteMapping("/delete/{id}")
    public boolean deleteUser(@PathVariable Integer id) {
        return userService.removeById(id);
    }

    // 条件查询示例（根据用户名模糊查询）
    @GetMapping("/search")
    public List<MyUser> searchByUsername(@RequestParam String username) {
        QueryWrapper<MyUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("uname", username);
        return userService.list(queryWrapper);
    }

    // 复杂查询示例（分页+条件）
    @GetMapping("/complex")
    public IPage<MyUser> complexQuery(
            @RequestParam(required = false) String username,
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize
    ) {
        Page<MyUser> page = new Page<>(pageNum, pageSize);
        QueryWrapper<MyUser> queryWrapper = new QueryWrapper<>();

        if (username != null && !username.isEmpty()) {
            queryWrapper.like("uname", username);
        }

        return userService.page(page, queryWrapper);
    }
}