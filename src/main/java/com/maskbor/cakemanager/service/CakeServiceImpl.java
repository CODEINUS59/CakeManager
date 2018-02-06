/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maskbor.cakemanager.service;

import com.maskbor.cakemanager.dto.CakeDto;
import com.maskbor.cakemanager.dto.CakeFilter;
import java.util.concurrent.CompletableFuture;
import org.springframework.stereotype.Service;

/**
 *
 * @author ran
 */
@Service
public class CakeServiceImpl implements CakeService{

    @Override
    public CompletableFuture<CakeDto> getItem(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompletableFuture<Void> saveItem(CakeDto cake) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompletableFuture<Void> updateItem(CakeDto cake) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompletableFuture<Void> removeItem(CakeDto cake) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public CompletableFuture<Long> getTotal(CakeFilter filter) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
