package com.example.routing.evroutingapi.model
import jakarta.persistence.Entity
import jakarta.persistence.EntityManager
import jakarta.persistence.Id
import jakarta.persistence.PersistenceContext
import org.springframework.stereotype.Service

@Service
class RouteModel(@PersistenceContext private val entityManager: EntityManager) {
    fun calculateRoutes(
        startLatitude: Double,
        startLongitude: Double,
        endLatitude: Double,
        endLongitude: Double,
        currentBatteryLevel: Double,
        totalBatteryCapacity: Double,
        carEfficiency: Double
    ): List<Route> {
        val query = entityManager.createNativeQuery("SELECT * FROM calculate_routes(?, ?, ?, ?, ?, ?, ?)")
        query.setParameter(1, startLatitude)
        query.setParameter(2, startLongitude)
        query.setParameter(3, endLatitude)
        query.setParameter(4, endLongitude)
        query.setParameter(5, currentBatteryLevel)
        query.setParameter(6, totalBatteryCapacity)
        query.setParameter(7, carEfficiency)

        return query.resultList as List<Route>
}

@Entity
class Route(
    @Id
    val routeId: Int,
    val routeDetails: String,
    val totalTime: Double
)
}