package service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import entity.MyUser;
import mapper.UserMapper;
import org.springframework.stereotype.Service;
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, MyUser> implements UserService {
}
