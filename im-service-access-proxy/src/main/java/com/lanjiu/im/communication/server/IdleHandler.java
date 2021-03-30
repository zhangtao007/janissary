package com.lanjiu.im.communication.server;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.timeout.IdleStateEvent;
import io.netty.handler.timeout.IdleStateHandler;
import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

public class IdleHandler extends IdleStateHandler {

    private final Logger log = Logger.getLogger(IdleHandler.class);

    private static final int READER_WITER_TIME = 65;

    IdleHandler() {
        super(0, 0, READER_WITER_TIME, TimeUnit.SECONDS);
    }

    @Override
    protected void channelIdle(ChannelHandlerContext ctx, IdleStateEvent evt) throws Exception {

        log.info(READER_WITER_TIME + "秒内【"+ctx.channel().id().toString()+"】未读、写数据，关闭连接" + ctx.channel());

        ctx.channel().close();
    }
}
