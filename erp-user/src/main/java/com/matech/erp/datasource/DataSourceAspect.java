package com.matech.erp.datasource;

/*
@Aspect
@Order(2)
@Component
public class DataSourceAspect {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
 
	//切点
	@Pointcut("execution(* com.test.*.service..*(..)))")
	public void aspect(){
		System.out.println("aspect");
	}
 
	@Before("aspect()")
	private void before(JoinPoint joinPoint){
		Object target = joinPoint.getTarget();
		String method = joinPoint.getSignature().getName();
		Class<?> classz = target.getClass();
		Class<?>[] parameterTypes = ((MethodSignature) joinPoint.getSignature()).getMethod().getParameterTypes();
		try {
			Method m = classz.getMethod(method,parameterTypes);
			if (m != null && m.isAnnotationPresent(MyDataSource.class)){
				MyDataSource data = m.getAnnotation(MyDataSource.class);
				JdbcContextHolder.putDataSource(data.value().getName());
				logger.info("===============上下文赋值完成:{}"+data.value().getName());
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
}
*/