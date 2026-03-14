package com.example.restoran;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Map;
import java.util.Objects;

/**
 *Siin osas kasutasin keeltemudelite abi
 */
@RestController
@RequestMapping("/api")
public class LaudController {
    private Laudservice laudservice;

    public LaudController(Laudservice laudservice) {
        this.laudservice = laudservice;
    }

    @GetMapping("/soovitatavad-lauad")
    public Map<String, Object> Leialaud(
            @RequestParam int inimesed,
            @RequestParam(required = false, defaultValue = "") String tsoon,
            @RequestParam(required = false) String kuupaev,
                    @RequestParam(required = false) String kellaaeg) {

        ArrayList<Laud> kinni = laudservice.genereeri_kinnisedlauad(kuupaev, kellaaeg);

        ArrayList<Laud> sobivad = laudservice.soovita_lauad(inimesed, kinni, tsoon,kuupaev,kellaaeg);
        return Map.of("kinni", kinni, "sobivad", sobivad);
    }

}


