package com.example.demo.thread.reentrantLockTest;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

// debug reentrantLock 会不会走到抛出一场类的方法里面去
public class ReentrantLockTest {

    public static void main(String[] args) {

        Lock lock = new ReentrantLock();

        try {
            // 获取锁 这里默认走到了非公平锁里面去，原因不详
            lock.lock();

            // 试试lock 完之后再lock 是什么效果
            /**
             * 再上面已经获得了锁的情况下，下面再进行lock，这里compareAndSetState(0, 1)，这里evaluate了一下，直接是false,就是说，其实这里的队列state已经变了，不给你用了，
             * 我猜接下来会到那个公平锁里面去，抛异常，然后finally unlock();
             *
             * 然后到了aqs里面的 acquire(1)里面，尝试获得锁
             *     protected boolean tryAcquire(int arg) {
             *         throw new UnsupportedOperationException();
             *     }
             *     这里为啥不抛出个异常，而是返回个true呀，难受
             */
            // 测试过程中，尝试去掉这个lock和加上这个lock ，康一康具体的执行路径如何
//            lock.lock();
            /**
             *  lock.lock() 源码分析
             *  Lock 接口 有lock()、unlock() 、lockInterruptibly() 、tryLock() 、tryLock(long time, TimeUnit unit)、newCondition（）
             *  然后是 ReentrantLock 实现lock方法 ， 有个抽象静态内部类 ： Sync extends AbstractQueuedSynchronizer ，继承了aqs(双向队列）
             *  sync.lock(); // 这里有个抽象方法lock ,由抽象静态内部类实现===》 static final class NonfairSync extends Sync
             *  这里默认的就直接是非公平的实现，咱也不知道为啥 ，NonfairSync.lock()
             *   这里就开始自旋拿锁了，compareAndSetState(0, 1)，这里evaluate了一下，直接是true
             *   然后，就开始加锁了，setExclusiveOwnerThread(Thread.currentThread()) // 看着英文意思是说设置排他锁？
             *   就把当前线程给了 排他线程==》         exclusiveOwnerThread = thread;
             *       private transient Thread exclusiveOwnerThread; 这玩意是个啥，排他模式当前线程的拥有者？
             *
             */
        }finally {
            /**
             *  行了，行了，lock() 想不明白就慢慢想吧，到了unlock()了
             *  自然地，第一步就是到Lock接口里面的unlock()方法呗
             *  蓝后，是抽象静态内部类里面的        sync.release(1); // 这是干啥，行吧，行吧 release(1)
             *  直接到了 aqs里面的    protected boolean tryRelease(int arg) {
             *         throw new UnsupportedOperationException();
             *     }
             *
             *     行行行，又整一个抛异常的方法是吧
             *
             *     爸爸我二话不说，Evaluate tryRelease(1) // 啥玩意，直接给了个false
             *     继续猜，是不是爷lock了两次，丫的state不正常了，去掉一个试试
             *     靠靠靠，爷去掉了，又重新 Evaluate tryRelease(1) ,给爷返回了true ,优秀
             *     继续，呵呵，控制台：
             *     Exception in thread "main" java.lang.IllegalMonitorStateException
             * 	at java.util.concurrent.locks.ReentrantLock$Sync.tryRelease(ReentrantLock.java:151)
             * 	at java.util.concurrent.locks.AbstractQueuedSynchronizer.release(AbstractQueuedSynchronizer.java:1261)
             * 	at java.util.concurrent.locks.ReentrantLock.unlock(ReentrantLock.java:457)
             * 	at com.example.demo.thread.reentrantLockTest.ReentrantLockTest.main(ReentrantLockTest.java:56)
             *
             * 	这里讲一下，因为断点进去看的，Evaluate tryRelease(1) 一次，然后，程序正常的断点后进入，又执行了一次tryRelease(1)方法，
             * 	所以这里才有了上面的那个异常
             *
             * 	这里会判断，Thread.currentThread() != getExclusiveOwnerThread() ，当前线程是不是目标线程，啥意思的，
             * 	就是说： 期待某个线程来修改我的状态，我期待的那个线程来了呢，那就给他改，如果你不是那个他，不好意思，我不给你改呢
             * 	不给改呢就是，上面那一堆的Exception
             *
             * 	这里呢，正常情况就是，当前的线程去unlock() ,那就给你unlock，改aqs里面的state=0;
             *
             * 	你瞅瞅这个state =>     private volatile int state; // volatile修饰，线程可见，禁止指令冲排序，优秀
             * 	然后，把这个排他线程置为空了，23333
             * 	exclusiveOwnerThread = null
             * 	就算是放掉了锁
             *
             * 	里面其实，我还看到了park和unpark ，待补充进去吧
             *
             */
            lock.unlock();
        }
    }


}
