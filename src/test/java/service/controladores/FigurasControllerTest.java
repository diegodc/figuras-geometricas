package service.controladores;

import aplicacion.FiguraRequest;
import aplicacion.FigurasInteractor;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.mock.http.MockHttpOutputMessage;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import service.RestService;
import service.repositorios.RepositorioMongoDB;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Arrays;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestService.class)
@WebAppConfiguration
public class FigurasControllerTest {

    private MediaType contentType = new MediaType(MediaType.APPLICATION_JSON.getType(),
            MediaType.APPLICATION_JSON.getSubtype(),
            Charset.forName("utf8"));

    private MockMvc mockMvc;

    private HttpMessageConverter mappingJackson2HttpMessageConverter;

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Before
    public void setup() {
        this.mockMvc = webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void retornaFigurasPorId() throws Exception {

        String id = "5b1615451300f420a440263b";

        mockMvc.perform(get("/figuras/" + id))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.id", is(id)))
                .andExpect(jsonPath("$.tipo", is("Triangulo")))
                .andExpect(jsonPath("$.base", is(10.0)))
                .andExpect(jsonPath("$.altura", is(40.0)))
                .andExpect(jsonPath("$.superficie", is(200.0)))
                .andExpect(jsonPath("$.diametro", isEmptyOrNullString()));
    }

    @Test
    public void idIncorrectoBadRequest() throws Exception {

        String id = "incorrecto";

        mockMvc.perform(get("/figuras/" + id))
                .andExpect(status().isBadRequest());
    }

    @Test
    public void ingresarFigura() throws Exception {

        Double[] parametros = new Double[]{2.0};
        String request = json(new FiguraRequest("cuadrado", parametros));

        mockMvc.perform(post("/figuras")
                .contentType(contentType)
                .content(request))
                .andExpect(status().isOk())
                .andExpect(content().contentType(contentType))
                .andExpect(jsonPath("$.tipo", is("Cuadrado")))
                .andExpect(jsonPath("$.base", is(2.0)))
                .andExpect(jsonPath("$.altura", is(2.0)))
                .andExpect(jsonPath("$.superficie", is(4.0)))
                .andExpect(jsonPath("$.diametro", isEmptyOrNullString()));
    }

    @Autowired
    @Bean
    public FigurasInteractor getInteractor(RepositorioMongoDB repositorio) {
        return new FigurasInteractor(repositorio);
    }

    @Autowired
    void setConverters(HttpMessageConverter<?>[] converters) {

        this.mappingJackson2HttpMessageConverter = Arrays.stream(converters)
                .filter(hmc -> hmc instanceof MappingJackson2HttpMessageConverter)
                .findAny()
                .orElse(null);

        assertNotNull("the JSON message converter must not be null",
                this.mappingJackson2HttpMessageConverter);
    }

    private String json(Object o) throws IOException {
        MockHttpOutputMessage mockHttpOutputMessage = new MockHttpOutputMessage();
        mappingJackson2HttpMessageConverter.write(o, MediaType.APPLICATION_JSON, mockHttpOutputMessage);
        return mockHttpOutputMessage.getBodyAsString();
    }

}