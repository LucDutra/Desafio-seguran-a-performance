package com.infoSecurity.service;

import com.infoSecurity.dto.DadosBaseCDto;
import org.springframework.stereotype.Service;

@Service
public class BaseCService {


    public DadosBaseCDto recuperaDados() {

        return DadosBaseCDto.build();
    }

}
