package com.gp.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@SpringBootApplication
@MapperScan("com.gp.project.mapper")
public class ProjectApplication {

	@RequestMapping("/")
	@ResponseBody
	public  String a(){
		return  "a";
	}

	public static void main(String[] args) {
		SpringApplication.run(ProjectApplication.class, args);
	}

}
