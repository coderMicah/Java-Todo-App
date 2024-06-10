package com.micah.todoApp.helloWorld;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class HelloWorldController {
    
    @RequestMapping("/hello-world")
    @ResponseBody
    public String sayHello(){
        return "Hello World";
    }

    @RequestMapping("hello-world-html")
    @ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title> Hello World</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("Hello World I'm learnig Spring Boot");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}

	@RequestMapping("/hello-world-jsp")
    public String sayHelloJSP(){
        return "helloWorldJSP";
    }
}
