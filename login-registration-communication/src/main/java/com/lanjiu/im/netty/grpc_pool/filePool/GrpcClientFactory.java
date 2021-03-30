package com.lanjiu.im.netty.grpc_pool.filePool;

import com.lanjiu.im.util.PropertyConf;
import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

public class GrpcClientFactory extends BasePooledObjectFactory<GrpcClient> {


    @Override
    public GrpcClient create() throws Exception {
        PropertyConf propertyConf = new PropertyConf("/transfer_storage.properties");
        String address = propertyConf.getValue("server_address");
        int port = Integer.valueOf(propertyConf.getValue("server_port"));
        return new GrpcClient(address,port);
    }

    @Override
    public PooledObject<GrpcClient>  wrap(GrpcClient client) {
        return new DefaultPooledObject<>(client);
    }

    @Override
    public void destroyObject(final PooledObject<GrpcClient> p)
            throws Exception  {
        // The default implementation is a no-op.
        p.getObject().shutdown();
        super.destroyObject(p);
    }

}
