package com.infoSecurity.service;

import com.infoSecurity.dto.DadosBaseBDto;
import org.springframework.stereotype.Service;

@Service
public class BaseBService {


    public DadosBaseBDto recuperaDados() {

        return DadosBaseBDto.build();
    }

}
