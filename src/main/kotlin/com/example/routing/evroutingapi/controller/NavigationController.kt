package com.example.routing.evroutingapi.controller

import com.example.routing.evroutingapi.model.RouteModel
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.lang.Double.parseDouble

@RestController
class NavigationController(private val routeModel: RouteModel) {

    @GetMapping("/navigate")
    fun navigate(
        @RequestParam startLatitude: String,
        @RequestParam startLongitude: String,
        @RequestParam endLatitude: String,
        @RequestParam endLongitude: String,
        @RequestParam currentBatteryLevel: String,
        @RequestParam totalBatteryCapacity: String,
        @RequestParam carEfficiency: String
    ): ResponseEntity<Any> {
//        return ResponseEntity.ok("Navigation endpoint accessed")
        try {
            var result = routeModel.calculateRoutes(
                parseDouble(startLatitude),
                parseDouble(startLongitude),
                parseDouble(endLatitude),
                parseDouble(endLongitude),
                parseDouble(currentBatteryLevel),
                parseDouble(totalBatteryCapacity),
                parseDouble(carEfficiency)
            )
            return ResponseEntity.ok(result)
        } catch (e: NumberFormatException) {
            // Handle the case where conversion to double fails
            return ResponseEntity.badRequest().body("Invalid input: one of the parameters could not be converted to a number.")
        }
    }
}