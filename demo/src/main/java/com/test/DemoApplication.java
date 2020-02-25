package com.test;

import javafx.scene.Parent;
import org.springframework.boot.Banner;
import org.springframework.boot.ansi.AnsiOutput;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.SpringVersion;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.test.mapper") // 扫描mapper
@EnableScheduling // 开启定时任务
@EnableAsync // 开启异步任务
public class DemoApplication {

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public static void main(String[] args) {
        // 启动颜色格式化
        // 这不是唯一启动颜色格式的方式，有兴趣的同学可以查看源码
        /**
         * 1. AnsiOutput.setEnabled(AnsiOutput.Enabled.ALWAYS);
         * 2. 在`src/main/resources`目录下新建文件`application.properties`,
         *    内容为：`spring.output.ansi.enabled=always`
         *
         * 重要：如果配置第二种方式，第一种方式就不会起作用
         */
//        AnsiOutput.setEnabled(AnsiOutput.Enabled.ALWAYS);
//        new SpringApplicationBuilder(DemoApplication.class) //
//                .main(SpringVersion.class) // 这个是为了可以加载 Spring 版本
//                .bannerMode(Banner.Mode.CONSOLE)// 控制台打印
//                .run(args);
		// 流式构建API
		new SpringApplicationBuilder()
				.sources(Parent.class)
				.child(DemoApplication.class)
				.bannerMode(Banner.Mode.CONSOLE)
				.run(args);
//		SpringApplication.run(DemoApplication.class, args);
	}

}
