package ru.practicum.server.mapper;

import lombok.experimental.UtilityClass;
import ru.practicum.dto.EndpointHitDto;
import ru.practicum.dto.ViewStatsDto;
import ru.practicum.server.model.EndpointHit;
import ru.practicum.server.model.ViewStats;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class StatMapper {
    public static ViewStats toObject(ViewStatsDto viewStatsDto) {
        return ViewStats.builder()
                .app(viewStatsDto.getApp())
                .uri(viewStatsDto.getUri())
                .hits(viewStatsDto.getHits()).build();
    }

    public static ViewStatsDto toDto(ViewStats viewStats) {
        return ViewStatsDto.builder()
                .app(viewStats.getApp())
                .uri(viewStats.getUri())
                .hits(viewStats.getHits()).build();
    }

    public static EndpointHit toObject(EndpointHitDto endpointHitDto) {
        return EndpointHit.builder()
                .id(endpointHitDto.getId())
                .app(endpointHitDto.getApp())
                .uri(endpointHitDto.getUri())
                .ip(endpointHitDto.getIp())
                .timestamp(endpointHitDto.getTimestamp()).build();
    }

    public static EndpointHitDto toDto(EndpointHit endpointHit) {
        return EndpointHitDto.builder()
                .id(endpointHit.getId())
                .app(endpointHit.getApp())
                .uri(endpointHit.getUri())
                .ip(endpointHit.getIp())
                .timestamp(endpointHit.getTimestamp()).build();
    }

    public static List<ViewStatsDto> toViewStatsDto(List<ViewStats> viewStats) {
        return viewStats.stream().map(StatMapper::toDto).collect(Collectors.toList());
    }
}
