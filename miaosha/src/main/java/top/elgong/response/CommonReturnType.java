package top.elgong.response;

public class CommonReturnType {

    // 表名 对应请求的处理结果  success, fail
    private String status;

    // 若 success， 则data 返回给前端的数据
    // 若fail， 则返回通用错误码
    private Object data;

    /* 定义一个通用的创建方法 */
    public static CommonReturnType create(Object result){

        return CommonReturnType.create(result,"success");
    }

    public static CommonReturnType create(Object result, String status) {
        CommonReturnType type = new CommonReturnType();
        type.setStatus(status);
        type.setData(result);

        return type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
