/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.gl.master.controller.vehicle;

import com.mac.gl.master.model.vehicle.Vehicle;
import com.mac.gl.master.service.vehicle.VehicleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Supervision
 */
@CrossOrigin
@RestController
@RequestMapping("/api/green-leaves/master/vehicle")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Vehicle> findAll() {
        return vehicleService.findAll();
    }

    @RequestMapping(value = "/insert-detail", method = RequestMethod.POST)
    public Vehicle insertPriceCategory(@RequestBody Vehicle vehicle) {
        return vehicleService.saveDetail(vehicle);
    }

    @RequestMapping(value = "/delete-detail/{indexNo}", method = RequestMethod.DELETE)
    public Integer delete(@PathVariable Integer indexNo) {
        vehicleService.deleteDetail(indexNo);
        return indexNo;
    }
}
