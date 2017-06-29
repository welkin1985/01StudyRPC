package No01_ThreadStudy.No03_MasterWorker.No02_RPCWorker;

import No01_ThreadStudy.No03_MasterWorker.No01_ThreadWorker.TaskDemo;
import No01_ThreadStudy.No03_MasterWorker.No01_ThreadWorker.WorkerDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 *
 */
@Service
public class MasterDemo {

    //待处理任的务队列
    @Autowired
    private ConcurrentLinkedQueue<TaskDemo> taskQueue ;

    //可用的worker列表
    @Autowired
    private HashMap<WorkerDemo, Thread> workerMap ;

    //反馈的结果集
    @Autowired
    private ConcurrentHashMap<String, Object> resultMap;





}
