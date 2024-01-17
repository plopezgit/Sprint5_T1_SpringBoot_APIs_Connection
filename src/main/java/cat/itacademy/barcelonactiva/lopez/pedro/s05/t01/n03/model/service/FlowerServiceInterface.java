package cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n03.model.service;

import cat.itacademy.barcelonactiva.lopez.pedro.s05.t01.n03.model.dto.FlowerDTO;

import java.util.List;

public interface FlowerServiceInterface {

    public List<FlowerDTO> getFlowers();
    public void createFlower (FlowerDTO flowerDTO);
    public void updateFlower (int id, FlowerDTO flowerDTO);
    public void deleteUser (int id);
}
