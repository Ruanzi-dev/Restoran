const lauad = document.querySelectorAll('.laud, .laud-ring');

lauad.forEach(l => {
    l.addEventListener('click', () => {
        l.classList.toggle('valitud');
        console.log('Valitud laud:', l.dataset.laud);
    });
});
