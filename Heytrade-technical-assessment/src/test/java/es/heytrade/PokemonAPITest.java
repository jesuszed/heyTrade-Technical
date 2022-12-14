package es.heytrade;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@TestInstance(Lifecycle.PER_CLASS)
class PokemonAPITest extends AbstractTest {

	@Value("${api.name}")
	String apiName;

	@Value("${api.version}")
	String apiVersion;

	@Override
	@BeforeAll
	public void setUp() {
		super.setUp();
	}

	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, value = "/data-h2.sql")
	void shouldReturnAllPokemons() throws Exception {
		mvc.perform(get(apiName + apiVersion + "/pokemons"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$").exists())
				.andExpect(jsonPath("$[0]").exists())
				.andExpect(jsonPath("$[0].idPokemon").value("1"))
				.andExpect(jsonPath("$[0].name").value("CharmanderTEST"));
	}

	@Test
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, value = "/data-h2.sql")
	void shouldReturnAllFavouritePokemons() throws Exception {
		mvc.perform(get(apiName + apiVersion + "/pokemons/favourites"))
				.andDo(print()).andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_VALUE))
				.andExpect(jsonPath("$").exists())
				.andExpect(jsonPath("$[0]").exists())
				.andExpect(jsonPath("$[0].idPokemon").value("1"))
				.andExpect(jsonPath("$[0].name").value("CharmanderTEST"));
	}

}
