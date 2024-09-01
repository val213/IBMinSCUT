package com.example.backend.pojo;

import lombok.Getter;

@Getter
public class Result{
    private Integer code;
    private String msg;
    private Object data;
    public Result(){};
    public Result(Integer code,String msg,Object data){
        this.code=code;
        this.msg=msg;
        this.data=data;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setData(Object data) {
        this.data = data;
    }
 
    //定义静态方法 帮助我们快速构造result对象
    public static Result success(Object data){
        return new Result(1,"success",data);
    }
 
    public static Result success(){
        return new Result(1,"success",null);
    }
 
    public static Result success(String msg){
        return new Result(1,msg,null);
    }
}
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
