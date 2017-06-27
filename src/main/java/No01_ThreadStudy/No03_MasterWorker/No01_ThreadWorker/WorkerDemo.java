package No01_ThreadStudy.No03_MasterWorker.No01_ThreadWorker;

import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 */
public class WorkerDemo implements Serializable {

    //待处理任的务队列
    private ConcurrentLinkedQueue<TaskDemo> tasklist = new ConcurrentLinkedQueue<>();

    //反馈的结果集
    private ConcurrentHashMap<String,Object> resultList = new ConcurrentHashMap<>();



}
