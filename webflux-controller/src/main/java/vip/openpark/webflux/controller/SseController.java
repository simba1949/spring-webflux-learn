package vip.openpark.webflux.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * SSE，全称 Server-Sent Events（服务器推送事件）。
 * 它是一种基于HTTP的协议，用于服务器向客户端推送实时事件流的技术。
 * 与传统的HTTP请求-响应模型不同，SSE允许服务器持续地向客户端发送数据，从而实现了服务器到客户端的单向通信。
 *
 * @author anthony
 * @version 2024/2/18 14:35
 */
@RestController
public class SseController {
	/**
	 * 需要使用 text/event-stream 作为 Content-Type
	 *
	 * @return Flux<String>
	 */
	@GetMapping(value = "sse", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<Long> stream() {
		return Flux
			       // 每秒发送一个数字
			       .interval(Duration.ofSeconds(1));
	}
}