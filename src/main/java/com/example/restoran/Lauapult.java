

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class Lauapult {

    @GetMapping("/api/lauad")
    public List<Laud> getLauad() {

        List<Laud> lauad = List.of(

        new Laud(1, 6, List.of("akna all", "siseruum"), 891, 411),
        new Laud(2, 6, List.of("akna all", "siseruum"), 784, 415),
        new Laud(3, 6, List.of("akna all", "siseruum"), 674, 412),
        new Laud(4, 2, List.of("akna all", "siseruum"), 584, 434),
        new Laud(5, 3, List.of("akna all", "siseruum"), 499, 439),
        new Laud(6, 4, List.of("akna all", "siseruum"), 413, 414),
        new Laud(7, 6, List.of("akna all", "siseruum"), 300, 414),
        new Laud(8, 2, List.of("siseruum"), 887, 248),
        new Laud(9, 2, List.of("siseruum"), 805, 250),
        new Laud(10, 6, List.of("siseruum"), 860, 312),
        new Laud(11, 8, List.of("siseruum"), 658, 288),
        new Laud(12, 4, List.of("lastenurga lähedal", "siseruum"), 906, 148),
        new Laud(13, 3, List.of("lastenurga lähedal", "siseruum"), 802, 137),
        new Laud(14, 4, List.of("lastenurga lähedal", "siseruum"), 620, 147),
        new Laud(15, 14, List.of("siseruum", "privaatruum"), 402, 204),
        new Laud(16, 4, List.of("terrass"), 139, 332),
        new Laud(17, 4, List.of("terrass"), 55, 336),
        new Laud(18, 2, List.of("terrass"), 210, 231),
        new Laud(19, 4, List.of("terrass"), 138, 231),
        new Laud(20, 4, List.of("terrass"), 53, 235)
        );

        return lauad;
    }

    static class Laud {
        private int id;
        private int kohad;
        private List<String> tsoon;
        private double x;
        private double y;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getKohad() {
            return kohad;
        }

        public void setKohad(int kohad) {
            this.kohad = kohad;
        }

        public List<String> getTsoon() {
            return tsoon;
        }

        public void setTsoon(List<String> tsoon) {
            this.tsoon = tsoon;
        }

        public double getX() {
            return x;
        }

        public void setX(double x) {
            this.x = x;
        }

        public double getY() {
            return y;
        }

        public void setY(double y) {
            this.y = y;
        }

        public Laud(int id, int kohad, List<String> tsoon, double x, double y) {
            this.id = id;
            this.kohad = kohad;
            this.tsoon = tsoon;
            this.x = x;
            this.y = y;
        }
    }

}
