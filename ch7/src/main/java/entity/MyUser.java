package entity;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;

@Data
@TableName("user")
public class MyUser extends Model<MyUser> {
    @TableId(value="uid", type= IdType.AUTO)
    private Integer uid;
    private String uname;
    private String user;
}