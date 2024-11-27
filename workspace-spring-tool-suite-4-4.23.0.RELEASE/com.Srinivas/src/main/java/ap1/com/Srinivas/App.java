package ap1.com.Srinivas;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


public class App 
{
    public static void main( String[] args )
    {
    		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
    		Faculty f1 =ac.getBean(Faculty.class);
    		Staff s1 = ac.getBean(Staff.class);
    		Student st1 = ac.getBean(Student.class);
    		
    		f1.work();
    		s1.work();
    		st1.work();
    }
}
