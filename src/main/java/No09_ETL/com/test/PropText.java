package No09_ETL.com.test;

import No09_ETL.com.ws.commone.Constant;
import No09_ETL.com.ws.config.ConfigManger;
import org.junit.Test;

/**
 *
 */
public class PropText {
    /*nginx字段相关参数*/
    @Test
    public void demo01() {
        System.out.println(
                Constant.IS_NGINX_CONTAIN_TITLE +
                        "  |　" +
                        ConfigManger.getStr(Constant.IS_NGINX_CONTAIN_TITLE)
        );

        System.out.println(
                Constant.IS_NGINX_AHEAD_REQUEST_BODY +
                        "  |　" +
                        ConfigManger.getStr(Constant.IS_NGINX_AHEAD_REQUEST_BODY)
        );


        System.out.println(
                Constant.FIELDS_IN_NGINX +
                        "  |　" +
                        ConfigManger.getStr(Constant.FIELDS_IN_NGINX)
        );

        System.out.println(
                Constant.SEP_IN_NGINX +
                        "  |　" +
                        ConfigManger.getStr(Constant.SEP_IN_NGINX)
        );

        System.out.println(
                Constant.SEP_BETWEEN_NGINX_KV +
                        "  |　" +
                        ConfigManger.getStr(Constant.SEP_BETWEEN_NGINX_KV)
        );
    }

    /*requestBody字段相关参数*/
    @Test
    public void demo02() {
        System.out.println(
                Constant.IS_REQUESTBODY_JSON +
                        "  |　" +
                        ConfigManger.getStr(Constant.IS_REQUESTBODY_JSON)
        );

        System.out.println(
                Constant.FIELDS_IN_REQUESTBODY +
                        "  |　" +
                        ConfigManger.getStr(Constant.FIELDS_IN_REQUESTBODY)
        );


        System.out.println(
                Constant.SEP_IN_REQUESTBODY +
                        "  |　" +
                        ConfigManger.getStr(Constant.SEP_IN_REQUESTBODY)
        );

        System.out.println(
                Constant.SEP_BETWEEN_REQUESTBODY_KV +
                        "  |　" +
                        ConfigManger.getStr(Constant.SEP_BETWEEN_REQUESTBODY_KV)
        );
    }

    /*全局分割符正则表达式*/
    @Test
    public void demo03() {
        System.out.println(
                Constant.SEP_IN_ALL_LOG_REGEX +
                        "  |　" +
                        ConfigManger.getStr(Constant.SEP_IN_ALL_LOG_REGEX)
        );

        System.out.println(
                Constant.SEP_BETWEEN_ALL_KV_REGEX +
                        "  |　" +
                        ConfigManger.getStr(Constant.SEP_BETWEEN_ALL_KV_REGEX)
        );
    }

    /*ETL相关参数*/
    @Test
    public void demo04() {
        System.out.println(
                Constant.RESOLVER +
                        "  |　" +
                        ConfigManger.getStr(Constant.RESOLVER)
        );

        System.out.println(
                Constant.FIELDS_AFTER_ETL +
                        "  |　" +
                        ConfigManger.getStr(Constant.FIELDS_AFTER_ETL)
        );
        System.out.println(
                Constant.SEP_AFTER_ETL +
                        "  |　" +
                        ConfigManger.getStr(Constant.SEP_AFTER_ETL)
        );
    }

}

