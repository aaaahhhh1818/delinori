package com.noriteo.delinori.saleboard.service;

import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface TimeService {

    String getNow();

}
