/*
Tegin javascripti koos keeltemudeleid kasutades.
 */
const lauad = document.querySelectorAll('.ruut, .ring');

let valitudLaud = null; // hoiab hetkel valitud lauda

lauad.forEach(l => {
    l.addEventListener('click', () => {
        // Kui laud on kinni, ära tee midagi
        if (l.classList.contains('kinni')) return;

        // Eemalda valitud klass eelmiselt lauast
        if (valitudLaud) valitudLaud.classList.remove('valitud');

        // Lisa valitud klass klikitud lauale
        l.classList.add('valitud');
        valitudLaud = l;

        console.log('Valitud laud:', l.dataset.laud);
    });
});

const restoranDiv = document.getElementById("restoran");

document.getElementById("otsi").addEventListener("click", () => {
    const inimesed = document.getElementById("inimesed").value;
    const tsoon = document.getElementById("tsoon").value;
    const kuupaev = document.getElementById("kuupaev").value;
    const kellaaeg = document.getElementById("kellaaeg").value;

    fetch(`/api/soovitatavad-lauad?inimesed=${inimesed}&tsoon=${encodeURIComponent(tsoon)}&kuupaev=${kuupaev}&kellaaeg=${kellaaeg}`)
        .then(res => res.json())
        .then(data => {
            // Eemaldame kõik eelnevalt loodud dünaamilised lauad
            document.querySelectorAll(".dünaamiline").forEach(d => d.remove());

            // Loome kinni lauad
            data.kinni.forEach(l => lisaLaud(l, "kinni"));

            // Loome vabad lauad
            data.sobivad.forEach(l => lisaLaud(l, ""));

            // Tsooni soovitus või suvaline laud
            let tsooniVabad = data.sobivad.filter(l => l.tsoon.includes(tsoon));
            let soovitatud;

            if (tsooniVabad.length > 0) {
                // tsoonis on vaba laud
                soovitatud = tsooniVabad[0];
            } else if (data.sobivad.length > 0) {
                // tsoonis pole vabu, vali juhuslik vaba laud
                const randomIndex = Math.floor(Math.random() * data.sobivad.length);
                soovitatud = data.sobivad[randomIndex];
            }

            // Märgime valitud laua
            if (soovitatud) {
                const div = document.querySelector(`.dünaamiline[data-laud="${soovitatud.id}"]`);
                if (div) {
                    div.classList.add("valitud");
                    valitudLaud = div;
                }
            }
        });
});

// Funktsioon, mis loob ühe laua HTML-elemendi
function lisaLaud(l, klass) {
    const div = document.createElement("div");

    // Laus klass: ruut või ring
    div.classList.add(l.kujund || "ruut");
    div.classList.add("dünaamiline");

    // Kui kinni või muu klass
    if (klass) div.classList.add(klass);

    // Paigutus ja mõõdud
    div.style.position = "absolute";
    div.style.left = l.x + "px";
    div.style.top = l.y + "px";
    div.style.width = (l.width || 50) + "px";
    div.style.height = (l.height || 50) + "px";
    div.dataset.laud = l.id;

    // Klikitav ainult vaba laud
    if (!klass) {
        div.addEventListener("click", () => {
            if (valitudLaud) valitudLaud.classList.remove("valitud");
            div.classList.add("valitud");
            valitudLaud = div;
            console.log("Valitud laud:", div.dataset.laud);
        });
    }

    restoranDiv.appendChild(div);
}