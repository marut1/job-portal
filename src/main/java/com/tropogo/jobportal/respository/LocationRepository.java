package com.tropogo.jobportal.respository;

import com.tropogo.jobportal.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface LocationRepository extends JpaRepository<Location, UUID> {

    List<Location> findByOrderByCityAsc();
}
