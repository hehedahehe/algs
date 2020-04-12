package com.ruibo.demo.dubbo.provider;

import com.ruibo.demo.dubboproviderapi.IDemoProviderService;
import org.apache.dubbo.config.annotation.Service;


@Service
public class DemoProviderServiceImpl implements IDemoProviderService {

	@Override
	public String SayHello(String word) {
		return "provider v2 ===" + word;
	}
}
