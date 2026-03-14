package com.example.restoran;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class Laudservice {
    List<Laud> lauad = List.of(
            new Laud(1, 6, List.of("akna all", "siseruum")),
            new Laud(2, 6, List.of("akna all", "siseruum")),
            new Laud(3, 6, List.of("akna all", "siseruum")),
            new Laud(4, 2, List.of("akna all", "siseruum")),
            new Laud(5, 3, List.of("akna all", "siseruum")),
            new Laud(6, 4, List.of("akna all", "siseruum")),
            new Laud(7, 6, List.of("akna all", "siseruum")),
            new Laud(8, 2, List.of("siseruum")),
            new Laud(9, 2, List.of("siseruum")),
            new Laud(10, 6, List.of("siseruum")),
            new Laud(11, 8, List.of("siseruum")),
            new Laud(12, 4, List.of("lastenurga lähedal", "siseruum")),
            new Laud(13, 3, List.of("lastenurga lähedal", "siseruum")),
            new Laud(14, 4, List.of("lastenurga lähedal", "siseruum")),
            new Laud(15, 14, List.of("siseruum", "privaatruum")),
            new Laud(16, 4, List.of("terrass")),
            new Laud(17, 4, List.of("terrass")),
            new Laud(18, 2, List.of("terrass")),
            new Laud(19, 4, List.of("terrass")),
            new Laud(20, 4, List.of("terrass"))
    );

    public ArrayList<Laud> genereeri_kinnisedlauad() {
        ArrayList<Laud> hoivatud = new ArrayList<>();
        for (int i = 0; i < (int) (Math.random() * 21) + 1; i++) {
            int suvaline_number = (int) (Math.random() * 21) + 1;
            for (Laud hoivatud_laud : lauad) {
                if (hoivatud_laud.getId() == suvaline_number && !hoivatud.contains(hoivatud_laud)) {
                    hoivatud.add(hoivatud_laud);
                }
            }
        }
        return hoivatud;
    }


    public ArrayList<Laud> soovita_lauad(int inimesed, ArrayList<Laud> hoivatud, String tsoon) {
        ArrayList<Laud> sobivad = new ArrayList<>();
        for (Laud potenstiaalne_laud : lauad) {
            boolean kasonkinni = false;
            for (Laud hoivatud_laud : hoivatud) {
                if (potenstiaalne_laud.getId() == hoivatud_laud.getId()) {
                    kasonkinni = true;
                    break;

                }
            }
            if (!kasonkinni && potenstiaalne_laud.getKohad() >= inimesed && (tsoon.isEmpty()||
                    potenstiaalne_laud.getTsoon().contains(tsoon))) {
                sobivad.add(potenstiaalne_laud);
            }

        }
        return sobivad;

    }

}







