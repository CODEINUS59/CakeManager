package com.maskbor.cakemanager.service;

import com.maskbor.cakemanager.repository.CakeRepositoryImpl;
import com.maskbor.cakemanager.repository.CakeFilter;
import com.maskbor.cakemanager.repository.CakeRepository;
import com.maskbor.cakemanager.model.Cake;
import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CakeServiceImpl implements CakeService{

    @Autowired
    private CakeRepository cakeDto;

    public void setCakeDto(CakeRepositoryImpl cakeDto) {
        this.cakeDto = cakeDto;
    }
    
    @Override
    @Transactional(readOnly = true)
    public CompletableFuture<CakeRepository> getItem(int id) {
        return CompletableFuture.supplyAsync((Supplier<CakeRepository>)this.cakeDto.getItem(id));
    }

    @Override
    @Transactional
    public CompletableFuture<Void> saveItem(CakeRepository cake) {
        
        return CompletableFuture.runAsync((Runnable) this.cakeDto.addItem((Cake) cake));
    }

    @Override
    @Transactional
    public CompletableFuture<Void> updateItem(CakeRepository cake) {
        return CompletableFuture.runAsync((Runnable) this.cakeDto.updateItem((Cake) cake));
    }

    @Override
    @Transactional
    public CompletableFuture<Void> removeItem(CakeRepository cake) {
        return CompletableFuture.runAsync((Runnable) this.cakeDto.removeItem((Cake) cake));
    }

    @Override
    @Transactional
    public CompletableFuture<Long> getTotal(CakeFilter filter) {
        return CompletableFuture.supplyAsync((Supplier<Long>)this.cakeDto.getTotal(filter));
    }
    
}
