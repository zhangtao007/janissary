package com.lanjiu.im.netty.grpc_pool.gmsgPool;

import com.lanjiu.im.util.PropertyConf;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class GmsgClientFactory extends BasePooledObjectFactory<GmsgClient> {
    @Override
    public GmsgClient create() throws Exception {
        PropertyConf propertyConf = new PropertyConf("/message_group_storage.properties");
        String address = propertyConf.getValue("server_address");
        int port = Integer.valueOf(propertyConf.getValue("server_port"));
        return new GmsgClient(address,port);
    }

    @Override
    public PooledObject<GmsgClient> wrap(GmsgClient client) {
        return new DefaultPooledObject<>(client);
    }

    @Override
    public void destroyObject(final PooledObject<GmsgClient> p)
            throws Exception  {
        // The default implementation is a no-op.
        p.getObject().shutdown();
        super.destroyObject(p);
    }

}
