package aopAdvice;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;
@Configuration
@Aspect
public class MethodAdivce {
	public MethodAdivce(){
/*		try {
			System.setOut(new PrintStream(new File("C:/friendhelper.log")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		//System.setOut(new File("C:\\Users\\Tianso\\Desktop\\test\\friendhelper.log"));
	}
	//private final Logger logger = Logger.getLogger(MethodAdivce.class);
	
	@Around(value="execution(* serviceimpl..*.*(..))")
    public String asAround(ProceedingJoinPoint pj){
	
         System.out.println("---------------���ǻ���ǰ����ǿ-------------"+pj.getSignature().getName());
         try {
        	 for (int i = 0; i < pj.getArgs().length; i++) {  
        		
                 System.out.println(pj.getArgs()[i]);  
             }   
           String s = (String) pj.proceed();
           System.out.println("����ֵΪ��"+s);
           return s;
            
        } catch (Throwable e) {
            //ץ���쳣
            e.printStackTrace();
            return null;
        }
		
    }
}
