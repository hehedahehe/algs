package com.ruibo.demo.dubbo.provider;

import com.alibaba.dubbo.config.annotation.Service;
import com.ruibo.demo.dubboproviderapi.IDemoProviderService;


@Service
public class DemoProviderServiceImpl implements IDemoProviderService {

	@Override
	public String SayHello(String word) {
		return "provider===" + word;
	}
}
