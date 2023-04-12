package co.develhope.APIInterceptor.Middleware1.configurations;

import co.develhope.APIInterceptor.Middleware1.interceptors.APILoggingInterceptor;
import co.develhope.APIInterceptor.Middleware1.interceptors.LegacyInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Ho creato la classe SpringMVCConfiguration annotandola con Component
 */
@Component
public class SpringMVCConfiguration implements WebMvcConfigurer {

    /**
     * Ho aggiunto un bean di APILoggingInterceptor e di LegacyInterceptor e gli aggiunti al registro attraverso
     * il metodo addInterceptors
     */
    @Autowired
    private APILoggingInterceptor apiLoggingInterceptor;

    @Autowired
    private LegacyInterceptor legacyInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(apiLoggingInterceptor);
        registry.addInterceptor(legacyInterceptor);

    }
}
