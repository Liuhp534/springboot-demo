package cn.liuhp.pojo;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore
    private Object[] resArgs;


    public Response success(ResponseEnum responseEnum) {
        return this.success(responseEnum, null);
    }

    public Response success(ResponseEnum responseEnum, Object[] resArgs) {
        this.code = responseEnum.getCode();
        //this.msg = responseEnum.getI18nMsg();
        this.resArgs = resArgs;
        return this;
    }

    public Response fail(ResponseEnum responseEnum) {
        return this.fail(responseEnum, null);
    }

    public Response fail(ResponseEnum responseEnum, Object[] resArgs) {
        this.code = responseEnum.getCode();
        //this.msg = responseEnum.getI18nMsg();
        this.resArgs = resArgs;
        return this;
    }

}
