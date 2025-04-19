package com.micro.restaurantlisting.service;

import com.micro.restaurantlisting.dto.RestaurantDTO;
import com.micro.restaurantlisting.entity.Restaurant;
import com.micro.restaurantlisting.repo.RestaurantRepo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;


import static org.mockito.Mockito.when;


public class RestaurantServiceTest {

    @InjectMocks
    RestaurantServiceImpl restaurantServiceImpl;

    @Mock
    RestaurantRepo restaurantRepo;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchAllRestaurants(){

        Iterable<Restaurant> restaurants = Arrays.asList(
                new Restaurant(101, "gourmat", "ajmer road", "jaipur", "nice"),
                new Restaurant(102, "flavourant", "mansarover", "jaipur","nyc place")
        );
        when(restaurantRepo.findAll()).thenReturn(restaurants);

        List<RestaurantDTO> restaurantDTOS = restaurantServiceImpl.fetchAllRestaurats();


        assertEquals("ajmer road", restaurantDTOS.get(0).getAddress());
        assertEquals("mansarover", restaurantDTOS.get(1).getAddress());
    }

    @Test
    public void testFetchRestaurantById(){

        Restaurant restaurant = new Restaurant(101, "gourmat", "ajmer road", "jaipur", "nice");
        when(restaurantRepo.findById(101)).thenReturn(Optional.of(restaurant));

        RestaurantDTO restaurantDTO = restaurantServiceImpl.fetchRestaurantById(101);

        assertEquals("jaipur", restaurantDTO.getCity());
    }
}
