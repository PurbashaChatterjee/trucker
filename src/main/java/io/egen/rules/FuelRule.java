package io.egen.rules;

import io.egen.entity.Alert;
import io.egen.entity.Reading;
import io.egen.entity.Vehicle;
import io.egen.repository.AlertRepository;
import io.egen.repository.VehicleRepository;
import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.jeasy.rules.core.BasicRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;

@Rule(name = "Low Fuel Rule", description = "If fuel < 10%Max then fire an alert")
@Component
public class FuelRule extends BasicRule {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    private AlertRepository alertRepository;

    @Condition
    public boolean lowFuel(@Fact("fuel") Reading reading) {

        Optional<Vehicle> existing = vehicleRepository.findByVin(reading.getVin());
        return existing.filter(vehicle -> reading.getFuelVolume() < 0.1 * vehicle.getMaxFuelVolume()).isPresent();
    }

    @Action
    public void lowFuelAlert(@Fact("fuel") Reading reading) {
        Date date = new Date(reading.getTimestamp());
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss.s");
        Alert alert = new Alert();
        alert.setVin(reading.getVin());
        alert.setPriority("MEDIUM");
        alert.setDescription("Low Fuel");
        alert.setTimestamp(new Date(df.format(date)));
        alertRepository.save(alert);
    }

}
