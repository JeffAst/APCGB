package cgb.transfert;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
@WithMockUser(username = "user")
public class MonApplicationTest {

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testGetAllAccounts() throws Exception {
		String expectedJson = """
				[
				    {"accountNumber": "123456789", "solde": 300.0},
				    {"accountNumber": "987654321", "solde": 500.0},
				    {"accountNumber": "456789123", "solde": 2000.0}
				]
				""";

		mockMvc.perform(get("/api/transfers/accounts").contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json(expectedJson));
	}

	@Test
	public void testObtenirUtilisateur() throws Exception {
		int id = 1;
		mockMvc.perform(get("/test/{id}", id)).andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.TEXT_PLAIN))
				.andExpect(content().string("Recu : " + id));
	}
}
