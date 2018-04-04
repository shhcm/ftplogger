package com.shhcm.ftp;

import org.apache.ftpserver.FtpServer;
import org.apache.ftpserver.FtpServerFactory;
import org.apache.ftpserver.ftplet.Ftplet;
import org.apache.ftpserver.listener.Listener;
import org.apache.ftpserver.listener.ListenerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.Map;


@SpringBootApplication
public class SpringBootConsoleApplication implements CommandLineRunner {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public static void main(String[] args) throws Exception {

        SpringApplication.run(SpringBootConsoleApplication.class, args);

    }

    //access command line arguments
    @Override
    public void run(String... args) throws Exception {
        FtpServerFactory serverFactory = new FtpServerFactory();
        addLoggerFtplet(serverFactory);

        addListenerForPort(serverFactory, 1025); // High port, port < 1024 not allowed for non-sudoer.
        FtpServer server = serverFactory.createServer();
        server.start();
    }

    private void addListenerForPort(FtpServerFactory serverFactory, int port) {
        ListenerFactory listenerFactory = new ListenerFactory();
        listenerFactory.setPort(port);
        Listener listener = listenerFactory.createListener();
        serverFactory.addListener("default", listener);
    }

    private void addLoggerFtplet(FtpServerFactory serverFactory) {
        Map<String, Ftplet> ftplets = new HashMap<String, Ftplet>();
        ftplets.put("loggerFtplet", new FtpLoggerFtplet());
        serverFactory.setFtplets(ftplets);
    }
}