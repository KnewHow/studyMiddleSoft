package controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojo.User;
import service.RedisService;

@Controller
@RequestMapping("/redis")
public class RedisController {
	
	
	private static final ObjectMapper MAPPER = new ObjectMapper();

	@Autowired
	private RedisService redisService;

	@RequestMapping("getValue")
	@ResponseBody
	public Object getValue() {
		return redisService.getValue("ygh");
	}

	@RequestMapping("set")
	@ResponseBody
	public void set(String key, String value) {
		redisService.set(key, value);
	}
	
	@RequestMapping("getObject")
	@ResponseBody
	public Object getObject() throws JsonProcessingException{
		User user = new User();
		user.setSex("man");
		user.setUsername("yuanguohao");
		redisService.set("obj", MAPPER.writeValueAsString(user));
		return redisService.getValue("obj");
	}
}
