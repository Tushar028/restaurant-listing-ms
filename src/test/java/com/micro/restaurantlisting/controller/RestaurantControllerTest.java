package com.micro.restaurantlisting.controller;

import com.micro.restaurantlisting.dto.RestaurantDTO;
import com.micro.restaurantlisting.service.RestaurantService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static org.junit.jupiter.api.Assertions.assertEquals;


import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.when;

public class RestaurantControllerTest {

    @InjectMocks
    RestaurantController restaurantController;

    @Mock
    RestaurantService restaurantService;

    @BeforeEach
    public void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFetchAllRestaurants(){

        List<RestaurantDTO> restaurants = Arrays.asList(
                new RestaurantDTO(1, "restaurant1", "addr1", "jaipur", "descprition1"),
                new RestaurantDTO(2, "restaurant2", "addr2", "mumbai", "description2"));

        when(restaurantService.fetchAllRestaurats()).thenReturn(restaurants);

        ResponseEntity<List<RestaurantDTO>> response = restaurantController.fetchAllRestaurants();

        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(restaurants, response.getBody());
    }

}
