package com.micro.restaurantlisting.controller;

import com.micro.restaurantlisting.dto.RestaurantDTO;
import com.micro.restaurantlisting.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurants")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurants() {
        List<RestaurantDTO> lst = restaurantService.fetchAllRestaurats();
        return new ResponseEntity<List<RestaurantDTO>>(lst, HttpStatus.OK);
    }
    @PostMapping("/addRestaurant")
    public ResponseEntity<String> addRestaurant(@RequestBody RestaurantDTO restaurantDTO) {
        Integer id = restaurantService.addRestaurant(restaurantDTO);
        String msg = "restaurant added successfully with the id " + id;
        return new ResponseEntity<>(msg, HttpStatus.CREATED);
    }

    @GetMapping("/fetchByid/{id}")
    public ResponseEntity<RestaurantDTO> fetchRestauarantById(@PathVariable Integer id) {
        RestaurantDTO restaurantDTO1 = restaurantService.fetchRestaurantById(id);
        return new ResponseEntity<>(restaurantDTO1, HttpStatus.OK);
    }

}
