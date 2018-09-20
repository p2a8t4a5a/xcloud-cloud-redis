package com.matech.erp.datasource;
/*
@Configuration
public class DataSourceConfig {
 
 
	private Logger logger = LoggerFactory.getLogger(this.getClass());
 
 
	@Value("${datasource.mysql.url}")
	private String dbUrl;
 
	@Value("${datasource.mysql.username}")
	private String username;
 
	@Value("${datasource.mysql.password}")
	private String password;
 
	@Value("${datasource.mysql.driverClassName}")
	private String driverClassName;
 
	@Value("${datasource.mysql.initialSize}")
	private int initialSize;
 
	@Value("${datasource.mysql.minIdle}")
	private int minIdle;
 
	@Value("${datasource.mysql.maxActive}")
	private int maxActive;
 
	@Value("${datasource.mysql.maxWait}")
	private int maxWait;
 
	@Value("${datasource.mysql.timeBetweenEvictionRunsMillis}")
	private int timeBetweenEvictionRunsMillis;
 
	@Value("${datasource.mysql.minEvictableIdleTimeMillis}")
	private int minEvictableIdleTimeMillis;
 
	@Value("${datasource.mysql.validationQuery}")
	private String validationQuery;
 
	@Value("${datasource.mysql.testWhileIdle}")
	private boolean testWhileIdle;
 
	@Value("${datasource.mysql.testOnBorrow}")
	private boolean testOnBorrow;
 
	@Value("${datasource.mysql.testOnReturn}")
	private boolean testOnReturn;
 
	@Value("${datasource.mysql.poolPreparedStatements}")
	private boolean poolPreparedStatements;
 
	@Value("${datasource.mysql.maxPoolPreparedStatementPerConnectionSize}")
	private int maxPoolPreparedStatementPerConnectionSize;
 
	@Value("${datasource.mysql.filters}")
	private String filters;
 
	@Value("{datasource.mysql.connectionProperties}")
	private String connectionProperties;
 
	@Bean(name="mysql")
	@ConfigurationProperties(prefix = "datasource.mysql")
	public DataSource dataSourceMysql(){
		System.out.println("主配"+dbUrl);
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(dbUrl);
		datasource.setUsername(username);
		datasource.setPassword(password);
		datasource.setDriverClassName(driverClassName);
		datasource.setInitialSize(initialSize);
		datasource.setMinIdle(minIdle);
		datasource.setMaxActive(maxActive);
		datasource.setMaxWait(maxWait);
		datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
		datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
		datasource.setValidationQuery(validationQuery);
		datasource.setTestWhileIdle(testWhileIdle);
		datasource.setTestOnBorrow(testOnBorrow);
		datasource.setTestOnReturn(testOnReturn);
		datasource.setPoolPreparedStatements(poolPreparedStatements);
		datasource.setMaxPoolPreparedStatementPerConnectionSize(maxPoolPreparedStatementPerConnectionSize);
		try {
			datasource.setFilters(filters);
		} catch (SQLException e) {
			logger.error("druid configuration initialization filter", e);
		}
		datasource.setConnectionProperties(connectionProperties);
		return datasource;
	}
 
	@Value("${datasource.sqlserver.url}")
	private String sqlServerUrl;
 
	@Value("${datasource.sqlserver.username}")
	private String sqlServerUsername;
 
	@Value("${datasource.sqlserver.password}")
	private String sqlServerPassword;
 
	@Value("${datasource.sqlserver.driverClassName}")
	private String sqlServerDriverClassName;
 
	@Bean(name="sqlserver")
	@ConfigurationProperties(prefix = "datasource.sqlserver")
	public DataSource dataSourceSQLServer(){
		System.out.println("次配"+sqlServerUrl);
		DruidDataSource datasource = new DruidDataSource();
		datasource.setUrl(sqlServerUrl);
		datasource.setUsername(sqlServerUsername);
		datasource.setPassword(sqlServerPassword);
		datasource.setDriverClassName(sqlServerDriverClassName);
		datasource.setInitialSize(initialSize);
		return datasource;
	}
 
 
	@Bean(name = "dynamicDataSource")
	@Primary  //优先使用，多数据源
	public DataSource dataSource(){
		DynamicDataSource dynamicDataSource = new DynamicDataSource();
		DataSource mysql = dataSourceMysql();
		DataSource sqlServer = dataSourceSQLServer();
		//设置默认数据源
		dynamicDataSource.setDefaultTargetDataSource(mysql);
		//配置多个数据源
		Map<Object,Object> map = new HashMap<>();
		map.put(DataSourceType.Mysql.getName(),mysql);
		map.put(DataSourceType.SQLServer.getName(),sqlServer);
		dynamicDataSource.setTargetDataSources(map);
		return dynamicDataSource;
	}
 
	@Bean(name="druidServlet")
	public ServletRegistrationBean druidServlet() {
		ServletRegistrationBean reg = new ServletRegistrationBean();
		reg.setServlet(new StatViewServlet());
		reg.addUrlMappings("/druid/*");
		reg.addInitParameter("allow", ""); //白名单
		return reg;
	}
 
	@Bean(name = "filterRegistrationBean")
	public FilterRegistrationBean filterRegistrationBean() {
		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
		filterRegistrationBean.setFilter(new WebStatFilter());
		filterRegistrationBean.addUrlPatterns("/*");
		filterRegistrationBean.addInitParameter("exclusions", "*.js,*.gif,*.jpg,*.png,*.css,*.ico,/druid/*");
		filterRegistrationBean.addInitParameter("profileEnable", "true");
		filterRegistrationBean.addInitParameter("principalCookieName","USER_COOKIE");
		filterRegistrationBean.addInitParameter("principalSessionName","USER_SESSION");
		filterRegistrationBean.addInitParameter("DruidWebStatFilter","/*");
		return filterRegistrationBean;
	}
}
*/