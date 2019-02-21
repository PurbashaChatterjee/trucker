package io.egen.service;

import io.egen.entity.Alert;

import java.util.List;

public interface AlertService {

    List<Alert> findAlertsByPriority(String priority);

    List<Alert> findAlertsByVin(String vin);

    Alert create(Alert alert);
}
