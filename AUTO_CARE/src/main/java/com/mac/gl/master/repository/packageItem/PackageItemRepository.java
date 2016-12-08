/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mac.gl.master.repository.packageItem;

import com.mac.gl.master.model.packageItem.MPackageItem;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Nidura Prageeth
 */
public interface PackageItemRepository extends JpaRepository<MPackageItem, Serializable>{

    public List<MPackageItem> findByItemIndexNoAndPackagesIndexNo(Integer item, Integer packages);
    
}
