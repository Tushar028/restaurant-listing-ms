package com.micro.restaurantlisting.service;

import com.micro.restaurantlisting.dto.RestaurantDTO;

import java.util.List;

public interface RestaurantService {


    public List<RestaurantDTO> fetchAllRestaurats();

    public Integer addRestaurant(RestaurantDTO restaurantDTO);

    public RestaurantDTO fetchRestaurantById(Integer id);
}
