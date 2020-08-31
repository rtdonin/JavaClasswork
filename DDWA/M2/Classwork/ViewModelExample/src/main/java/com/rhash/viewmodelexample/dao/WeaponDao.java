/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rhash.viewmodelexample.dao;

import com.rhash.viewmodelexample.dto.Weapon;
import java.util.List;

/**
 *
 * @author rhash
 */
public interface WeaponDao {

    public List<Weapon> GetAllWeapons();

    public Weapon GetWeaponByName(String name);

    public Weapon AddWeapon(Weapon weapon);

    public Weapon EditWeapon(Weapon weapon);

    public void DeteleWeaponByName(String name);
}
