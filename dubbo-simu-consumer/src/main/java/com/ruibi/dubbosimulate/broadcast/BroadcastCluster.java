package com.ruibi.dubbosimulate.broadcast;


import com.alibaba.dubbo.rpc.Invoker;
import com.alibaba.dubbo.rpc.RpcException;
import com.alibaba.dubbo.rpc.cluster.Cluster;
import com.alibaba.dubbo.rpc.cluster.Directory;

public class BroadcastCluster implements Cluster {

	public <T> Invoker<T> join(Directory<T> directory) throws RpcException {
		return new BroadcastClusterInvoker<T>(directory);
	}

}