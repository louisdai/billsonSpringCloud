//package consumer.context;
//
//import consumer.swagger.SwaggerConfigProperties;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
//@Configuration
//@EnableWebMvc
//@ComponentScan
//public class WebConfig extends WebMvcConfigurerAdapter {
//	@Autowired
//	SwaggerConfigProperties swaggerConfig;
//
//	/**
//	 *  需要重新注入一下资源文件，否则不会注入资源的，也没有注入requestHandlerMappping,相当于xml配置的
//	 *  <!--swagger资源配置-->
//	 *  <mvc:resources location="classpath:/META-INF/resources/" mapping="swagger-ui.html"/>
//	 *  <mvc:resources location="classpath:/META-INF/resources/webjars/" mapping="/webjars/**"/>
//	 * @param registry
//	 */
//	@Override
//	public void addResourceHandlers(ResourceHandlerRegistry registry) {
//		System.out.println(swaggerConfig.isEnable());
//		// swagger资源
//		if (swaggerConfig.isEnable()) {
//			System.out.println("WebConfig");
//			registry.addResourceHandler("swagger-ui.html").addResourceLocations("classpath:/META-INF/resources/");
//			registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
//		}
//	}
//
//	/**
//	* 拦截器
//	* @param registry
//	*/
//	/*@Override
//	public void addInterceptors(InterceptorRegistry registry) {
//		// 用户鉴权拦截器
//		// addPathPatterns 用于添加拦截规则
//		// excludePathPatterns 用户排除拦截
//		registry.addInterceptor(new AuthInterceptor()).addPathPatterns("/**").excludePathPatterns("/test/**",
//				"/admin/**");
//		super.addInterceptors(registry);
//	}*/
//}
