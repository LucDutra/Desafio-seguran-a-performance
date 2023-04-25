package com.infoSecurity.service;

import com.infoSecurity.dto.DadosBaseADto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BaseAService {

    @Autowired
    TokenService tokenService;


    public DadosBaseADto recuperaDados() {

         return  DadosBaseADto.build();
    }
}
