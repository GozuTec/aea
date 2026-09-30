// Manejo interactivo del modal de ficha tecnica
document.addEventListener('DOMContentLoaded', () => {
    const productModal = document.getElementById('productModal');
    if (productModal) {
        productModal.addEventListener('show.bs.modal', event => {
            const button = event.relatedTarget;
            const name = button.getAttribute('data-name');
            const code = button.getAttribute('data-code');
            const box = button.getAttribute('data-box');
            const cat = button.getAttribute('data-cat');
            const brand = button.getAttribute('data-brand');

            document.getElementById('modalProductName').textContent = name;
            document.getElementById('modalCode').textContent = code;
            document.getElementById('modalBox').textContent = box;
            document.getElementById('modalBrand').textContent = brand;
            document.getElementById('modalCategory').textContent = cat;
        });
    }

    // Filtro interactivo de favoritos y nuevos
    const btnFav = document.getElementById('btnFavorites');
    const btnNew = document.getElementById('btnNews');

    if (btnFav && btnNew) {
        btnFav.addEventListener('click', () => {
            btnFav.classList.add('active');
            btnNew.classList.remove('active');
        });

        btnNew.addEventListener('click', () => {
            btnNew.classList.add('active');
            btnFav.classList.remove('active');
        });
    }
});