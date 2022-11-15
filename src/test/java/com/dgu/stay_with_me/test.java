package com.dgu.stay_with_me;

import com.dgu.stay_with_me.repository.BookRepository;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.logging.Logger;

public class test {
    LocalDateTime start = LocalDateTime.of(LocalDate.now().minusDays(1), LocalTime.of(0,0,0));
    LocalDateTime end = LocalDateTime.of(LocalDate.now(), LocalTime.of(23,59,59));


}
