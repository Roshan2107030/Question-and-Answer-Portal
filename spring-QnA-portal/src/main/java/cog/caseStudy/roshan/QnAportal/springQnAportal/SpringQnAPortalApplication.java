package cog.caseStudy.roshan.QnAportal.springQnAportal;

import cog.caseStudy.roshan.QnAportal.springQnAportal.config.SwaggerConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@EnableAsync
@Import(SwaggerConfiguration.class)
public class SpringQnAPortalApplication {

	public static void main(String[] args) {
		SpringApplication.run(cog.caseStudy.roshan.QnAportal.springQnAportal.SpringQnAPortalApplication.class, args);
	}

}
