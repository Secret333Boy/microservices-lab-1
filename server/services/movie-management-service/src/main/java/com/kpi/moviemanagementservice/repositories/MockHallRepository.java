package com.kpi.moviemanagementservice.repositories;

import com.kpi.moviemanagementservice.models.Cinema;
import com.kpi.moviemanagementservice.models.Hall;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MockHallRepository {
    private Long id = 1L;
    private List<Hall> halls;

    public MockHallRepository(MockCinemaRepository mockCinemaRepository) {
        this.halls = new ArrayList<>();
        for (Cinema cinema : mockCinemaRepository.getCinemas()) {
            for (int i = 0; i < 3; i++) {
                halls.add(Hall.builder()
                        .id(id++)
                        .name("Hall " + (i + 1))
                        .cinema(cinema)
                        .build());
            }
        }
    }

    public List<Hall> getHalls() {
        return halls;
    }

    public Hall createHall(Hall hall) {
        hall.setId(id++);
        halls.add(hall);
        return hall;
    }

    public Hall updateHall(Hall hall) {
        for (int i = 0; i < halls.size(); i++) {
            if (halls.get(i).getId().equals(hall.getId())) {
                halls.set(i, hall);
                return hall;
            }
        }
        return null;
    }

    public Hall deleteHall(Long id) {
        for (int i = 0; i < halls.size(); i++) {
            if (halls.get(i).getId().equals(id)) {
                return halls.remove(i);
            }
        }
        return null;
    }
}
