package me.nnsty.database.entity;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotations.Version;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author ly
 * @since 2019-10-30
 */
@Data
@Accessors(chain = true)
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    /**
     * ID
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 头像
     */
    @TableField("avatar_id")
    private Long avatarId;
    /**
     * 创建日期
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 状态：1启用、0禁用
     */
    private Long enabled;
    /**
     * 密码
     */
    private String password;
    /**
     * 用户名
     */
    private String username;
    /**
     * 最后修改密码的日期
     */
    @TableField("last_password_reset_time")
    private Date lastPasswordResetTime;
    @TableField("dept_id")
    private Long deptId;
    private String phone;
    @TableField("job_id")
    private Long jobId;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
