package com.ruibo.demo.javabasic.concurency.queuetest;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.locks.ReentrantLock;


/**
 * 单个消费者比较简单
 * 多个消费者就有些麻烦了
 * <p>
 * 组内单播
 * vs
 * 组内多播
 * kafka如何实现
 * <p>
 * 引入偏移量的思想
 */
public class OneProducerAndManyConsumerMQueue implements IMQueue {

	private final String cleanerName = "cleanerName";

	private Node head = null;
	private Node tail = null;

	//
	/**
	 * TODO
	 * 这个数据结构需要重新设计
	 * 实现消费者消费独立
	 * 但是和cleaner修改成竞争关系：当cleaner修改时 不允许消费者进行消费
	 */
	private Map<String, Integer> consumerOffsetsMap = new HashMap<>();

	private final Object consumerOffsetMonitor = new Object();

	private Runnable cleaner = () -> {
		synchronized (consumerOffsetMonitor) {
			int minOffset = Collections.min(consumerOffsetsMap.values());
			Node n = find(minOffset, head);
			head = n;
			Set<String> consumers = consumerOffsetsMap.keySet();
			for (String consumer : consumers) {
				updateConsumerOffSets(consumer, consumerOffsetsMap.get(consumer) - minOffset);
			}
		}
	};

	public OneProducerAndManyConsumerMQueue() {
		Thread cleanerThread = new Thread(cleaner);
		cleanerThread.setName(cleanerName);
		cleanerThread.start();
	}

	@Override
	public void push(int value) {
		Node newNode = new Node(value);
		if (head == null) {
			this.head = this.tail = newNode;
		} else {
			this.tail.next = newNode;
		}
	}

	@Override
	public List<Node> consume(int batchSize, String consumerName) {
		//1. 获取consumer消费OffSets
		//2. 开始消费 batchSize 数据
		//3. 更新consumer OffSets
		int offsets = getConsumerOffsets(consumerName);
		Node nodeBegin = find(offsets + 1, this.head);

		List<Node> res = new LinkedList<>();
		//消费完毕
		if (nodeBegin == null) {
			//
		} else {
			while (nodeBegin != null) {
				res.add(nodeBegin);
				offsets++;
				nodeBegin = nodeBegin.next;
			}
			updateConsumerOffSets(consumerName, offsets);
		}
		return res;
	}


	private int getConsumerOffsets(String consumerName) {
		synchronized (consumerOffsetMonitor) {
			return consumerOffsetsMap.get(consumerName);
		}
	}

	private void updateConsumerOffSets(String consumerName, int offsets) {
		synchronized (consumerOffsetMonitor) {
			consumerOffsetsMap.put(consumerName, offsets);
		}
	}

	public void registerConsumer(String consumerName) {
		consumerOffsetsMap.put(consumerName, 0);
	}

	private Node find(int index, Node head) {
		Node targetNode = head;
		int i = 1;
		while (i < index) {
			targetNode = head.next;
			i++;
		}
		return targetNode;
	}


}
