package No01_ThreadStudy.No03_MasterWorker.No01_ThreadWorker;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 */
public class MasterDemo {

    //待处理任的务队列
    private ConcurrentLinkedQueue<TaskDemo> taskQueue = new ConcurrentLinkedQueue<>();

    //可用的worker列表
    private HashMap<WorkerDemo, Thread> workerMap = new HashMap<WorkerDemo, Thread>();

    //反馈的结果集
    private ConcurrentHashMap<String, Object> resultMap = new ConcurrentHashMap<>();


}
