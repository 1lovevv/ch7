package mapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import entity.MyUser;
import org.springframework.stereotype.Repository;
@Repository
public interface UserMapper extends BaseMapper<MyUser> {

}
