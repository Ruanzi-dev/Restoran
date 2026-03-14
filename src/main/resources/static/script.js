const lauad = [
    {id : 1, kohad : 6, tsoon : ["akna all","siseruum"], x : 891, y : 411},
    {id : 2, kohad : 6, tsoon : ["akna all", "siseruum"], x : 784, y : 415},
    {id : 3, kohad : 6, tsoon : ["akna all", "siseruum"], x : 674, y : 412},
    {id : 4, kohad : 2, tsoon : ["akna all", "siseruum"], x : 584, y : 434},
    {id : 5, kohad : 3, tsoon : ["akna all","siseruum"], x : 499, y : 439},
    {id : 6, kohad : 4, tsoon : ["akna all", "siseruum"], x : 413, y : 414},
    {id : 7, kohad : 6, tsoon : ["akna all", "siseruum"], x : 300, y : 414},
    {id : 8, kohad : 2, tsoon : ["siseruum"], x : 887, y : 248},
    {id : 9, kohad : 2, tsoon : ["siseruum"], x : 805, y : 250},
    {id : 10, kohad : 6, tsoon : ["siseruum"], x : 860, y : 312},
    {id : 11, kohad : 8, tsoon : ["siseruum"], x : 658, y : 288},
    {id : 12, kohad : 4, tsoon : ["lastenurga lähedal", "siseruum"], x : 906, y : 148},
    {id : 13, kohad : 3, tsoon : ["lastenurga lähedal", "siseruum"], x : 802, y : 137},
    {id : 14, kohad : 4, tsoon : ["lastenurga lähedal", "siseruum"], x : 620, y : 147},
    {id : 15, kohad : 14, tsoon : ["siseruum", "privaatruum"], x : 402, y : 204},
    {id : 16, kohad : 4, tsoon : ["terrass"], x : 139, y : 332},
    {id : 17, kohad : 4, tsoon : ["terrass"], x : 55, y : 336},
    {id : 18, kohad : 2, tsoon : ["terrass"], x : 210, y : 231},
    {id : 19, kohad : 4, tsoon : ["terrass"], x : 138, y : 231},
    {id : 20, kohad : 4, tsoon : ["terrass"], x : 53, y : 235},
]

const lauad2 = document.querySelectorAll('.laud, .laud-ring');

lauad2.forEach(l => {
    l.addEventListener('click', () => {
        l.classList.toggle('valitud');
        console.log('Valitud laud:', l.dataset.laud);
    });
});
