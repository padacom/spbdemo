package me.nnsty.common.msg;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author admin
 * @create 2018/12/5 15:05
 **/
@ApiModel(value = "统一封装返回信息", description = "统一封装返回信息")
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResultMsg<T> implements Serializable {

    private static final long serialVersionUID = 710636819736269750L;

    @ApiModelProperty(notes = "状态码")
    private Integer code = 0;
    @ApiModelProperty(value = "信息")
    private String message;
    @ApiModelProperty(value = "数据")
    private T data;

    public static  <T> ResultMsg  <T> error(){
        return error(ResultCode.ERROR, "未知异常，请联系管理员",null);
    }

    public static  <T> ResultMsg  <T> error(String message){
        return error(ResultCode.ERROR, message,null);
    }

    public static  <T> ResultMsg  <T> error(Integer code,String message){
        return error(code, message,null);
    }


    public static  <T> ResultMsg  <T> error(int code,String message,Object object){
        return new ResultMsg(code,message,object);
    }

    public static  <T> ResultMsg  <T> ok(){
        return ok(ResultCode.OK,null,null);
    }

    public static <T> ResultMsg <T> ok(T data){
        return ok(ResultCode.OK , null , data);
    }

    public static  <T> ResultMsg  <T> ok(int code,String message){
        return ok(code,message);
    }

    public static  <T> ResultMsg  <T> ok(int code,String message,T data){
        return new ResultMsg(code,message,data);
    }

}
