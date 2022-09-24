package br.com.credsystem.credsystemapp.controllersTests;

import br.com.credsystem.credsystemapp.CredsystemappApplication;
import br.com.credsystem.credsystemapp.dtos.ClienteDTO;
import br.com.credsystem.credsystemapp.entities.Cliente;
import br.com.credsystem.credsystemapp.repositories.ClienteRepository;
import br.com.credsystem.credsystemapp.services.ClienteService;
import br.com.credsystem.credsystemapp.utils.ClientePayload;
import br.com.credsystem.credsystemapp.utils.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes= CredsystemappApplication.class)
@AutoConfigureMockMvc
public class ClienteControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ClienteRepository repository;

    @MockBean
    ClienteService cService;

    @Test
    void listAll() throws Exception{
        var cliente = new ClienteDTO();
        cliente.setId(ClientePayload.id);
        cliente.setCpf(ClientePayload.cpf);
        cliente.setSalario(ClientePayload.salario);
        Mockito.when(cService.listAll()).thenReturn(List.of(cliente)); //.searchById(cliente.getId())).thenReturn(cliente);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.getJsonFromObject(cliente)))
//                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();

        List<Cliente> returnedClienteDto = JsonUtils.getObjectListFromJson(result.getResponse().getContentAsString(), Cliente.class); //.getObjectFromJson(result.getResponse().getContentAsString(), Cliente.class);
        Assertions.assertNotNull(returnedClienteDto);
    }
   @Test
    void searchById() throws Exception{
       var cliente = new ClienteDTO();
       cliente.setId(ClientePayload.id);
       cliente.setCpf(ClientePayload.cpf);
       cliente.setSalario(ClientePayload.salario);
       //String j = "{id: 1, cpf: '394.766.958-54', salario: 2343.54}";
        Mockito.when(cService.searchById(cliente.getId())).thenReturn(cliente);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/clientes/{id}", 1)
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(JsonUtils.getJsonFromObject(cliente)))
//                .andDo(print())
               .andExpect(status().isOk())
               .andReturn();

       Cliente returnedClienteDto = JsonUtils.getObjectFromJson(result.getResponse().getContentAsString(), Cliente.class);
       Assertions.assertNotNull(returnedClienteDto);
    }
    @Test
    void save() throws Exception{
        var cliente = new ClienteDTO();
        cliente.setId(ClientePayload.id);
        cliente.setCpf(ClientePayload.cpf);
        cliente.setSalario(ClientePayload.salario);
       MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/clientes", 1)
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(JsonUtils.getJsonFromObject(cliente)))
//                .andDo(print())
               .andExpect(status().isOk())
               .andReturn();

       List<Cliente> returnedClienteDto = JsonUtils.getObjectListFromJson(result.getResponse().getContentAsString(), Cliente.class);
       Assertions.assertNotNull(returnedClienteDto);

    }
}
