package ca.sheridancollege.delcorem.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import ca.sheridancollege.delcorem.beans.User;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureTestDatabase
@AutoConfigureMockMvc
public class TestHomeController {

	@Autowired
	private MockMvc mockMvc;
	
	@Test
	public void	testLoadingIndex() throws Exception {
		this.mockMvc.perform(get("/"))
			.andExpect(status().isOk())
			.andExpect(view().name("index"));
	}
	
//	@Test
//	public void	testLoadingSecureIndex() throws Exception {
//		this.mockMvc.perform(get("/secure"))
//			.andExpect(status().isOk())
//			.andExpect(view().name("/secure/index"));
//	}
	
	@Test
	public void	testLoadingLogin() throws Exception {
		this.mockMvc.perform(get("/login"))
			.andExpect(status().isOk())
			.andExpect(view().name("login"));
	}
	
	@Test
	public void	testLoadingPermissionDenied() throws Exception {
		this.mockMvc.perform(get("/permission-denied"))
			.andExpect(status().isOk())
			.andExpect(view().name("/error/permission-denied"));
	}
	
//	Can't figure out how to mock Authentication in tests. Any secure page I try doesn't work in tests.
//	@Test
//	public void testLoadingInsertUser() throws Exception {
//		this.mockMvc.perform(post("/insertUser")
//				.flashAttr("user", new User()))
//				.andExpect(status().isOk())
//				.andExpect(view().name("/secure/forum"));
//	}
//	
//	@Test
//	public void testLoadingInsertUser() throws Exception {
//		this.mockMvc.perform(post("/register")
//				.flashAttr("user", new User()))
//				.andExpect(status().isOk())
//				.andExpect(view().name("redirect:/"));
//	}
}
