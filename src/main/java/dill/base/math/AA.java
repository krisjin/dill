package dill.base.math;

/**
 * User: krisjin
 * Date: 2021/9/17
 */
public class AA {
    static String msg = "549878#4_task#run###{\"cycle\":\"2021-09-16\",\"scheTime\":1631853960000,\"logId\":506738321,\"runType\":\"normal\",\"runTime\":1631853968540,\"taskInstId\":3422245172507836418,\"taskName\":\"exe_fdm_fms_fspcube_request_maintain_chain\"}, offset = 1289612121";

    public static void main(String[] args) {
        if (msg == null) {
            return;
        }

        String taskId = null;
        String taskStatus = "success";
        String taskInsId;
        String taskName;
        String[] msgArr = msg.split("#");
        if (msgArr.length >= 3) {
            taskId = msgArr[0];
            taskStatus = msgArr[2];
        }
        System.err.println(taskId + "--" + taskStatus);


    }
}
