package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n03.model.service;

import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n03.model.dto.FlowerDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FlowerService implements FlowerServiceInterface{

    private final RestTemplate restTemplate;
    @Value("${spring.external.service.base-url}")
    private String basePath;

    public List<FlowerDTO> getFlowers() {
        FlowerDTO[] response = restTemplate.getForObject(basePath + "/getAll", FlowerDTO[].class);
        return Arrays.asList(response);
    }

    public void createFlower (FlowerDTO flowerDTO) {
        restTemplate.postForObject(basePath + "/flowers", flowerDTO, FlowerDTO.class);
    }

    public void updateFlower (int id, FlowerDTO flowerDTO) {

    }

    public void deleteUser (int id) {

    }
}
