package helpers;

import org.apache.jmeter.engine.StandardJMeterEngine;
import org.apache.jmeter.protocol.http.sampler.HTTPSampler;
import org.apache.jmeter.testelement.TestPlan;
import org.apache.jmeter.threads.ThreadGroup;
import org.apache.jmeter.util.JMeterUtils;
import org.apache.jorphan.collections.HashTree;

public class JmeterRequisicoesHelper {
	public StandardJMeterEngine jmeter;

	public JmeterRequisicoesHelper() {
		jmeter = new StandardJMeterEngine();

		JMeterUtils.loadJMeterProperties("src/test/resources/jmeter.properties");

		// JMeterUtils.initLogging(); // you can comment this line out to see
		// extra log messages of i.e. DEBUG level

		JMeterUtils.initLocale();
	}

	public void runSuite(HashTree testPlan) {
		jmeter.configure(testPlan);
		jmeter.run();
	}

	public ThreadGroup getThreadGroup(String name) {
		org.apache.jmeter.threads.ThreadGroup threadGroup = new org.apache.jmeter.threads.ThreadGroup();
		threadGroup.setName(name);
		threadGroup.setNumThreads(1);
		threadGroup.setRampUp(1);
		return threadGroup;
	}

	public HTTPSampler getHttpSampler(String url, int porta, String caminho, String metodo) {
		HTTPSampler httpSampler = new HTTPSampler();
		httpSampler.setDomain(url);
		httpSampler.setPort(porta);
		httpSampler.setPath(caminho);
		httpSampler.setMethod(metodo);
		return httpSampler;
	}

	public HashTree generateTestPlan(String planoTesteNome, String threadGrupoNome, String url, int porta,
			String caminho, String metodo) {
		HashTree testPlanTree = new HashTree();
		ThreadGroup threadGroup = getThreadGroup(threadGrupoNome);
		HTTPSampler httpSampler = getHttpSampler(url, porta, caminho, metodo);
		
		TestPlan testPlan = new TestPlan(planoTesteNome);
		testPlanTree.add(testPlan);
		testPlanTree.add(threadGroup);
		testPlanTree.add(httpSampler);
		return testPlanTree;
	}
}
