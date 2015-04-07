import static org.junit.Assert.assertNotNull;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;


public class ApplicationContextInitTest {

	protected static ApplicationContext applicationContext;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		applicationContext = new ClassPathXmlApplicationContext(
				new String[] { "applicationContext-init.xml"//
				});
	}

	@Test
	public void propertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer bean = (PropertyPlaceholderConfigurer) applicationContext
				.getBean("propertyPlaceholderConfigurer");
		System.out.println(bean);
		assertNotNull(bean);
	}

	@Test
	public void servicePropertyPlaceholderConfigurer() {
		PropertyPlaceholderConfigurer bean = (PropertyPlaceholderConfigurer) applicationContext
				.getBean("servicePropertyPlaceholderConfigurer");
		System.out.println(bean);
		assertNotNull(bean);
	}

	@Test
	public void velocityConfigurer() {
		VelocityConfigurer bean = (VelocityConfigurer) applicationContext
				.getBean("velocityConfigurer");
		System.out.println(ToStringBuilder.reflectionToString(bean,
				ToStringStyle.MULTI_LINE_STYLE));
		assertNotNull(bean);
	}

	@Test
	public void freeMarkerConfigurer() {
		FreeMarkerConfigurer bean = (FreeMarkerConfigurer) applicationContext
				.getBean("freeMarkerConfigurer");
		System.out.println(ToStringBuilder.reflectionToString(bean,
				ToStringStyle.MULTI_LINE_STYLE));
		assertNotNull(bean);
	}
}
