package cn.com.vector;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

import cn.com.vector.play.service.UserService;
import cn.com.vector.play.service.WarService;

public class SpringUtil {

	static SpringApplication springApplication = new SpringApplication(VectorPlayApplication.class);

	public static ConfigurableApplicationContext configApplicationContext;

	static {
		Set<Object> sourcesSet = new HashSet<Object>();
		sourcesSet.add("classpath:spring/*.xml");
//		springApplication.setSources(sourcesSet);
		configApplicationContext = springApplication.run(new String[] {});
	}

	// service
	public static final UserService userService = configApplicationContext.getBean(UserService.class);

	public static final WarService warService = configApplicationContext.getBean(WarService.class);
	

}
