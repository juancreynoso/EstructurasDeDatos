#include <stdio.h>
#include <stdlib.h>
#define Max 100

/*
	Implementacion de lista de enteros 
	usando la estructura array.
 */

typedef struct tipo_lista
{
    int a[Max];
    int cant;
} tipo_lista;


int es_vacia (tipo_lista lista) {
    return lista.cant = 0;
}

tipo_lista agregar (tipo_lista *lista, int elem) {
    for (int i = lista->cant; i >= 0; i--) {
        lista->a[i+1] = lista->a[i];
    }
    lista->a[0] = elem;
    lista->cant ++;
    
}

int ins (tipo_lista *lista, int elemento, int posicion) {
    if ( posicion < 0 || posicion > lista->cant ){
		return -1;
	};

	if ( !posicion ){
		agregar(lista, elemento );
		return 0;
	}

    lista->a[posicion] = elemento;
    lista->cant++;
}

tipo_lista fin (tipo_lista *lista, int elemento) {
    lista->a[(lista->cant)+1] = elemento;
    lista->cant++;
}

int eliminar_comienzo (tipo_lista *lista) {
    if (es_vacia(*lista)) {
        return -1;
    }

    for (int i = 0; i < lista->cant; i++) {
        lista->a[i] = lista->a[i+1];
    }
    lista->cant--;
}

int eliminar (tipo_lista *lista, int posicion) {
    if ( posicion < 0 || posicion > lista->cant){
		return -1;
	};

    if (es_vacia(*lista)) {
        return -1;
    }

    for (int i = posicion; i<lista->cant; i++) {
        lista->a[i] = lista->a[i+1];
    }
    lista->cant--;
}

int obtener (tipo_lista lista, int position) {
    if ( position < 0 || position > lista.cant){
		return -1;
	}

    if (es_vacia(lista)) {
        return -1;
    } else {
        return lista.a[position];
    }
}

tipo_lista reversa (tipo_lista lista) {
    tipo_lista resultado;
    resultado.cant = 0;

    for ( int i = 0; i < lista.cant; i++ ) {
		agregar(&resultado, obtener( lista, i ));
	};

	return resultado;
}

tipo_lista concat (tipo_lista  ini, tipo_lista cola) {
    tipo_lista resultado;
    resultado.cant = 0;

	for ( int i = 0; i < ini.cant; i++ ){
		fin( &resultado, obtener( ini, i ));
	};

	for ( int i = 0; i < cola.cant; i++ ){
		fin( &resultado, obtener( cola, i ));
	};

	return resultado;
}

tipo_lista sub (tipo_lista lista, int ini, int f) {
    tipo_lista resultado;
    resultado.cant = 0;

	for ( int i = ini; i < f ; i++ ){
		fin( &resultado, obtener( lista, i ));
	};

	return resultado;
}

tipo_lista copia (tipo_lista lista) {
    return sub (lista, 0, lista.cant);
}

int cabeza (tipo_lista lista) {
    if (!(es_vacia(lista))) {
        return lista.a[0];
    } else {
        return -1;
    }
}

tipo_lista cola (tipo_lista lista) {
    return sub (lista, 1, lista.cant);
}

void mostrar (tipo_lista lista) {
    printf( "[ " );

	for ( int i = 0; i < lista.cant; i++ ){
		printf( "%i ", obtener( lista, i ) );
	};

	printf( "]" );
}

int reemplazar (tipo_lista *lista, int pos, int elem) {
	int oldElem;
	
	oldElem = obtener (*lista, pos);
	eliminar(lista, pos);
	ins(lista, elem, pos);
	return oldElem;
	
}

void intercambiar (tipo_lista *lista, int pos1, int pos2) {
	int elemPos1, elemPos2;
	
	elemPos1 = obtener(*lista, pos1);
	elemPos2 = obtener(*lista, pos2);
	
	eliminar (lista, pos1);
	ins (lista, elemPos2, pos1);
	eliminar (lista, pos2);
	ins (lista, elemPos1, pos2);
}
