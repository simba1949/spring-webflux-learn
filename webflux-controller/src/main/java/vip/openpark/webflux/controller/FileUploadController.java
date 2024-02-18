package vip.openpark.webflux.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.codec.multipart.FilePart;
import org.springframework.http.codec.multipart.Part;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author anthony
 * @version 2024/2/18 15:29
 */
@Slf4j
@RestController
@RequestMapping("file")
public class FileUploadController {
	
	/**
	 * 使用{@link FilePart}获取文件
	 *
	 * @param file 文件
	 * @return String
	 */
	@PostMapping("/filePart")
	public String filePart(@RequestPart("data") FilePart file) {
		String filename = file.filename();
		log.info("filename: {}", filename);
		return "SUCCESS";
	}
	
	/**
	 * 使用{@link Part}获取元数据
	 *
	 * @param metadata 源数据
	 * @return String
	 */
	@PostMapping("/metadata")
	public String metadata(@RequestPart("data") Part metadata) {
		String name = metadata.name();
		log.info("name: {}", name);
		return "SUCCESS";
	}
}