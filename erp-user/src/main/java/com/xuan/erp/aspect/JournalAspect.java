package com.xuan.erp.aspect;

import com.xuan.erp.annotation.JournalLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;

import java.lang.reflect.Method;

/**
 * 日志切面
 *
 * @author linweixuan@gmail.com
 */

//@Component
//@Aspect
public class JournalAspect {
    /**日志输出*/
    private static final Logger logger = LoggerFactory.getLogger(JournalAspect.class);

    /**service层切面*/
    private final String POINT_CUT = "execution(* com.matech.erp.service..*(..))";

    @Pointcut(POINT_CUT)
    private void pointcut(){}

    /**
     * 后置最终通知（目标方法只要执行完了就会执行后置通知方法）
     * 日志管理
     * @param joinPoint
     */
    @After(value = "pointcut()")
    @Transactional
    public void doAfterAdvice(JoinPoint joinPoint) throws ClassNotFoundException {
        String targetName = joinPoint.getTarget().getClass().getName();
        String methodName = joinPoint.getSignature().getName();
        Object[] arguments = joinPoint.getArgs();
        Class targetClass = Class.forName(targetName);
        Method[] methods = targetClass.getMethods();
        String modulerType = "-1";
        String opreationType = "-1";
        if (methods.length>0){
            for (Method method : methods) {
                if (method.getName().equals(methodName)) {
                    Class[] clazzs = method.getParameterTypes();
                    if (clazzs.length == arguments.length) {
                        if (method.getAnnotation(JournalLog.class)!=null){
                            modulerType = method.getAnnotation(JournalLog.class).modularTypeName();
                            opreationType = method.getAnnotation(JournalLog.class).operationType();
                            break;
                        }
                    }
                }
            }
        }

        //3.添加日志
        //if (modulerType!=-1&&opreationType!=-1)
            //TODO 3.1 从请求获取用户id
            //aspectJournalUtils.addJournalInfo(modulerType,opreationType, 10086);
    }
}