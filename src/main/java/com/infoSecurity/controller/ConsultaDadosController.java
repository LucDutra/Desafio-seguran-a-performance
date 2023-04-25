package com.infoSecurity.controller;

import com.infoSecurity.dto.DadosBaseADto;
import com.infoSecurity.dto.DadosBaseBDto;
import com.infoSecurity.dto.DadosBaseCDto;
import com.infoSecurity.service.BaseAService;
import com.infoSecurity.service.BaseBService;
import com.infoSecurity.service.BaseCService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultaDados")
public class ConsultaDadosController {

    @Autowired
    BaseAService baseAService;

    @Autowired
    BaseBService baseBService;

    @Autowired
    BaseCService baseCService;

    @GetMapping("/consultaBaseA")
    public DadosBaseADto consultaBaseA() {

        return baseAService.recuperaDados();
    }


    @GetMapping("/consultaBaseB")
    public DadosBaseBDto consultaBaseB() {

        return baseBService.recuperaDados();
    }

    @GetMapping("/consultaBaseC")
    public DadosBaseCDto consultaBaseC() {

        return baseCService.recuperaDados();
    }

}
