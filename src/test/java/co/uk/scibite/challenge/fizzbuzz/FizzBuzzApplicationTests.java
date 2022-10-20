package co.uk.scibite.challenge.fizzbuzz;

import co.uk.scibite.challenge.fizzbuzz.controller.FizzBuzzController;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Samuel Catalano
 * @since 23 March, 2020
 */

@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class FizzBuzzApplicationTests {

    @Autowired
    private WebApplicationContext webApplicationContext;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private FizzBuzzController controller;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
    }

    @Test
    void contextLoads() {
        assertThat(this.controller).isNotNull();
    }

    @Test
    public void testValidFizzBuzzFile() throws Exception {
        final String fizzBuzzFile = "{\"lines\":[[\"1\",\"2\",\"FIZZ\",\"4\",\"BUZZ\",\"FIZZ\",\"7\",\"8\",\"FIZZ\",\"BUZZ\"," +
                "\"11\",\"FIZZ\",\"13\",\"14\",\"FIZZBUZZ\",\"16\"],[\"1\",\"2\",\"FIZZ\",\"4\",\"BUZZ\",\"FIZZ\",\"7\",\"" +
                "8\",\"FIZZ\",\"BUZZ\",\"11\",\"FIZZ\",\"13\",\"14\",\"FIZZBUZZ\",\"16\",\"17\",\"FIZZ\",\"19\",\"BUZZ\",\"" +
                "FIZZ\"" + ",\"22\",\"23\",\"FIZZ\",\"BUZZ\",\"26\",\"FIZZ\",\"28\",\"29\",\"FIZZBUZZ\",\"31\",\"32\",\"FIZZ\"" +
                ",\"34\"" + ",\"BUZZ\",\"FIZZ\",\"37\",\"38\",\"FIZZ\",\"BUZZ\"]]}";

        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/fizz-buzz/validate")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(fizzBuzzFile);

        final MvcResult result = this.mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assert.assertEquals(result.getResponse().getContentAsString(), Boolean.TRUE.toString());
    }

    @Test
    public void testInvalidFizzBuzzFile() throws Exception {
        final String fizzBuzzFile = "{\"lines\":[[\"1\",\"2\",\"BUZZ\",\"4\",\"BUZZ\",\"FIZZ\",\"7\",\"8\",\"BUZZ\",\"FIZZ\"," +
                "\"11\",\"FIZZ\",\"13\",\"14\",\"FIZZ\",\"16\"],[\"1\",\"2\",\"FIZZ\",\"4\",\"BUZZ\",\"FIZZ\",\"7\",\"" +
                "8\",\"FIZZ\",\"BUZZ\",\"11\",\"FIZZ\",\"13\",\"14\",\"BUZZ\",\"16\",\"17\",\"FIZZ\",\"19\",\"BUZZ\",\"" +
                "FIZZ\"" + ",\"22\",\"23\",\"FIZZ\",\"BUZZ\",\"26\",\"FIZZ\",\"28\",\"29\",\"FIZZBUZZ\",\"31\",\"32\",\"FIZZ\"" +
                ",\"34\"" + ",\"BUZZ\",\"FIZZ\",\"37\",\"38\",\"FIZZ\",\"BUZZ\"]]}";

        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/fizz-buzz/validate")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(fizzBuzzFile);

        final MvcResult result = this.mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        Assert.assertEquals(result.getResponse().getContentAsString(), Boolean.FALSE.toString());
    }

    @Test
    public void testFizzBuzzFileWrongPath() throws Exception {
        final String fizzBuzzFile = "{\"lines\":[[\"1\",\"2\",\"BUZZ\",\"4\",\"BUZZ\",\"FIZZ\",\"7\",\"8\",\"BUZZ\",\"FIZZ\"," +
                "\"11\",\"FIZZ\",\"13\",\"14\",\"FIZZ\",\"16\"],[\"1\",\"2\",\"FIZZ\",\"4\",\"BUZZ\",\"FIZZ\",\"7\",\"" +
                "8\",\"FIZZ\",\"BUZZ\",\"11\",\"FIZZ\",\"13\",\"14\",\"BUZZ\",\"16\",\"17\",\"FIZZ\",\"19\",\"BUZZ\",\"" +
                "FIZZ\"" + ",\"22\",\"23\",\"FIZZ\",\"BUZZ\",\"26\",\"FIZZ\",\"28\",\"29\",\"FIZZBUZZ\",\"31\",\"32\",\"FIZZ\"" +
                ",\"34\"" + ",\"BUZZ\",\"FIZZ\",\"37\",\"38\",\"FIZZ\",\"BUZZ\"]]}";

        final RequestBuilder requestBuilder = MockMvcRequestBuilders.post("/fizz-buzz/check")
                .accept(MediaType.APPLICATION_JSON)
                .contentType(MediaType.APPLICATION_JSON)
                .content(fizzBuzzFile);

        this.mockMvc.perform(requestBuilder)
                .andDo(print())
                .andExpect(status().isNotFound());
    }
}