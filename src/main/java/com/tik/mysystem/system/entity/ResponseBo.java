package com.tik.mysystem.system.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseBo<T> {

    private T data;
    private String msg;
    private Integer code;

    public static ResponseBo ok() {
        ResponseBo result = new ResponseBo();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        return result;
    }

    /**
     * 成功且带数据
     **/
    public static ResponseBo success(Object object) {
        ResponseBo result = new ResponseBo();
        result.setCode(ResultEnum.SUCCESS.getCode());
        result.setMsg(ResultEnum.SUCCESS.getMsg());
        result.setData(object);
        return result;
    }

    /**
     * 成功但不带数据
     **/
    public static ResponseBo success() {

        return success(null);
    }

    /**
     * 失败
     **/
    public static ResponseBo error(Integer code, String msg) {
        ResponseBo result = new ResponseBo();
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }

    public static ResponseBo error(String msg) {
        ResponseBo result = new ResponseBo();
        result.setMsg(msg);
        result.setCode(ResultEnum.UNKNOWN_ERROR.code);
        return result;
    }


    @Getter
    @AllArgsConstructor
    @NoArgsConstructor
    public enum ResultEnum {

        //这里是可以自己定义的，方便与前端交互即可
        UNKNOWN_ERROR(-1, "未知错误"),
        SUCCESS(200, "成功"),
        SERVER_INTERNAL_ERROR(500, "服务器内部错误"),
        RESOURCE_NOT_FOUND(404, "资源未找到"),
        PARAMETER_NOT_VALID(400, "参数不合法"),
        ;
        private Integer code;
        private String msg;
    }
}
