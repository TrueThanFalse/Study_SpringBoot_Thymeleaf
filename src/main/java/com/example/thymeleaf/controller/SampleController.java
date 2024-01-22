package com.example.thymeleaf.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.thymeleaf.doamin.SampleDTO;

import lombok.extern.log4j.Log4j2;

@Log4j2
// logback 사용하고 싶으면 따로 설정해줘야 함
// logback은 DB 정보를 볼 수 있음
@Controller
public class SampleController {

	@GetMapping("/hello")
	public void hello(Model m) {
		log.info("@@@@@ hello Join Success");
		m.addAttribute("msg", "Hello World~!");
	}
	
	@GetMapping("/ex/ex1")
	public void ex1(Model m) {
		List<String> list = Arrays.asList("aaa","bbb","ccc","ddd","eee");
		m.addAttribute("list", list);
	}
	
	@GetMapping("/ex/ex2")
	public void ex2(Model m) {
		List<String> strList = IntStream.range(1, 10)
				.mapToObj(i -> "data " + i)
				.collect(Collectors.toList());
		
		m.addAttribute("strList", strList);
		
		Map<String, String> map = new HashMap<>();
		map.put("a", "aaa");
		map.put("b", "bbb");
		map.put("c", "ccc");
		map.put("d", "ddd");
		map.put("e", "eee");
		
		m.addAttribute("map", map);
		
		SampleDTO sampleDTO = new SampleDTO();
		sampleDTO.setP1("Value --- p1");
		sampleDTO.setP2("Value --- p2");
		sampleDTO.setP3("Value --- p3");
		
		m.addAttribute("DTO", sampleDTO);
	}
	
	@GetMapping("/ex/ex3")
	public void ex3(Model m) {
		m.addAttribute("arr", new String[] {"aaa","bbb","ccc"});
	}
	
}
