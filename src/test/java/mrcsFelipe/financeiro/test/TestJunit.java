package mrcsFelipe.financeiro.test;

import static org.junit.Assert.assertEquals;
import mrcsFelipe.financeiro.entity.User;
import mrcsFelipe.financeiro.repository.UserRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:**/spring-*.xml","classpath:**/persistence.xml"})
@Transactional
@TransactionConfiguration(defaultRollback = false)
public class TestJunit {
		
	@Autowired
	private UserRepository userRepository;
	
	
		@Test
		public void test(){
			User u = userRepository.findByEmail("marcos@gmail.com");
			
			String oi = "oi";
			assertEquals("oi", oi);
			
		}
	
}
