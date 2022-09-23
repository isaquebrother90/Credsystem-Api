package controllersTests;

import br.com.credsystem.credsystemapp.CredsystemappApplication;
import br.com.credsystem.credsystemapp.dtos.ClienteDTO;
import br.com.credsystem.credsystemapp.entities.Cliente;
import br.com.credsystem.credsystemapp.repositories.ClienteRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

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

    @Test
    void listAll() throws Exception{
        var cliente = new Cliente();
        cliente.setId(1L);
        cliente.setCpf("394.787.095-54");
        cliente.setSalario(2343.54);
        Mockito.when(repository.findAll()).thenReturn(List.of(cliente));
        this.mockMvc.perform(get("/clientes"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{id: 1, cpf: '394.787.095-54', salario: 2343.54}]"));
    }
}
