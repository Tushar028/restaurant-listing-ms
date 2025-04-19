package com.micro.restaurantlisting.repo;

import com.micro.restaurantlisting.entity.Restaurant;
import org.springframework.data.repository.CrudRepository;

public interface RestaurantRepo extends CrudRepository<Restaurant, Integer> {

}
