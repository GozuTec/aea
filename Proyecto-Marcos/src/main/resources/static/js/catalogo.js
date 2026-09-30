/* =========================================================
   CATÁLOGO LABOCER
   Filtros + búsqueda + grilla Bootstrap + modal Bootstrap
   No depende de cambios en las demás páginas.
   ========================================================= */

document.addEventListener('DOMContentLoaded', () => {
const productos = window.productos || [];

    // Valores alineados con las categorías y colores publicados por LABOCER.
    const marcasOficiales = ['Americandy', 'Crismelos', 'Dori', 'Docile', 'Peccin', 'Riclan', 'Simsek', 'Soberana', 'Super'];
    const categoriasOficiales = ['Caramelo Duro', 'Caramelos Blandos', 'Chicle', 'Chupetes', 'Chocolate', 'Gomas', 'Confite', 'Marsmelos', 'Pastillas', 'Toffee'];
    const coloresOficiales = ['Rojo', 'Azul', 'Amarillo', 'Anaranjado', 'Verde', 'Morado', 'Blanco', 'Rosado', 'Marrón', 'Surtido'];

    const estado = { marca: '', categoria: '', color: '', busqueda: '' };

    const $ = (id) => document.getElementById(id);
    const grilla = $('grillaProductos');
    const contador = $('contadorProductos');
    const sinResultados = $('sinResultados');
    const buscar = $('buscarProducto');
    const filtrosActivos = $('filtrosActivos');
    const modalElement = $('productModal');
    const modal = new bootstrap.Modal(modalElement);

    const normalizar = (texto) => String(texto)
        .normalize('NFD')
        .replace(/[\u0300-\u036f]/g, '')
        .toLowerCase();

    const escapar = (texto) => String(texto)
        .replaceAll('&', '&amp;')
        .replaceAll('<', '&lt;')
        .replaceAll('>', '&gt;')
        .replaceAll('"', '&quot;')
        .replaceAll("'", '&#039;');

    const claseColor = {
        'Rojo': '#e53935', 'Azul': '#2196f3', 'Amarillo': '#f8cf3a', 'Anaranjado': '#ff8c42',
        'Verde': '#43a047', 'Morado': '#7e57c2', 'Blanco': '#ffffff', 'Rosado': '#ec6fa5',
        'Marrón': '#7b4b2a', 'Surtido': 'linear-gradient(135deg,#e53935 0 20%,#f8cf3a 20% 40%,#43a047 40% 60%,#2196f3 60% 80%,#7e57c2 80%)'
    };

    function crearRadio(contenedor, campo, valor, texto, checked = false) {
        const id = `filtro-${campo}-${normalizar(valor || 'todos').replace(/[^a-z0-9]+/g, '-')}`;
        const wrapper = document.createElement('div');
        wrapper.className = 'form-check filtro-opcion';

        const input = document.createElement('input');
        input.className = 'form-check-input';
        input.type = 'radio';
        input.name = `filtro-${campo}`;
        input.id = id;
        input.value = valor;
        input.checked = checked;

        const label = document.createElement('label');
        label.className = 'form-check-label small d-flex align-items-center';
        label.htmlFor = id;

        if (campo === 'color' && valor) {
            const dot = document.createElement('span');
            dot.className = 'producto-color-dot me-2';
            dot.style.background = claseColor[valor] || '#ccc';
            if (valor === 'Blanco') dot.style.border = '1px solid #aeb7c3';
            label.appendChild(dot);
        }
        label.appendChild(document.createTextNode(texto));

        input.addEventListener('change', () => {
            estado[campo] = input.value;
            renderizar();
        });

        wrapper.append(input, label);
        contenedor.appendChild(wrapper);
    }

    function cargarFiltros() {
        const configuraciones = [
            ['filtroMarca', 'marca', marcasOficiales, 'Todas las marcas'],
            ['filtroCategoria', 'categoria', categoriasOficiales, 'Todas las categorías'],
            ['filtroColor', 'color', coloresOficiales, 'Todos los colores']
        ];

        configuraciones.forEach(([contenedorId, campo, valores, textoTodos]) => {
            const contenedor = $(contenedorId);
            contenedor.innerHTML = '';
            crearRadio(contenedor, campo, '', textoTodos, true);
            valores.forEach(valor => crearRadio(contenedor, campo, valor, valor, false));
        });
    }

    function coincide(producto) {
        const marcaOk = !estado.marca || producto.marca === estado.marca;
        const categoriaOk = !estado.categoria || producto.categoria === estado.categoria;
        const colorOk = !estado.color || producto.color === estado.color;
        const contenido = normalizar(`${producto.nombre} ${producto.marca} ${producto.categoria} ${producto.color}`);
        const busquedaOk = !estado.busqueda || contenido.includes(normalizar(estado.busqueda));
        return marcaOk && categoriaOk && colorOk && busquedaOk;
    }

    function crearTarjeta(producto) {
        const col = document.createElement('div');
        col.className = 'col';

        const colorDot = `<span class="producto-color-dot me-1" style="background:${escapar(claseColor[producto.color] || '#ccc')};${producto.color === 'Blanco' ? 'border:1px solid #aeb7c3;' : ''}"></span>`;

        col.innerHTML = `
            <article class="producto-card d-flex flex-column">
                <div class="producto-img-wrap">
                    <img src="${escapar(producto.imagen)}" class="producto-img" alt="${escapar(producto.nombre)}" loading="lazy">
                </div>
                <div class="card-body d-flex flex-column p-3 p-xl-4">
                    <div class="mb-3">
                        <span class="badge producto-marca rounded-pill mb-2">${escapar(producto.marca)}</span>
                        <h3 class="h6 producto-nombre fw-bold mb-2">${escapar(producto.nombre)}</h3>
                        <p class="small producto-categoria mb-2">${escapar(producto.categoria)}</p>
                        <span class="small text-muted d-flex align-items-center">${colorDot}${escapar(producto.color)}</span>
                    </div>
                    <button type="button" class="btn btn-labocer-yellow rounded-pill w-100 btn-detalle">
                        <i class="bi bi-card-text me-1"></i> Ver ficha técnica
                    </button>
                </div>
            </article>
        `;

        col.querySelector('.btn-detalle').addEventListener('click', () => abrirModal(producto));
        col.querySelector('img').addEventListener('error', function () {
            this.parentElement.innerHTML = '<div class="text-center text-muted small"><i class="bi bi-image fs-1 d-block mb-2"></i>Imagen no disponible</div>';
        });

        return col;
    }

    function abrirModal(producto) {
        $('modalProductImage').src = producto.imagen;
        $('modalProductImage').alt = producto.nombre;
        $('modalProductName').textContent = producto.nombre;
        $('modalProductDescription').textContent = producto.descripcion;
        $('modalBrand').textContent = producto.marca;
        $('modalCategory').textContent = producto.categoria;
        $('modalColor').textContent = producto.color;
        $('modalCode').textContent = producto.codigo;
        $('modalPresentation').textContent = producto.presentacion;
        $('modalBox').textContent = producto.caja;
        modal.show();
    }

    function renderizarFiltrosActivos() {
        filtrosActivos.innerHTML = '';
        const activos = [
            ['Marca', estado.marca],
            ['Categoría', estado.categoria],
            ['Color', estado.color],
            ['Búsqueda', estado.busqueda]
        ].filter(([, valor]) => valor);

        activos.forEach(([nombre, valor]) => {
            const span = document.createElement('span');
            span.className = 'badge badge-filtro rounded-pill px-3 py-2';
            span.innerHTML = `<strong>${escapar(nombre)}:</strong> ${escapar(valor)}`;
            filtrosActivos.appendChild(span);
        });
    }

    function renderizar() {
        const filtrados = productos.filter(coincide);
        grilla.innerHTML = '';

        filtrados.forEach(producto => grilla.appendChild(crearTarjeta(producto)));

        const textoProducto = filtrados.length === 1 ? 'producto encontrado' : 'productos encontrados';
        contador.textContent = `${filtrados.length} ${textoProducto} de ${productos.length}`;

        const hayResultados = filtrados.length > 0;
        grilla.classList.toggle('d-none', !hayResultados);
        sinResultados.classList.toggle('d-none', hayResultados);
        renderizarFiltrosActivos();
    }

    function limpiarFiltros() {
        estado.marca = '';
        estado.categoria = '';
        estado.color = '';
        estado.busqueda = '';
        buscar.value = '';

        document.querySelectorAll('.filtro-opcion .form-check-input').forEach(input => {
            input.checked = input.value === '';
        });
        renderizar();
    }

    cargarFiltros();

    buscar.addEventListener('input', () => {
        estado.busqueda = buscar.value.trim();
        renderizar();
    });

    $('btnLimpiarFiltros').addEventListener('click', limpiarFiltros);
    $('btnLimpiarSinResultados').addEventListener('click', limpiarFiltros);

    renderizar();
});
