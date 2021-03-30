package com.lanjiu.im.netty.grpc_pool.msgPool;

import com.lanjiu.im.util.PropertyConf;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class MsgClientFactory extends BasePooledObjectFactory<MsgClient> {

    @Override
    public MsgClient create() throws Exception {
        PropertyConf propertyConf = new PropertyConf("/message_friend_storage.properties");
        String address = propertyConf.getValue("server_address");
        int port = Integer.valueOf(propertyConf.getValue("server_port"));
        return new MsgClient(address,port);
    }

    @Override
    public PooledObject<MsgClient> wrap(MsgClient client) {
        return new DefaultPooledObject<>(client);
    }

    @Override
    public void destroyObject(final PooledObject<MsgClient> p)
            throws Exception  {
        // The default implementation is a no-op.
        p.getObject().shutdown();
        super.destroyObject(p);
    }
}
