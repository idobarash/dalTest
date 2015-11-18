package com.cooladata.dal.application.actuator;

import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

import com.cooladata.dal.application.DalBeanConfiguration;

@Component
//@PropertySource("dal_version.properties")
public class DalHealth implements HealthIndicator<String> {

    @Override
    public String health() {
        // perform some specific health check
    	return "{'status':'Ok' ,'version' : '"+DalBeanConfiguration.env.getProperty("dalVersion")+"'}";
    }

}