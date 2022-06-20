package com.volvocars.repository;

import com.volvocars.model.Vehicle;
import com.volvocars.model.VehicleType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {

    Vehicle findByVehicleType(VehicleType vehicleType);

}
