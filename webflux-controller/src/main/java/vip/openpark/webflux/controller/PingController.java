package vip.openpark.webflux.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anthony
 * @version 2024/2/18 14:35
 */
@RestController
public class PingController {
	
	@GetMapping("ping")
	public String ping() {
		return "pong";
	}
}