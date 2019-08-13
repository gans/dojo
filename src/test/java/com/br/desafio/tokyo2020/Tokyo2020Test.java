package com.br.desafio.tokyo2020;

import com.br.desafio.tokyo2020.models.Competicao;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import java.text.SimpleDateFormat;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Tokyo2020Test {

	public static final String URL = "http://localhost:8080";

	private MockMvc mockMvc;

	@Autowired
	protected WebApplicationContext wac;
	
	@Before
    public void setup() {
        mockMvc = webAppContextSetup(wac).build();
    }

    @Test
    public void whenStartingApplication_thenCorrectStatusCode() throws Exception {
        mockMvc.perform(get("/competicao")).andExpect(status().is2xxSuccessful());
    };
    
    @Test
    public void whenAddingNewCompeticaoWithoutModalidade_thenCorrectStatusCodeAndResponse() throws Exception {
    	
    		Competicao competicao = new Competicao();
        competicao.setModalidade("");
        competicao.setLocal("Mineirão");
        competicao.setPais1("Brasil");
        competicao.setPais2("Alemanha");
        competicao.setEtapa("Eliminatórias");
        competicao.setValor1(1);
        competicao.setValor2(2);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        competicao.setDatahoraInicio(sdf.parse("2017-10-30 10:00"));
        competicao.setDatahoraFim(sdf.parse("2017-10-30 11:00"));

        mockMvc.perform(post("/competicao", competicao).contentType(MediaType.APPLICATION_JSON)
        		.content(new ObjectMapper().writeValueAsString(competicao)))
        		.andExpect(status().is(206)).andExpect(redirectedUrl(null));
    }
    
    @Test
    public void whenAddingNewCompeticaoWithoutLocal_thenCorrectStatusCodeAndResponse() throws Exception {
    	
    		Competicao competicao = new Competicao();
        competicao.setModalidade("Futebol");
        competicao.setLocal("");
        competicao.setPais1("Brasil");
        competicao.setPais2("Alemanha");
        competicao.setEtapa("Eliminatórias");
        competicao.setValor1(1);
        competicao.setValor2(2);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        competicao.setDatahoraInicio(sdf.parse("2017-10-30 10:00"));
        competicao.setDatahoraFim(sdf.parse("2017-10-30 11:00"));

        mockMvc.perform(post("/competicao", competicao).contentType(MediaType.APPLICATION_JSON)
        		.content(new ObjectMapper().writeValueAsString(competicao)))
        		.andExpect(status().is(206)).andExpect(redirectedUrl(null));
    }
    
    @Test
    public void whenAddingNewCompeticaoWithoutPais1_thenCorrectStatusCodeAndResponse() throws Exception {
    	
    		Competicao competicao = new Competicao();
        competicao.setModalidade("Futebol");
        competicao.setLocal("Mineirão");
        competicao.setPais1("");
        competicao.setPais2("Alemanha");
        competicao.setEtapa("Eliminatórias");
        competicao.setValor1(1);
        competicao.setValor2(2);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        competicao.setDatahoraInicio(sdf.parse("2017-10-30 10:00"));
        competicao.setDatahoraFim(sdf.parse("2017-10-30 11:00"));

        mockMvc.perform(post("/competicao", competicao).contentType(MediaType.APPLICATION_JSON)
        		.content(new ObjectMapper().writeValueAsString(competicao)))
        		.andExpect(status().is(206)).andExpect(redirectedUrl(null));
    }
    
    @Test
    public void whenAddingNewCompeticaoWithoutPais2_thenCorrectStatusCodeAndResponse() throws Exception {
    	
    		Competicao competicao = new Competicao();
        competicao.setModalidade("Futebol");
        competicao.setLocal("Mineirão");
        competicao.setPais1("Brasil");
        competicao.setPais2("");
        competicao.setEtapa("Eliminatórias");
        competicao.setValor1(1);
        competicao.setValor2(2);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        competicao.setDatahoraInicio(sdf.parse("2017-10-30 10:00"));
        competicao.setDatahoraFim(sdf.parse("2017-10-30 11:00"));

        mockMvc.perform(post("/competicao", competicao).contentType(MediaType.APPLICATION_JSON)
        		.content(new ObjectMapper().writeValueAsString(competicao)))
        		.andExpect(status().is(206)).andExpect(redirectedUrl(null));
    }
    
    @Test
    public void whenAddingNewCompeticaoWithSamePais_thenCorrectStatusCodeAndResponse() throws Exception {
    	
    		Competicao competicao = new Competicao();
        competicao.setModalidade("Futebol");
        competicao.setLocal("Mineirão");
        competicao.setPais1("Brasil");
        competicao.setPais2("Brasil");
        competicao.setEtapa("Eliminatórias");
        competicao.setValor1(1);
        competicao.setValor2(2);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        competicao.setDatahoraInicio(sdf.parse("2017-10-30 10:00"));
        competicao.setDatahoraFim(sdf.parse("2017-10-30 11:00"));

        mockMvc.perform(post("/competicao", competicao).contentType(MediaType.APPLICATION_JSON)
        		.content(new ObjectMapper().writeValueAsString(competicao)))
        		.andExpect(status().is(206)).andExpect(redirectedUrl(null));
    }
    
    @Test
    public void whenAddingNewCompeticaoWithWrongEtapa_thenCorrectStatusCodeAndResponse() throws Exception {
    	
    		Competicao competicao = new Competicao();
        competicao.setModalidade("Futebol");
        competicao.setLocal("Mineirão");
        competicao.setPais1("Brasil");
        competicao.setPais2("Alemanha");
        competicao.setEtapa("teste");
        competicao.setValor1(1);
        competicao.setValor2(2);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        competicao.setDatahoraInicio(sdf.parse("2017-10-30 10:00"));
        competicao.setDatahoraFim(sdf.parse("2017-10-30 11:00"));

        mockMvc.perform(post("/competicao", competicao).contentType(MediaType.APPLICATION_JSON)
        		.content(new ObjectMapper().writeValueAsString(competicao)))
        		.andExpect(status().is(206)).andExpect(redirectedUrl(null));
    }
    
    @Test
    public void whenAddingNewCompeticaoWrongValue_thenCorrectStatusCodeAndResponse() throws Exception {
    	
    		Competicao competicao = new Competicao();
        competicao.setModalidade("Futebol");
        competicao.setLocal("Mineirão");
        competicao.setPais1("Brasil");
        competicao.setPais2("Alemanha");
        competicao.setEtapa("Eliminatórias");
        competicao.setValor1(2);
        competicao.setValor2(2);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        competicao.setDatahoraInicio(sdf.parse("2017-10-30 10:00"));
        competicao.setDatahoraFim(sdf.parse("2017-10-30 11:00"));

        mockMvc.perform(post("/competicao", competicao).contentType(MediaType.APPLICATION_JSON)
        		.content(new ObjectMapper().writeValueAsString(competicao)))
        		.andExpect(status().is(206)).andExpect(redirectedUrl(null));
    }
    
    @Test
    public void whenAddingNewCompeticaoTest1_thenCorrectStatusCodeAndResponse() throws Exception {
    	
    		Competicao competicao = new Competicao();
        competicao.setModalidade("Futebol");
        competicao.setLocal("Mineirão");
        competicao.setPais1("Brasil");
        competicao.setPais2("Alemanha");
        competicao.setEtapa("Eliminatórias");
        competicao.setValor1(1);
        competicao.setValor2(2);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        competicao.setDatahoraInicio(sdf.parse("2017-10-30 10:00"));
        competicao.setDatahoraFim(sdf.parse("2017-10-30 11:00"));

        mockMvc.perform(post("/competicao", competicao).contentType(MediaType.APPLICATION_JSON)
        		.content(new ObjectMapper().writeValueAsString(competicao)))
        		.andExpect(status().is2xxSuccessful()).andExpect(redirectedUrl("http://localhost/competicao/1"));
    }
    
    @Test
    public void whenAddingNewCompeticaoTest2_thenCorrectStatusCodeAndResponse() throws Exception {
    	
    		Competicao competicao = new Competicao();
        competicao.setModalidade("Futebol");
        competicao.setLocal("Mineirão");
        competicao.setPais1("Argentina");
        competicao.setPais2("Uruguai");
        competicao.setEtapa("Eliminatórias");
        competicao.setValor1(2);
        competicao.setValor2(1);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        competicao.setDatahoraInicio(sdf.parse("2017-10-30 12:00"));
        competicao.setDatahoraFim(sdf.parse("2017-10-30 13:00"));

        mockMvc.perform(post("/competicao", competicao).contentType(MediaType.APPLICATION_JSON)
        		.content(new ObjectMapper().writeValueAsString(competicao)))
        .andExpect(status().is2xxSuccessful()).andExpect(redirectedUrl("http://localhost/competicao/2"));
    }
    
    @Test
    public void whenAddingNewCompeticaoTest3_thenCorrectStatusCodeAndResponse() throws Exception {
    	
    		Competicao competicao = new Competicao();
        competicao.setModalidade("Futebol");
        competicao.setLocal("Mineirão");
        competicao.setPais1("Paraguai");
        competicao.setPais2("Colombia");
        competicao.setEtapa("Eliminatórias");
        competicao.setValor1(2);
        competicao.setValor2(1);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        competicao.setDatahoraInicio(sdf.parse("2017-10-30 14:00"));
        competicao.setDatahoraFim(sdf.parse("2017-10-30 15:00"));

        mockMvc.perform(post("/competicao", competicao).contentType(MediaType.APPLICATION_JSON)
        		.content(new ObjectMapper().writeValueAsString(competicao)))
        .andExpect(status().is2xxSuccessful()).andExpect(redirectedUrl("http://localhost/competicao/3"));
    }
    
    @Test
    public void whenAddingNewCompeticaoTest4_thenCorrectStatusCodeAndResponse() throws Exception {
    	
    		Competicao competicao = new Competicao();
        competicao.setModalidade("Futebol");
        competicao.setLocal("Mineirão");
        competicao.setPais1("Chile");
        competicao.setPais2("Peru");
        competicao.setEtapa("Eliminatórias");
        competicao.setValor1(2);
        competicao.setValor2(1);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        competicao.setDatahoraInicio(sdf.parse("2017-10-30 16:00"));
        competicao.setDatahoraFim(sdf.parse("2017-10-30 17:00"));

        mockMvc.perform(post("/competicao", competicao).contentType(MediaType.APPLICATION_JSON)
        		.content(new ObjectMapper().writeValueAsString(competicao)))
        .andExpect(status().is2xxSuccessful()).andExpect(redirectedUrl("http://localhost/competicao/4"));
    }
    
    @Test
    public void whenAddingNewCompeticaoTest5_thenCorrectStatusCodeAndResponse() throws Exception {
    		/*
    		 * only 4 competitions per day
    		 */
    		Competicao competicao = new Competicao();
        competicao.setModalidade("Futebol");
        competicao.setLocal("Mineirão");
        competicao.setPais1("Venezuela");
        competicao.setPais2("Panamá");
        competicao.setEtapa("Eliminatórias");
        competicao.setValor1(2);
        competicao.setValor2(1);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        competicao.setDatahoraInicio(sdf.parse("2017-10-30 18:00"));
        competicao.setDatahoraFim(sdf.parse("2017-10-30 19:00"));

        mockMvc.perform(post("/competicao", competicao).contentType(MediaType.APPLICATION_JSON)
        		.content(new ObjectMapper().writeValueAsString(competicao)))
        .andExpect(status().is(206)).andExpect(redirectedUrl(null));
    }
    
    @Test
    public void whenAddingNewCompeticaoTest6_thenCorrectStatusCodeAndResponse() throws Exception {
    		/*
    		 * minimum duration >= 30 minutes
    		 */
    		Competicao competicao = new Competicao();
        competicao.setModalidade("Futebol");
        competicao.setLocal("Mineirão");
        competicao.setPais1("Venezuela");
        competicao.setPais2("Panamá");
        competicao.setEtapa("Eliminatórias");
        competicao.setValor1(2);
        competicao.setValor2(1);
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        competicao.setDatahoraInicio(sdf.parse("2017-10-31 18:00"));
        competicao.setDatahoraFim(sdf.parse("2017-10-31 18:20"));

        mockMvc.perform(post("/competicao", competicao).contentType(MediaType.APPLICATION_JSON)
        		.content(new ObjectMapper().writeValueAsString(competicao)))
        .andExpect(status().is(206)).andExpect(redirectedUrl(null));
    }
}
