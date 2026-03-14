const lauad = document.querySelectorAll('.laud, .laud-ring');

lauad.forEach(l => {
    l.addEventListener('click', () => {
        l.classList.toggle('valitud');
        console.log('Valitud laud:', l.dataset.laud);
    });
});

const restoranDiv = document.getElementById("restoran");
let valitudLaud = null;

document.getElementById("otsi").addEventListener("click", ()=> {
    const inimesed = document.getElementById("inimesed").value;
    const tsoon = document.getElementById("tsoon").value;

    fetch(`/api/soovitatavad-lauad?inimesed=${inimesed}&tsoon=${encodeURIComponent(tsoon)}`)
        .then(res => res.json())
        .then(data => {
            document.querySelectorAll(".dünaamiline").forEach(d => d.remove());


            data.kinni.forEach(l => lisaLaud(l, "kinni"));
            data.sobivad.forEach(l => lisaLaud(l, ""));
        })
})

function lisaLaud(l, klass){
    const div = document.createElement("div");
    div.classList.add(l.kujund || "laud");
    div.classList.add("dünaamiline");
    if (klass) div.classList.add(klass);

    div.style.position = "absolute";
    div.style.left = l.x + "px";
    div.style.top = l.y + "px";
    div.style.width = (l.width || 50) + "px";
    div.style.height = (l.height || 50) + "px";
    div.dataset.laud = l.id;

    if (!klass) {
        div.addEventListener("click", () => {
            if (valitudLaud) valitudLaud.classList.remove("valitud");
            div.classList.add("valitud");
            valitudLaud = div;
            console.log("Valitud laud:", div.dataset.laud);

        })


    }
    restoranDiv.appendChild(div);
}
