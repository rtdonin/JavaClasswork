/*
Created by: Margaret Donin
Date created: 08/24/20
Date revised:
*/

package com.rhash.viewmodelexample.controller;

import com.rhash.viewmodelexample.dto.Weapon;
import com.rhash.viewmodelexample.dto.WeaponVM;
import com.rhash.viewmodelexample.service.WeaponService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rhash
 */
@RestController
@RequestMapping("/weapon")
public class WeaponVMCotnroller {
    @Autowired
    WeaponService service;

    @GetMapping
    public List<WeaponVM> getAll() {
        return service.GetAllWeaponsVM();
    }
    
    @GetMapping("/{name}")
    public Weapon getByName(@PathVariable String name){
        return service.GetWeaponByName(name);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Weapon createWeapon(@RequestBody Weapon weapon) {
        return service.AddWeapon(weapon);
    }

    @PutMapping("/{name}")
    public Weapon updateWeapon(@PathVariable String name, @RequestBody Weapon weapon) {
        if (!name.equals(weapon.getName())) {
            service.RemoveWeaponByName(name);
        }
        return service.EditWeapon(weapon);
    }

    @DeleteMapping("{name}")
    public ResponseEntity deleteWeapon(@PathVariable String name) {
        service.RemoveWeaponByName(name);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }
}