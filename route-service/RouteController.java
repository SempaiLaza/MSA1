package bsuir.laza.routeservice.controllers;

import bsuir.laza.routeservice.entities.RouteInputDto;
import bsuir.laza.routeservice.service.RouteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class RouteController {
    private final RouteService routeService;

    @PostMapping("/api/calculate-route")
    public void calculateRoute(@RequestBody RouteInputDto input) {
        routeService.calculateRoute(input);
    }
}
