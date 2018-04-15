package com.serviceinfotech;

import com.serviceinfotech.config.ApplicationConfiguration;
import com.serviceinfotech.service.UpdateService;
import com.serviceinfotech.util.RejectionHandler;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {ApplicationConfiguration.class,TestApplicationConfiguration.class})
public class ThreadPoolExecutorTest {

    @Autowired
    UpdateService updateService;

    @Autowired
    ThreadPoolExecutor testTaskExecutor;

    @Autowired
    AsyncTaskExecutor taskExecutor;

    @Mock
    RejectionHandler rejectionHandler;

    @Captor
    ArgumentCaptor argCaptor;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void shouldSubmitAndCompleteTwoTasksWithExecutorService() throws Exception {


        fireUpdateServiceUpdateWithExecutorService(30);


    }

    @Test
    public void shouldSubmitAndCompleteTwoTasksWithTaskExecutor() throws Exception {
        fireUpdateServiceUpdateWithTaskExecutor(30);



    }

    private void fireUpdateServiceUpdateWithTaskExecutor(int times) {
        for (int i = 0; i < times; i++) {
            testTaskExecutor.execute((new Runnable() {
                @Override
                public void run() {
                        updateService.update();

                }
            }));
        }
        Assert.assertEquals(testTaskExecutor.getCompletedTaskCount(),3l);
        testTaskExecutor.shutdown();


    }

    private void fireUpdateServiceUpdateWithExecutorService(int times) throws InterruptedException {
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(
                2,
                30,
                120,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        List<Callable<ParentWorker>> tasks = new ArrayList<>();
        for (int i = 0; i < times; i++) {

            tasks.add((Callable<ParentWorker>) new ParentWorkerCallable(taskExecutor));

        }
        threadPool.invokeAll(tasks);
        long completedTaskCount = threadPool.getCompletedTaskCount();
       Assert.assertEquals(completedTaskCount,30l);
        threadPool.shutdown();
    }

}
