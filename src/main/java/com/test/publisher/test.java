package com.test.publisher;

import java.util.concurrent.CountDownLatch;

import org.eclipse.paho.client.mqttv3.MqttException;
import org.eclipse.paho.client.mqttv3.MqttPersistenceException;

import kafka.producer.Producer;

public class test {
	static Publisher[] Publisher=null;
	
	public static void main(String[] args) throws MqttPersistenceException, MqttException, InterruptedException {
		final CountDownLatch latch = new CountDownLatch(50);
		Publisher = new Publisher[500];
		for(int i=0;i<50;i++)
		{
			/*Thread.sleep(25);*/
			Publisher[i]=new Publisher(latch);
			Publisher[i].start();
			
		}
		latch.await();
		System.out.println("****************************************************************************************");
		
		for(int i=0;i<50;i++)
		{
			//System.out.println("=======>"+i);
			//Thread.sleep(10);
			//Publisher[i].getClient().close();
			Publisher[i].getClient().disconnect();
			Publisher[i].getClient().close();
			
			
		}
		System.out.println("**********************************completed******************************************************");
	}

}
