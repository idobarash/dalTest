package com.cooladata.dal.application;

import java.util.List;
import java.util.TimeZone;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.Jackson2ObjectMapperFactoryBean;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.ISO8601DateFormat;


@Component
public class JacksonMapperWebConfig extends WebMvcConfigurerAdapter {
	
	
    private ObjectMapper objectMapper() {
        Jackson2ObjectMapperFactoryBean bean = new Jackson2ObjectMapperFactoryBean();
        bean.afterPropertiesSet();
        ObjectMapper objectMapper = bean.getObject();
        ISO8601DateFormat f = new ISO8601DateFormat();
    	objectMapper.setDateFormat(f);
    	return objectMapper;
    }
    
    private MappingJackson2HttpMessageConverter mappingJackson2HttpMessageConverter() {
        MappingJackson2HttpMessageConverter converter = new MappingJackson2HttpMessageConverter();
        converter.setObjectMapper(objectMapper());
        return converter;
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(mappingJackson2HttpMessageConverter());
    }

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		//registry.addInterceptor(new RequestProcessingTimeInterceptor()).addPathPatterns("/**");;
		super.addInterceptors(registry);
	}
    
    
    
    //ViewAwareMappingJackson2HttpMessageConverter
    //JsonFilterAwareMappingJackson2HttpMessageConverter 

}
