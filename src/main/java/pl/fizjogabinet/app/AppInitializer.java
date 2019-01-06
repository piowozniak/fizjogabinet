package pl.fizjogabinet.app;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import pl.fizjogabinet.config.AppConfig;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		// TODO Auto-generated method stub
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected String[] getServletMappings() {
		// TODO Auto-generated method stub
		return new String[] { "/" };
	}
	
	
	/*implements WebApplicationInitializer  {
//	public void onStartup(ServletContext container) throws ServletException {
//		AnnotationConfigWebApplicationContext ctx =	new AnnotationConfigWebApplicationContext();
//		ctx.register(AppConfig.class);
//		ctx.setServletContext(container);
//		ServletRegistration.Dynamic servlet =
//		container.addServlet("dispatcher", new DispatcherServlet(ctx));
//		servlet.setLoadOnStartup(1);
//		servlet.addMapping("/");
//		} 
	}*/
	
	
} 