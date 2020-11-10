package net.aws2020course.fullstack;

import net.aws2020course.fullstack.controller.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;


@SpringBootApplication
// We use direct @Import instead of @ComponentScan to speed up cold starts
// @ComponentScan(basePackages = "net.aws.twaddle.lambda.controller")
@Import({ UserController.class, TwitterController.class })
public class SpringbootAwsLambdaTwaddle {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsLambdaTwaddle.class, args);
    }
}