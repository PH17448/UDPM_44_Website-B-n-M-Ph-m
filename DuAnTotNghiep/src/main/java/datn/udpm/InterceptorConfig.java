package datn.udpm;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import datn.udpm.entity.Account;
import datn.udpm.interceptor.GlobalInterceptor;

@Component
public class InterceptorConfig implements WebMvcConfigurer  {
	
	@Autowired
	GlobalInterceptor globalInterceptor ;

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(globalInterceptor).addPathPatterns("/**")
		.excludePathPatterns("/rest/**","/images/**");
	}

	
	
	
	
	
	
}
