package com.frostinteractive.scheduleapp.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "studio_schedule")
public class StudioSchedule {

    @Id
    @Column(name = "studio_schedule_id")
    private String studioScheduleId = UUID.randomUUID().toString();

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "studio_name")
    private String studioName;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "studio_schedule_id")
    private List<StudioScheduleSlot> studioScheduleSlotList = new ArrayList<>();
}
