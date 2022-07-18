package com.camptocamp.demoappspringbootgradlewar;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

import com.camptocamp.demo_app_springboot_gradle_war.BuildConfig;


@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
        return "<h1><center>Hello World!</center></h1>" +
        "<h1><center>Greetings from : " + BuildConfig.APP_NAME + "</center></h1>\n" +
        "<h1><center>Build Date     : " + BuildConfig.BUILD_DATE + "</center></h1>\n";
	}
}
