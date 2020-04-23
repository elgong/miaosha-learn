package top.elgong.error;

public interface CommonError {

    int getErrorCode();

    String getErrorMsg();

    CommonError setErrorMsg(String Msg);

}
