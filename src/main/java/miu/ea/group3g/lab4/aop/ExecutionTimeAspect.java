package miu.ea.group3g.lab4.aop;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import miu.ea.group3g.lab4.entity.Activity;
import miu.ea.group3g.lab4.repository.ActivityRepository;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Aspect
@Component
@RequiredArgsConstructor
public class ExecutionTimeAspect {

    private final ActivityRepository activityRepository;

    @Around("@annotation(miu.ea.group3g.lab4.annotation.ExecutionTime)")
    public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long startTime = System.currentTimeMillis();
        System.out.println("START TIME IS: "+startTime);

        Object proceed = joinPoint.proceed();
        long executionTime = System.currentTimeMillis() - startTime;
        System.out.println("EXECUTION TIME IS: "+executionTime);
        // Get method signature
        String methodName = joinPoint.getSignature().toShortString();
        System.out.println("METHOD NAME IS: "+methodName);

        Activity activity = new Activity(LocalDate.now(), methodName, (int) executionTime);

        System.out.println("ACTIVITY LOG IS: "+activity.toString());

        // Log execution time to ActivityLog table
        activityRepository.save(activity);

        return proceed;
    }

}
