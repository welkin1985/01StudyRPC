package No09_ETL.com.ws.commone;

/**
 *
 */
public class Constant {
    /*nginx字段相关参数*/
    final public static String IS_NGINX_CONTAIN_TITLE = "format.nginx.field.contain.title.boolean";
    final public static String IS_NGINX_AHEAD_REQUEST_BODY = "format.nginx.field.ahead.requestBody.boolean";
    final public static String FIELDS_IN_NGINX = "fields.in.org.log.nginx";
    final public static String SEP_IN_NGINX = "sep.in.org.log.nginx.field";
    final public static String SEP_BETWEEN_NGINX_KV = "sep.between.nginx.field.keyValue";
    /*requestBody字段相关参数*/

    final public static String IS_REQUESTBODY_JSON = "format.requestBody.isJSON.boolean";
    final public static String FIELDS_IN_REQUESTBODY = "fields.in.org.log.requestBody";
    final public static String SEP_IN_REQUESTBODY = "sep.in.org.log.requestBody.field";
    final public static String SEP_BETWEEN_REQUESTBODY_KV = "sep.between.requestBody.field.keyValue";
    /*全局分割符正则表达式*/
    final public static String SEP_IN_ALL_LOG_REGEX = "sep.in.all.log.regex";
    final public static String SEP_BETWEEN_ALL_KV_REGEX = "sep.between.all.keyValue.regex";

    /*ETL相关参数*/
    final public static String RESOLVERS = "org.log.resolvers";
    final public static String FIELDS_AFTER_ETL = "etl.log.fields.sequence";
    final public static String SEP_AFTER_ETL = "sep.in.etl.fields.sequence";

}
