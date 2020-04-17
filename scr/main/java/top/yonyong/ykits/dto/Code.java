package top.yonyong.ykits.dto;

/**
 * @Describtion 返回code，禁止继承
 * @Author yonyong
 * @Date 2020/3/3 10:00
 * @Version 1.0.0
 **/
public final class Code {
    /**
     * 禁止实例化
     */
    private Code(){}

    public final static Integer SC_OK_200 = 200;

    public final static Integer SC_INTERNAL_SERVER_ERROR_500 = 500;

    public final static Integer SC_NO_AUTHZ_403 = 403;
}
