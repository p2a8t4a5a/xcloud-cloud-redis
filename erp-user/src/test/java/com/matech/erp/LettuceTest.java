package com.matech.erp;

import io.lettuce.core.RedisClient;
import io.lettuce.core.RedisURI;
import io.lettuce.core.api.StatefulRedisConnection;
import io.lettuce.core.api.sync.RedisCommands;

public class LettuceTest {

	public static void main(String[] args) {
		RedisClient client = RedisClient.create(RedisURI.create("redis://192.168.37.128:7000"));
		StatefulRedisConnection<String, String> connect = client.connect();

		/* 同步执行的命令 */
		RedisCommands<String, String> commands = connect.sync();
		String str = commands.get("test1");
		// String str2 = commands.get("test2");//MOVED 8899
		// 192.168.37.128:7001;;;;client是单机版
		System.out.println(str);

		/* 异步执行的命令 */
		// RedisAsyncCommands<String, String> commands = connect.async();
		// RedisFuture<String> future = commands.get("test1");
		// try {
		// String str = future.get();
		// System.out.println(str);
		// } catch (InterruptedException e) {
		// e.printStackTrace();
		// } catch (ExecutionException e) {
		// e.printStackTrace();
		// }

		connect.close();
		client.shutdown();
	}
}
