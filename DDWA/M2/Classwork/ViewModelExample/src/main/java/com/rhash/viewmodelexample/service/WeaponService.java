/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rhash.viewmodelexample.service;

import com.rhash.viewmodelexample.dao.WeaponDao;
import com.rhash.viewmodelexample.dto.Weapon;
import com.rhash.viewmodelexample.dto.WeaponVM;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author rhash
 */
@Service
public class WeaponService {
    
    @Autowired 
    WeaponDao weaponDao;
    
    // //////////////////////////////////////////////////
    // Regular Model Methods
    public List<Weapon> GetAllWeapons(){
        return weaponDao.GetAllWeapons();
    }
    
    public Weapon GetWeaponByName(String name){
        return weaponDao.GetWeaponByName(name);
    }
    
    public Weapon AddWeapon(Weapon weapon){
        return weaponDao.AddWeapon(weapon);
    }
    
    public Weapon EditWeapon(Weapon weapon){
        return weaponDao.EditWeapon(weapon);
    }
    
    public void RemoveWeaponByName(String name){
        weaponDao.DeteleWeaponByName(name);
    }
    
    
    // //////////////////////////////////////////////////
    // Regular Model Methods
    public List<WeaponVM> GetAllWeaponsVM(){
        List<Weapon> weapons = weaponDao.GetAllWeapons();
        List<WeaponVM> weaponVMs = new ArrayList<WeaponVM>();
        
        for (Weapon weapon : weapons) {
            WeaponVM vm = convertToViewModel(weapon);
            weaponVMs.add(vm);
        }
        
        return weaponVMs;
    }
    
    private WeaponVM convertToViewModel(Weapon weapon) {
        WeaponVM weaponVM = new WeaponVM();
        
        weaponVM.setName(weapon.getName());
        weaponVM.setWeight(weapon.getWeight() + " lbs");
        weaponVM.setAttackPower(weapon.getAttackPower() + " power");
        
        String weaponDescription = "";
        
        weaponDescription += (weapon.isIsBeautiful()) ? "Beautiful " : "Ugly ";
        
        if (weapon.getWeight() < 10) {
            weaponDescription += "Light ";
        } else if (weapon.getWeight() < 50) {
            weaponDescription += "Medium ";
        } else {
            weaponDescription += "Heavy ";
        }
        
        weaponDescription += (weapon.isIsMagical()) ? "Magic " : "Physcial ";
        
        return weaponVM;
    }
}
