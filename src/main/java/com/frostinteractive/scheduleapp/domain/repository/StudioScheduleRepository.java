package com.frostinteractive.scheduleapp.domain.repository;

import com.frostinteractive.scheduleapp.domain.StudioSchedule;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface StudioScheduleRepository extends CrudRepository<StudioSchedule,String> {

    Optional<StudioSchedule> findByStudioNameAndDate(String studioName, LocalDate localDate);

}
