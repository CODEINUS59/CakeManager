/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maskbor.cakemanager.repository;

import com.maskbor.cakemanager.model.Cake;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author root
 */
public interface CakeRepository {
    CompletableFuture<Cake> getItem(int id);
    CompletableFuture<List<Cake>> getRange(CakeFilter filter);
    CompletableFuture<Void> addItem(Cake cake);
    CompletableFuture<Void> updateItem(Cake cake);
    CompletableFuture<Void> removeItem(Cake cake);
    CompletableFuture<Long> getTotal(CakeFilter filter);
}
