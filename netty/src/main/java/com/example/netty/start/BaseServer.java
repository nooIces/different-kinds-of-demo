package com.example.netty.start;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class BaseServer implements CommandLineRunner {

    private static final Logger logger = LoggerFactory.getLogger(BaseServer.class);

    @Resource
    private NettyServer nettyServer;

    @Override
    public void run(String... args) throws Exception {
        logger.info("netty server start...");
        nettyServer.start();
    }
}
