package br.com.credsystem.credsystemapp.controllersTests;

import br.com.credsystem.credsystemapp.CredsystemappApplication;
import br.com.credsystem.credsystemapp.dtos.request.ClienteDTORequest;
import br.com.credsystem.credsystemapp.dtos.response.ClienteDTOResponse;
import br.com.credsystem.credsystemapp.entities.Cliente;
import br.com.credsystem.credsystemapp.repositories.ClienteRepository;
import br.com.credsystem.credsystemapp.services.ClienteService;
import br.com.credsystem.credsystemapp.utils.ClientePayload;
import br.com.credsystem.credsystemapp.utils.JsonUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
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

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
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
        var cliente = new ClienteDTOResponse();
        cliente.setId(ClientePayload.id);
        cliente.setCpf(ClientePayload.cpf);
        cliente.setSalario(ClientePayload.salario);
        Mockito.when(cService.listAll()).thenReturn(List.of(cliente)); //.searchById(cliente.getId())).thenReturn(cliente);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.getJsonFromObject(cliente)))
                .andExpect(status().isOk())
                .andReturn();

        List<Cliente> returnedClienteDto = JsonUtils.getObjectListFromJson(result.getResponse().getContentAsString(), Cliente.class); //.getObjectFromJson(result.getResponse().getContentAsString(), Cliente.class);
        Assertions.assertNotNull(returnedClienteDto);
    }
   @Test
    void searchById() throws Exception{
       var cliente = new ClienteDTOResponse();
       cliente.setId(ClientePayload.id);
       cliente.setCpf(ClientePayload.cpf);
       cliente.setSalario(ClientePayload.salario);
       //String j = "{id: 1, cpf: '394.766.958-54', salario: 2343.54}";
        Mockito.when(cService.searchById(cliente.getId())).thenReturn(cliente);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.get("/clientes/{id}", 1)
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(JsonUtils.getJsonFromObject(cliente)))
               .andExpect(status().isOk())
               .andReturn();

       Cliente returnedClienteDto = JsonUtils.getObjectFromJson(result.getResponse().getContentAsString(), Cliente.class);
       Assertions.assertNotNull(returnedClienteDto);
    }
    @Test
    void save() throws Exception{
        var cliente = new ClienteDTORequest();
        cliente.setId(ClientePayload.id);
        cliente.setCpf(ClientePayload.cpf);
        cliente.setSalario(ClientePayload.salario);
        Mockito.when(cService.save(any())).thenReturn(cliente);
       MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/clientes")
                       .contentType(MediaType.APPLICATION_JSON)
                       .content(JsonUtils.getJsonFromObject(cliente)))
               .andExpect(status().isCreated())
               .andReturn();

       Cliente returnedClienteDto = JsonUtils.getObjectFromJson(result.getRequest().getContentAsString(), Cliente.class);
       Assertions.assertNotNull(returnedClienteDto);
    }

    @Test
    void update() throws Exception{
        var cliente = new ClienteDTORequest();
        cliente.setId(ClientePayload.id);
        cliente.setCpf(ClientePayload.cpf);
        cliente.setSalario(ClientePayload.salario);
        Mockito.when(cService.update(cliente)).thenReturn(cliente);//cService.save(any())).thenReturn(cliente);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.put("/clientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.getJsonFromObject(cliente)))
                .andExpect(status().isOk())
                .andReturn();

        Cliente returnedClienteDto = JsonUtils.getObjectFromJson(result.getRequest().getContentAsString(), Cliente.class);
        Assertions.assertNotNull(returnedClienteDto);
    }

    @Test
    void delete() throws Exception{
        var cliente = new ClienteDTORequest();
        cliente.setId(ClientePayload.id);
        cliente.setCpf(ClientePayload.cpf);
        cliente.setSalario(ClientePayload.salario);
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.delete("/clientes/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(JsonUtils.getJsonFromObject(cliente)))
                .andExpect(status().isNoContent())
                .andReturn();

        Cliente returnedClienteDto = JsonUtils.getObjectFromJson(result.getRequest().getContentAsString(), Cliente.class);
        Assertions.assertNotNull(returnedClienteDto);
    }
}
