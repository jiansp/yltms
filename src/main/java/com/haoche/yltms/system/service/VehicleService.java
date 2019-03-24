package com.haoche.yltms.system.service;

import com.haoche.yltms.system.model.User;
import com.haoche.yltms.system.model.Vehicle;
import org.springframework.data.domain.Page;

import java.util.Map;

public interface VehicleService {
    Page<Vehicle> findVehicles(Integer page, Integer limit, Map<String, String> params);

    void saveAndUpdate(Vehicle vehicle, User user);
}
