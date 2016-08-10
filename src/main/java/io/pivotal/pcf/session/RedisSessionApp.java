package io.pivotal.pcf.session;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@SpringBootApplication
public class RedisSessionApp {

	public static void main(String[] args) {
		SpringApplication.run(RedisSessionApp.class, args);
	}

	@RestController
    static class Controller{

        @RequestMapping("/")
        String uid(HttpSession session) {
            System.out.println(session.getId());
            UUID uid = (UUID) session.getAttribute("uid");
            if (uid == null) {
                uid = UUID.randomUUID();
            }
            session.setAttribute("uid", uid);
            return uid.toString();
        }

    }
}
