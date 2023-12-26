package hello.exception;

import org.springframework.boot.web.server.ConfigurableWebServerFactory;
import org.springframework.boot.web.server.ErrorPage;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.server.WebServerFactoryCustomizerBeanPostProcessor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

//@Component
public class WebServerCustomizer implements WebServerFactoryCustomizer<ConfigurableWebServerFactory> {

    @Override
    public void customize(ConfigurableWebServerFactory factory) {
        ErrorPage errorPage404 = new ErrorPage(HttpStatus.NOT_FOUND, "/error-page/404");// 해당 에러 발생시 해당 페이지(컨트롤러) 호출
        ErrorPage errorPage500 = new ErrorPage(HttpStatus.INTERNAL_SERVER_ERROR, "/error-page/500");// 해당 에러 발생시 해당 페이지(컨트롤러) 호출
        ErrorPage errorPageEx = new ErrorPage(RuntimeException.class, "/error-page/500");// 해당 에러 발생시 해당 페이지(컨트롤러) 호출

        factory.addErrorPages(errorPage404, errorPage500, errorPageEx);
    }
}
