package de.darkatra.jsr380kotlinissue

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit.jupiter.SpringExtension
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.model

@SpringBootTest
@ExtendWith(SpringExtension::class)
@ActiveProfiles("it")
@AutoConfigureMockMvc
class UserControllerTest {
	@Autowired
	lateinit var mockMvc: MockMvc

	@Test
	internal fun shouldNotCreateNewTestWithInvalidParamsKotlin() {
		mockMvc.perform(post("/users/kotlin")
			.param("roles", "not a role"))
			.andExpect(model().attributeHasFieldErrors("user", "roles"))
	}

	@Test
	internal fun shouldNotCreateNewTestWithInvalidParamsJava() {
		mockMvc.perform(post("/users/java")
			.param("roles", "not a role"))
			.andExpect(model().attributeHasFieldErrors("user", "roles[]"))
	}
}