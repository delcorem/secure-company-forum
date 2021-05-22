package ca.sheridancollege.delcorem.database;


import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.junit4.SpringRunner;

import ca.sheridancollege.delcorem.beans.User;


@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class TestDatabaseAccess {

	@Autowired
	private DatabaseAccess da;
	
	@Test
	public void testInsertUser_getUserList() {
		
		User user = new User();
		user.setEmail("a@a.ca");
		user.setUserDiscussion("Needs more info");
		
		da.insertUser(user);

		Assert.assertTrue(da.getUserList().size()>0);
	}
	
//	@Test
//	public void testInsertUser_getUserList() {
//		
//		User user = new User();
//		user.setEmail("a@a.ca");
//		user.setUserDiscussion("Needs more info");
//		
//		da.insertUser(user);
//
//		Assert.assertTrue(da.getUserList().size()>0);
//	}
}
