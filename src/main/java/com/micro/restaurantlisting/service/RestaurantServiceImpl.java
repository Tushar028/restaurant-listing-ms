package com.micro.restaurantlisting.service;

import com.micro.restaurantlisting.dto.RestaurantDTO;
import com.micro.restaurantlisting.entity.Restaurant;
import com.micro.restaurantlisting.repo.RestaurantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RestaurantServiceImpl implements RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;

    @Override
    public List<RestaurantDTO> fetchAllRestaurats() {
         Iterable<Restaurant> ls = restaurantRepo.findAll();
         List<RestaurantDTO> lst = new ArrayList<>();
         ls.forEach(s -> {
              RestaurantDTO restaurantDTO = new RestaurantDTO();
              restaurantDTO.setId(s.getId());
              restaurantDTO.setName(s.getName());
              restaurantDTO.setAddress(s.getAddress());
              restaurantDTO.setRestaurantDescription(s.getRestaurantDescription());
              restaurantDTO.setCity(s.getCity());
              lst.add(restaurantDTO);
         });
        return lst;
    }

    @Override
    public Integer addRestaurant(RestaurantDTO restaurantDTO) {

        Restaurant restaurant = new Restaurant();
        restaurant.setName(restaurantDTO.getName());
        restaurant.setCity(restaurantDTO.getCity());
        restaurant.setAddress(restaurantDTO.getAddress());
        restaurant.setRestaurantDescription(restaurantDTO.getRestaurantDescription());
 //       restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));

        return restaurantRepo.save(restaurant).getId();
    }

    @Override
    public RestaurantDTO fetchRestaurantById(Integer id) {
        Optional<Restaurant> op = restaurantRepo.findById(id);
        Restaurant restaurant = op.get();
        RestaurantDTO restaurantDTO = new RestaurantDTO();
        restaurantDTO.setCity(restaurant.getCity());
        restaurantDTO.setName(restaurant.getName());
        restaurantDTO.setAddress(restaurantDTO.getAddress());
        restaurantDTO.setRestaurantDescription(restaurant.getRestaurantDescription());
        return restaurantDTO;
    }
}
