package com.tik.mysystem.system.hystrix;

import com.netflix.hystrix.*;
import lombok.extern.slf4j.Slf4j;


@Slf4j
public class RequestCommand extends HystrixCommand<String> {

    private String name;

    private static final int TIME_OUT = 5 * 1000;
    private static final HystrixCommand.Setter setter = Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("RequestGroupKey"))
            .andCommandKey(HystrixCommandKey.Factory.asKey("RequestCommandKey"))
            .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                    .withExecutionTimeoutInMilliseconds(TIME_OUT)
                    //.withExecutionIsolationStrategy(HystrixCommandProperties.ExecutionIsolationStrategy.THREAD)
            )
            .andThreadPoolKey(HystrixThreadPoolKey.Factory.asKey("RequestThreadPool"))
            .andThreadPoolPropertiesDefaults(HystrixThreadPoolProperties.Setter()
                    .withCoreSize(50)
                    .withAllowMaximumSizeToDivergeFromCoreSize(true)
                    .withMaximumSize(50)
                    .withKeepAliveTimeMinutes(1)
                    .withMaxQueueSize(10)
                    // queue 拒绝大小, 即使maxQueueSize没有达到，达到queueSizeRejectionThreshold该值后，请求也会被拒绝。
                    .withQueueSizeRejectionThreshold(10)
            );


    public RequestCommand(String name) {
        super(setter);
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        log.info(Thread.currentThread().getName());
        return "hello，" + name;
    }
}
