package top.yonyong.ykits.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author yonyong
 * @Description //接口返回数据格式
 * @Date 2020/3/3 10:01
 * @Version 1.0.0
 **/
@Data
public class YResult<T> implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 成功标志
	 */
	private boolean success = true;

	/**
	 * 返回处理消息
	 */
	private String message = "操作成功！";

	/**
	 * 返回代码
	 */
	private Integer code = 0;
	
	/**
	 * 返回数据对象 data
	 */
	private T result;
	
	/**
	 * 时间戳
	 */
	private long timestamp = System.currentTimeMillis();

	public YResult() {
		
	}
	
	public YResult<T> success(String message) {
		this.message = message;
		this.code = Code.SC_OK_200;
		this.success = true;
		return this;
	}
	
	
	public static YResult<Object> ok() {
		YResult<Object> r = new YResult<Object>();
		r.setSuccess(true);
		r.setCode(Code.SC_OK_200);
		r.setMessage("成功");
		return r;
	}
	
	public static YResult<Object> ok(String msg) {
		YResult<Object> r = new YResult<Object>();
		r.setSuccess(true);
		r.setCode(Code.SC_OK_200);
		r.setMessage(msg);
		return r;
	}
	
	public static YResult<Object> ok(Object data) {
		YResult<Object> r = new YResult<Object>();
		r.setSuccess(true);
		r.setCode(Code.SC_OK_200);
		r.setResult(data);
		return r;
	}
	
	public static YResult<Object> error(String msg) {
		return error(Code.SC_INTERNAL_SERVER_ERROR_500, msg);
	}

	public static YResult<Object> error() {
		return error(Code.SC_INTERNAL_SERVER_ERROR_500, "操作失败");
	}
	
	public static YResult<Object> error(int code, String msg) {
		YResult<Object> r = new YResult<Object>();
		r.setCode(code);
		r.setMessage(msg);
		r.setSuccess(false);
		return r;
	}

	public YResult<T> error500(String message) {
		this.message = message;
		this.code = Code.SC_INTERNAL_SERVER_ERROR_500;
		this.success = false;
		return this;
	}
	/**
	 * 无权限访问返回结果
	 */
	public static YResult<Object> noauth(String msg) {
		return error(Code.SC_NO_AUTHZ_403, msg);
	}
}