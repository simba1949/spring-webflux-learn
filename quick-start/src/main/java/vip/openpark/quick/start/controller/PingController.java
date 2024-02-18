package vip.openpark.quick.start.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author anthony
 * @version 2024/2/18 14:12
 */
@RestController
public class PingController {
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
	
	/**
	 * 官方推荐的响应式方式，返回值为 Flux或者 Mono
	 * 1. Mono 返回零或者一个值
	 * 2. Flux 返回零或者多个值
	 *
	 * @return Mono<String>
	 */
	@GetMapping("username")
	public Mono<String> username() {
		return Mono.just("李白");
	}
	
	@GetMapping("usernames")
	public Flux<String> usernames() {
		return Flux.just("李白", "杜甫");
	}
}