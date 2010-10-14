package points.service.impl;

import javax.annotation.Resource;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;

import points.service.RegressionService;

/**
 * A Spring-supported integration test of DefaultRegressionService that uses
 * TestRegressionService as a Testcase Superclass. All dependencies are
 * managed and injected by the Spring container.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
	"/applicationContextService.xml",
	"/applicationContextInMemoryDAO.xml"
})
@TestExecutionListeners({
	DependencyInjectionTestExecutionListener.class,
})
public class TestRegressionServiceSpringInMemory extends TestRegressionService {

	/*
	 * For DITEL automatically to inject the regression service into the
	 * instance of this test class, we have to mark the corresponding setter
	 * as a Resource. To keep the test superclass independent of Spring,
	 * we override the setter and then mark it.
	 */
	@Resource
	@Override
	public void setRegressionService(final RegressionService service) {
		super.setRegressionService(service);
	}

	@Before
	public void setUp() {
		getRegressionService().reset();
	}
}
