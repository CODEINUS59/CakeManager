/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.maskbor.cakemanager.repository;

import com.maskbor.cakemanager.model.StatusType;

/**
 *
 * @author root
 */
public class CakeFilter {
    int page=1, limit=5;
    String text=null;
    StatusType[] statuses={};

    public CakeFilter(int page, int limit, String text, StatusType[] statuses) {
        this.page = page;
        this.limit = limit;
        this.text = text;
        this.statuses = statuses;
    }
    
    
    
    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public StatusType[] getStatuses() {
        return statuses;
    }

    public void setStatuses(StatusType[] statuses) {
        this.statuses = statuses;
    }
       
    public CakeFilter getFilter(){
        return this;
    }
}
