package vip.openpark.quick.start;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseCookie;
import org.springframework.http.server.reactive.HttpHandler;
import org.springframework.http.server.reactive.ReactorHttpHandlerAdapter;
import org.springframework.util.MultiValueMap;
import reactor.core.publisher.Mono;
import reactor.netty.http.server.HttpServer;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author anthony
 * @version 2024/2/18 12:56
 */
@Slf4j
public class OriginalWebfluxQuickStartApplication {
	public static void main(String[] args) throws IOException {
		// 1. 创建一个能处理http请求的HttpHandler
		HttpHandler handler = (request, response) -> {
			log.info("请求进来了，请求路径：{}", request.getURI());
			
			// 获取响应头
			HttpHeaders headers = response.getHeaders();
			// 获取响应 cookie
			MultiValueMap<String, ResponseCookie> cookies = response.getCookies();
			// 获取响应状态码
			HttpStatusCode statusCode = response.getStatusCode();
			
			// 获取响应数据缓冲区工厂：创建响应数据的缓冲区
			DataBufferFactory dataBufferFactory = response.bufferFactory();
			// 写响应数据
			DataBuffer dataBuffer = dataBufferFactory.wrap("Hello World".getBytes(StandardCharsets.UTF_8));
			
			return response.writeWith(Mono.just(dataBuffer));
		};
		
		// 2. 启动一个服务器，拿到数据交给 HttpHandler 进行请求处理
		ReactorHttpHandlerAdapter adapter = new ReactorHttpHandlerAdapter(handler);
		
		// 3. 启动 netty 服务器
		HttpServer
			.create()
			.port(8080)
			.handle(adapter)
			// 现在就绑定
			.bindNow();
		
		log.info("服务器启动成功，监听端口：8080");
		// 防止服务器关闭
		System.in.read();
	}
}