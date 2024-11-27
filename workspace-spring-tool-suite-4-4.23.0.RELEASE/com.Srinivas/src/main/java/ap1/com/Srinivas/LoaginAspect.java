package ap1.com.Srinivas;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

@Aspect
@Component
@EnableAspectJAutoProxy
public class LoaginAspect {
	
	@Before("execution (public void work())")
	public void doLogin() {
		System.out.println("You Have Succesfully Logged in - you can now Start your Work.................");
	}

}