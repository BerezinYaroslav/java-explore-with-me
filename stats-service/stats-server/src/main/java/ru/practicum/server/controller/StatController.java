package ru.practicum.server.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import ru.practicum.dto.EndpointHitDto;
import ru.practicum.dto.ViewStatsDto;
import ru.practicum.server.service.StatService;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class StatController {
    private final StatService service;
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    @PostMapping("/hit")
    public void saveStat(@RequestBody EndpointHitDto endpointHitDto) {
        log.info("New POST /hit request");
        service.saveStat(endpointHitDto);
    }

    @GetMapping("/hit")
    public List<EndpointHitDto> getAllStats() {
        log.info("New Get /hit request");
        return service.getAll();
    }

    @GetMapping("/stats")
    public List<ViewStatsDto> getStats(@RequestParam @DateTimeFormat(pattern = DATE_FORMAT) LocalDateTime start,
                                       @RequestParam @DateTimeFormat(pattern = DATE_FORMAT) LocalDateTime end,
                                       @RequestParam List<String> uris,
                                       @RequestParam(defaultValue = "false") Boolean unique) {
        log.info("New GET /stats request");
        return service.getStats(start, end, uris, unique);
    }
}
