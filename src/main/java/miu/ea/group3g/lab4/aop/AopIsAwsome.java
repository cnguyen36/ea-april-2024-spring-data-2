package miu.ea.group3g.lab4.aop;

import jakarta.servlet.http.HttpServletRequest;
import miu.ea.group3g.lab4.entity.Customer;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import java.util.Collections;

@Aspect
@Component
public class AopIsAwsome {

    @Pointcut("execution(* miu.ea.group3g.lab4.service..*(..))&& args(customer)")
    public void checkPostServiceHeader(Customer customer){}

    @Before("checkPostServiceHeader(customer)")
    public void checkHeaderPresence(Customer customer){
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();

        // Check if the request contains the header "AOP-IS-AWESOME" with value "true"
        String headerValue = request.getHeader("AOP-IS-AWESOME");
        if (headerValue == null || !headerValue.equalsIgnoreCase("true")) {
            throw new AopIsAwesomeHeaderException("AOP-IS-AWESOME header is missing or does not have value 'true'");
        }

    }
}
