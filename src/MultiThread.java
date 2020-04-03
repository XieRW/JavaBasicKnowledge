import java.lang.management.ManagementFactory;
import java.lang.management.ThreadInfo;
import java.lang.management.ThreadMXBean;

/**
 * 测试JMX获取线程示例
 * @author XieRW
 * @email 1429382875@qq.com
 * @date 2020-03-15
 */
public class MultiThread {
    public static void main(String[] args){
        // 获取 Java 线程管理 MXBean
        ThreadMXBean threadMXBean = ManagementFactory.getThreadMXBean();
        // 不需要获取同步的 monitor 和 synchronizer 信息，仅获取线程和线程堆栈信息
        ThreadInfo[] threadInfos = threadMXBean.dumpAllThreads(false, false);
        // 遍历线程信息，仅打印线程 ID 和线程名称信息
        for (ThreadInfo threadInfo : threadInfos) {
            System.out.println("[" + threadInfo.getThreadId() + "] " + threadInfo.getThreadName());
        }
        ThreadMXBean threadMXBean1 = ManagementFactory.getThreadMXBean();
        ThreadInfo[] threadInfos1 = threadMXBean1.dumpAllThreads(false,false);
        for (ThreadInfo threadInfo:threadInfos1){
            System.out.println("["+threadInfo.getThreadId()+"] "+threadInfo.getThreadName()+ " "+threadInfo.getThreadState() );
        }
    }
}
