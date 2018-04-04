package com.shhcm.ftp;

import org.apache.ftpserver.ftplet.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;

public class FtpLoggerFtplet implements Ftplet{

    static final Logger LOG = LoggerFactory.getLogger(FtpLoggerFtplet.class);

    @Override
    public void init(FtpletContext ftpletContext) throws FtpException {

    }

    @Override
    public void destroy() {

    }

    @Override
    public FtpletResult beforeCommand(FtpSession ftpSession, FtpRequest ftpRequest) throws FtpException, IOException {
        return null;
    }

    @Override
    public FtpletResult afterCommand(FtpSession ftpSession, FtpRequest ftpRequest, FtpReply ftpReply) throws FtpException, IOException {
        return null;
    }

    @Override
    public FtpletResult onConnect(FtpSession ftpSession) throws FtpException, IOException {
        LOG.info("LOGGED OnConnect: " + ftpSession.getClientAddress().getHostName());
        return null;
    }

    @Override
    public FtpletResult onDisconnect(FtpSession ftpSession) throws FtpException, IOException {
        return null;
    }
}
