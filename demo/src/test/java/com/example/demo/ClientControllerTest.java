package com.example.demo;

import com.example.demo.entity.Client;
import com.example.demo.service.ClientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class ClientControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ClientService clientService;

    @Test
    public void getAllClients_ReturnsListOfClients() throws Exception {

        Client client1 = new Client();
        client1.setName("Jose Lema");
        client1.setAddress("Otavalo sn y principal");
        client1.setPhone("098254785");
        client1.setPassword(1234);
        client1.setStatus(true);

        Client client2 = new Client();
        client1.setName("Marianela Montalvo");
        client1.setAddress("Amazonas y NNUU");
        client1.setPhone("097548965");
        client1.setPassword(5678);
        client1.setStatus(true);

        Client client3 = new Client();
        client1.setName("Juan Osorio");
        client1.setAddress("13 junio y Equinoccial");
        client1.setPhone("098874587");
        client1.setPassword(1245);
        client1.setStatus(true);


        List<Client> clients = Arrays.asList(client1, client2);

        mockMvc.perform(get("/api/v1/client")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}
