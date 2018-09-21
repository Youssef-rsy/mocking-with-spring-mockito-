package com.local.ysf.MockitoForControllersTest;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.ContentNegotiatingViewResolver;

import com.jayway.jsonpath.JsonPath;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class MockitoForControllersTestApplicationTests {
	/**
	 * there is two way of doing this methode 
	 * 	1 -	using annotation @AutoConfigureMockMvc + @Autowired on the MockMvc attribute
	 * 	2 -	using the manual configuration by building it like: mockMvc = new MockMvcBuilders().standaloneSetup(homeController).build();
	 */
	
	@InjectMocks
	private HomeController homeController;
	@Autowired
	private MockMvc mockMvc;

	@Before
	public void befor() {
		//mockMvc = new MockMvcBuilders().standaloneSetup(homeController).build();
		System.out.println("---------------------------------");
	}

	@Test
	public void testingHello() throws Exception {
		this.mockMvc.perform(get("/mocking/hello"))
					.andDo(print()) //printing all request informations 
					.andExpect(status().isOk())
					.andExpect(content().string("hello world!"))
					;
	}
	@Test
	public void testingBook() throws Exception {
		this.mockMvc.perform(get("/mocking/book").accept(MediaType.APPLICATION_JSON))
					.andDo(print()) //printing all request informations 
					.andExpect(status().isNotFound())
					.andExpect((ResultMatcher) jsonPath("$.title", Matchers.matches("title n ° 0")))
					.andExpect((ResultMatcher) jsonPath("$.auteur",Matchers.endsWith("auteur n ° 0")))
					;
	}
	
	@Test
	@Ignore
	public void testingBookFromUrl() throws Exception {
		this.mockMvc.perform(get("/mocking/book").param("title", "title1"))
					.andDo(print()) //printing all request informations 
					.andExpect(status().isNotFound())
					.andExpect((ResultMatcher) jsonPath("$.title",Matchers.matches("title1")))
					.andExpect((ResultMatcher) jsonPath("$.auteur",Matchers.matches("auteur1")))
					;
	}
	
	

}
