/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maskbor.cakemanager.service;

import com.maskbor.cakemanager.repository.CakeRepositoryImpl;
import com.maskbor.cakemanager.repository.CakeFilter;
import com.maskbor.cakemanager.repository.CakeRepository;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author ran
 */
public interface CakeService {
    CompletableFuture<CakeRepository> getItem(int id);
//    CompletableFuture<CakeView> getView(CakeFilter filter);
    CompletableFuture<Void> saveItem(CakeRepository cake);
    CompletableFuture<Void> updateItem(CakeRepository cake);
    CompletableFuture<Void> removeItem(CakeRepository cake);
    CompletableFuture<Long> getTotal(CakeFilter filter);
}
