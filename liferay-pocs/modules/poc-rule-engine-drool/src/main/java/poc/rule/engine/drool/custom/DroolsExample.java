package poc.rule.engine.drool.custom;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.io.UnsupportedEncodingException;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class DroolsExample {

    public void executeDrools() throws UnsupportedEncodingException {
        // Load Drools KieContainer
    	KieServices kieServices = KieServices.Factory.get();
    	
    	
    	String rule = "import poc.rule.engine.drool.custom.Person\r\n" + 
    			"\r\n" + 
    			"rule \"Young Person Discount\"\r\n" + 
    			"when\r\n" + 
    			"    $person: Person(age < 30)\r\n" + 
    			"then\r\n" + 
    			"    $person.setDiscount(0.9); // 10% discount for young persons\r\n" + 
    			"end\r\n" + 
    			"\r\n" + 
    			"rule \"Elderly Person Discount\"\r\n" + 
    			"when\r\n" + 
    			"    $person: Person(age >= 60)\r\n" + 
    			"then\r\n" + 
    			"    $person.setDiscount(0.2); // 20% discount for elderly persons\r\n" + 
    			"end";
    	
    	 KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        // kieFileSystem.write(ResourceFactory.newClassPathResource("/discount_rules.drl"));
    	
    	 
    	 
//    	 
//    	 kieFileSystem.write("/test", rule.getBytes());
         	
		/*
		 * KnowledgeBuilder kb = KnowledgeBuilderFactory.newKnowledgeBuilder();
		 * kb.add(ResourceFactory.newByteArrayResource(rule.getBytes("utf-8")),
		 * ResourceType.DRL);
		 */
    	 
//         InputStream IS = new ByteArrayInputStream(rule.getBytes());
    	 kieFileSystem.write("src/main/resources/abc.drl" , rule);
         
         KieBuilder kieb = kieServices.newKieBuilder(kieFileSystem);
         kieb.buildAll();
         KieModule kieModule = kieb.getKieModule();
         KieContainer kieContainer = kieServices.newKieContainer(kieModule.getReleaseId());

        // Get the KieContainer from the KieServices
        // Create a new KieSession
        KieSession kieSession = kieContainer.newKieSession();
        try {
            // Create some sample data
            Person person = new Person("John", 25);

            // Insert the sample data into the session
            kieSession.insert(person);

            // Fire all the rules in the session
            kieSession.fireAllRules();

            // Print the result
            _log.info("Person: " + person.getName() + ", Age: " + person.getAge() + ", Discount: " + person.getDiscount());
        } catch (Exception e) {
        	_log.error("Error");
        	_log.error(e);
		}
    }
    
    private Log _log = LogFactoryUtil.getLog(this.getClass());
}
