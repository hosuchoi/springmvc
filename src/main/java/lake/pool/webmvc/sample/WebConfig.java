package lake.pool.webmvc.sample;

import lake.pool.webmvc.sample.formatter.PersonFormatter;
import lake.pool.webmvc.sample.handlerinterceptor.AnotherInterceptor;
import lake.pool.webmvc.sample.handlerinterceptor.GreetingInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.CacheControl;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.concurrent.TimeUnit;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /*
    springboot에서는 아래 설정 안해도 됨
     왜???? formatter를 bean으로 등록하면 알아서 등록해줌
     */
//    @Override
//    public void addFormatters(FormatterRegistry registry) {
//        registry.addFormatter((new PersonFormatter()));
//    }


    /*
    interceptor 추가
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new GreetingInterceptor()).order(0);
        registry.addInterceptor(new AnotherInterceptor()).order(-1); // -1이 먼저 호출, 작을수록 먼저 호출됨
//                        .addPathPatterns("/hi");   // hi 패키지만 적용됨

    }

    /*
    Resource Handler 추가
     */

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/mobile/**") // 리소르로 지정할 핸들러 패턴
                .addResourceLocations("classpath:/mobile/", "file:/Users/lake/files") // 리소스를 사용할 위치 ( classpath, 파일시스템 사용 가능 )
                .setCacheControl(CacheControl.maxAge(10, TimeUnit.MINUTES)) // 캐싱기능 : 리소스가 변경되지 않으면 캐시꺼 사용
                .resourceChain(true); // 캐쉬를 쓸지 말지 기능
//                .addResolver() //요청에 해당하는 리소스를 찾는 방법
//                .addTransformer() //응답으로 내보낼 리소스를 변경하는 방법
    }
}
