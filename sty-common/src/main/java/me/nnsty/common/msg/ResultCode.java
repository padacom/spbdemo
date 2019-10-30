package me.nnsty.common.msg;

/**
 * @author admin
 * @create 2018/12/12 14:30
 **/
public class ResultCode {
    /**
     * 服务异常
     */
    public static final int ERROR = -1;
    /**
     * 请求成功
     */
    public static final int OK = 0;

    /**
     * 拒绝访问(权限拦截)
     */
    public static final int HTTP_FORBIDDEN = 401;
}
