package com.duruijuan.utils;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;

/**
 * @projectName: food
 * @package: com.duruijuan.utils
 * @className: JsonResult
 * @author: duruijuan
 * @description:
 * 自定义响应数据结构
 *  * 				本类可提供给 H5/ios/安卓/公众号/小程序 使用
 *  * 				前端接受此类数据（json object)后，可自行根据业务去实现相关功能
 *  * 				200：表示成功
 *  * 				500：表示错误，错误信息在msg字段中
 *  * 				501：bean验证错误，不管多少个错误都以map形式返回
 *  * 				502：拦截器拦截到用户token出错
 *  * 				555：异常抛出信息
 *  * 				556: 用户qq校验异常
 * @since: 2024-01-16 18:26
 * @version: 1.0
 */
@Data
public class JsonResult {
    // 定义jackson对象
    private static final ObjectMapper MAPPER = new ObjectMapper();

    // 响应业务状态
    private Integer status;

    // 响应消息
    private String msg;

    // 响应中的数据
    private Object data;

    // 不使用
    @JsonIgnore
    private String ok;

    public static JsonResult build(Integer status, String msg, Object data) {
        return new JsonResult(status, msg, data);
    }

    public static JsonResult build(Integer status, String msg, Object data, String ok) {
        return new JsonResult(status, msg, data, ok);
    }

    public static JsonResult ok(Object data) {
        return new JsonResult(data);
    }

    public static JsonResult ok() {
        return new JsonResult(null);
    }

    public static JsonResult errorMsg(String msg) {
        return new JsonResult(500, msg, null);
    }

    public static JsonResult errorMap(Object data) {
        return new JsonResult(501, "error", data);
    }

    public static JsonResult errorTokenMsg(String msg) {
        return new JsonResult(502, msg, null);
    }

    public static JsonResult errorException(String msg) {
        return new JsonResult(555, msg, null);
    }

    public static JsonResult errorUserQQ(String msg) {
        return new JsonResult(556, msg, null);
    }

    public JsonResult() {

    }

    public JsonResult(Integer status, String msg, Object data) {
        this.status = status;
        this.msg = msg;
        this.data = data;
    }

    public JsonResult(Integer status, String msg, Object data, String ok) {
        this.status = status;
        this.msg = msg;
        this.data = data;
        this.ok = ok;
    }

    public JsonResult(Object data) {
        this.status = 200;
        this.msg = "OK";
        this.data = data;
    }

    public Boolean isOK() {
        return this.status == 200;
    }

}
