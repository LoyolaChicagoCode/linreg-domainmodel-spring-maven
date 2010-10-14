package points.service.impl;

import org.junit.Before;

import points.dao.impl.InMemoryPointDAO;

/**
 * A unit test for DefaultRegressionService that uses TestRegressionService as a
 * Testcase Superclass. It instantiates and connects the tiers manually.
 */
public class TestRegressionServiceInMemory extends TestRegressionService {

	@Before
	public void setUp() throws Exception {
		final DefaultRegressionService service = new DefaultRegressionService();
		service.setPointDAO(new InMemoryPointDAO());
		setRegressionService(service);
	}
}
