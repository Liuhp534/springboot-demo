package cn.liuhp.pojo;

import lombok.Data;

/**
 * @description:
 * @author: liuhp534
 * @create: 2020-08-15 19:21
 */
@Data
public class Response {

    private String code;

    private String msg;

    private Object data;


    public Response success(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
        return this;
    }

    public Response fail(ResponseEnum responseEnum) {
        this.code = responseEnum.getCode();
        this.msg = responseEnum.getMsg();
        return this;
    }

}
