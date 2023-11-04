package com.rx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 统一响应结果封装类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code ;//1 成功 , 0 失败
    private String msg; //提示信息
    private Object data; //数据 date

    //增删改 成功响应
    public static Result success(){
        return new Result(1,"success",null);
    }

    //查询 成功响应
    public static Result success(Object data){
        return new Result(1,"success",data);
    }

    //失败响应
    public static Result error(String msg){
        return new Result(0,msg,null);
    }
}
