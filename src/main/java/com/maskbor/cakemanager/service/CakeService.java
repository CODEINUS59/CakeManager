/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maskbor.cakemanager.service;

import com.maskbor.cakemanager.dto.CakeDto;
import com.maskbor.cakemanager.dto.CakeFilter;
import java.util.List;
import java.util.concurrent.CompletableFuture;

/**
 *
 * @author ran
 */
public interface CakeService {
    CompletableFuture<CakeDto> getItem(int id);
//    CompletableFuture<CakeView> getView(CakeFilter filter);
    CompletableFuture<Void> saveItem(CakeDto cake);
    CompletableFuture<Void> updateItem(CakeDto cake);
    CompletableFuture<Void> removeItem(CakeDto cake);
    CompletableFuture<Long> getTotal(CakeFilter filter);
}
