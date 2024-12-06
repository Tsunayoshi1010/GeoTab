package com.GeoTab.GeoTab.Users.services.imp;

import com.GeoTab.GeoTab.Users.DTO.RequestRoad;
import com.GeoTab.GeoTab.Users.entities.Road;
import com.GeoTab.GeoTab.Users.entities.User;
import com.GeoTab.GeoTab.Users.repositories.IRoadRepositorty;
import com.GeoTab.GeoTab.Users.repositories.IUserRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
public class RoadService {
    private final IRoadRepositorty roadRepository;
    private final IUserRepository userRepository;

    public RoadService(IRoadRepositorty roadRepository, IUserRepository userRepository) {
        this.roadRepository = roadRepository;
        this.userRepository = userRepository;
    }

    @Transactional
    public double calculateFuelConsumption(RequestRoad requestRoad) {

        LocalDateTime startTime = requestRoad.getStartTime();
        boolean isDaytime = startTime.getHour() >= 6 && startTime.getHour() < 18;

        String fuelType = requestRoad.getFuelType().toString();
        String vehicleType = requestRoad.getVehicleType().toString();

        Long userId = requestRoad.getUserId();

        User user = userRepository.findById(userId).orElseThrow(()->new RuntimeException("Error IdUser"));
        System.out.println("este es el id user : "+user);

        Road road = new Road();
        road.setUser(user);
        road.setFuelType(requestRoad.getFuelType());
        road.setVehicleType(requestRoad.getVehicleType());
        road.setStartTime(requestRoad.getStartTime());
        road.setKilometers(requestRoad.getKilometers());
        road.setLatitude(requestRoad.getLatitude());
        road.setLength(requestRoad.getLength());
        road.setCity(requestRoad.getCity());
        road.setRoadCondition(requestRoad.getRoadCondition());

        // Lógica de cálculo de consumo base según el tipo de vehículo y combustible
        double baseConsumption = getBaseConsumption(vehicleType, fuelType);

        // Ajuste según si es de día o de noche
        if (!isDaytime) {
            baseConsumption *= 1.1;  // Ajuste de 10% si es de noche
        }

        // Ajustar por los kilómetros recorridos (por ejemplo, si 1 km consume una cantidad extra)
        double consumptionForDistance = baseConsumption * (requestRoad.getKilometers() / 100);

        // Calcular el consumo final
        double finalConsumption = baseConsumption + consumptionForDistance;

        // Asignar el cálculo final al objeto Road
        road.setKilometers(consumptionForDistance);

        roadRepository.save(road);  // Guardar el objeto Road en la base de datos

        return finalConsumption;
    }

    // Método para obtener el consumo base según el tipo de vehículo y combustible
    private double getBaseConsumption(String vehicleType, String fuelType) {
        switch (vehicleType) {
            case "AUTOMOVIL":
                return switch (fuelType) {
                    case "DIESEL" -> 52;
                    case "GASOLINA" -> 40;
                    case "GAS_NATURAL" -> 13;
                    default -> 0;
                };
            case "CAMIONETA":
                return switch (fuelType) {
                    case "DIESEL" -> 29;
                    case "GASOLINA" -> 22;
                    case "GAS_NATURAL" -> 12;
                    default -> 0;
                };
            case "MOTOCICLETA":
                return fuelType.equals("GASOLINA") ? 99 : 0;
            case "MOTOCARGA":
                return switch (fuelType) {
                    case "DIESEL" -> 128;
                    case "GAS NATURAL" -> 10;
                    default -> 0;
                };
            case "TAXI":
                return switch (fuelType) {
                    case "DIESEL" -> 65;
                    case "GASOLINA" -> 50;
                    case "GAS_NATURAL" -> 13;
                    default -> 0;
                };
            case "CAMION":
                return switch (fuelType) {
                    case "DIESEL" -> 12;
                    case "GASOLINA" -> 10;
                    case "GAS_NATURAL" -> 5;
                    default -> 0;
                };
            case "TRACTOCAMION":
                return switch (fuelType) {
                    case "DIESEL" -> 8;
                    case "GASOLINA" -> 6;
                    case "GAS_NATURAL" -> 2;
                    default -> 0;
                };
            default:
                return 0;
        }
    }
}
