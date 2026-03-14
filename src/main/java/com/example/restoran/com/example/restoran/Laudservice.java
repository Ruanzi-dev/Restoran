/*
Siit kõik java keelega meetodid suutsin ise luua. Kui hätta jäin proovisin leida abi googeldamisega.
 */

package com.example.restoran;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Siia lisasin kõik lauad ning, kus nad pildi peal paiknevad. Lihtsamaks järjestuseks lisasin id-numbrid.
 */
@Service
public class Laudservice {
    List<Laud> lauad = List.of(
                    new Laud(1, 6, List.of("akna all", "siseruum"), 876, 375, 33, 71, "ruut"),
                    new Laud(2, 6, List.of("akna all", "siseruum"), 769, 377, 31, 73, "ruut"),
                    new Laud(3, 6, List.of("akna all", "siseruum"), 661, 375, 31, 72, "ruut"),
                    new Laud(4, 2, List.of("akna all", "siseruum"), 571, 423, 29, 24, "ruut"),
                    new Laud(5, 3, List.of("akna all", "siseruum"), 483, 424, 30, 23, "ruut"),
                    new Laud(6, 4, List.of("akna all", "siseruum"), 389, 403, 45, 22, "ruut"),
                    new Laud(7, 6, List.of("akna all", "siseruum"), 255, 402, 99, 23, "ruut"),
                    new Laud(8, 2, List.of("siseruum"), 874, 233, 25, 34, "ruut"),
                    new Laud(9, 2, List.of("siseruum"), 797, 233, 21, 31, "ruut"),
                    new Laud(10, 6, List.of("siseruum"), 806, 302, 101, 20, "ruut"),
                    new Laud(11, 8, List.of("siseruum"), 634, 265, 50, 50, "ring"),
                    new Laud(12, 4, List.of("lastenurga lähedal", "siseruum"), 895, 127, 25, 50, "ruut"),
                    new Laud(13, 3, List.of("lastenurga lähedal", "siseruum"), 789, 126, 29, 23, "ruut"),
                    new Laud(14, 4, List.of("lastenurga lähedal", "siseruum"), 607, 128, 22, 41, "ruut"),
                    new Laud(15, 14, List.of("siseruum", "privaatruum"), 316, 179, 164, 52, "ruut"),
                    new Laud(16, 4, List.of("terrass"), 130, 315, 20, 36, "ruut"),
                    new Laud(17, 4, List.of("terrass"), 42, 312, 20, 41, "ruut"),
                    new Laud(18, 2, List.of("terrass"), 197, 212, 25, 36, "ring"),
                    new Laud(19, 4, List.of("terrass"), 128, 212, 24, 39, "ruut"),
                    new Laud(20, 4, List.of("terrass"), 42, 215, 24, 40, "ruut")
            );



    /**
     * Genereerib lauad suvaliselt. Suvaline arv laudu ja suvalised lauad.
     * @param kuupaev
     * @param kellaaeg
     * @return hõivatud laudade massiivi
     * fori tsükkel käib kuni suvalise numbrini.
     * suvaline number genereeritakse math.randomiga.
     * kui laua id on võrdne suvalise numbriga ja laud pole hõivatud laua massiivis, siis lauid lisatakse sinna.
     */

    public ArrayList<Laud> genereeri_kinnisedlauad(String kuupaev, String kellaaeg) {
        ArrayList<Laud> hoivatud = new ArrayList<>();
        for (int i = 0; i < (int) (Math.random() * lauad.size()); i++) {
            int suvaline_number = (int) (Math.random() * lauad.size()) + 1;
            for (Laud hoivatud_laud : lauad) {
                if (hoivatud_laud.getId() == suvaline_number && !hoivatud.contains(hoivatud_laud)) {
                    hoivatud.add(hoivatud_laud);
                }
            }
        }
        return hoivatud;
    }

    /**
     * soovitab laudu, mis on vabad veel ning mis sobivad kasutaja sisenditega kokku.
     * @param hoivatud
     * @param inimesed
     * @param kellaaeg
     * @param kuupaev
     * @param tsoon
     * kui laua id on hoivatud laua massiivis, siis tõeväärtus muudetakse tõeseks.
     * kui laual on kohti sama palju kui inimesi on soovitud või kohti on rohkem kui inimesi,
     * ja kui tsoon on jäetud tühjaks või tsoon kattub kasutaja sooviga, siis salvestatakse see sobivate laudade massiivi.
     */

    public ArrayList<Laud> soovita_lauad(int inimesed, ArrayList<Laud> hoivatud, String tsoon, String kuupaev, String kellaaeg) {
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







