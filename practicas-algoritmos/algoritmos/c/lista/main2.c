#include <stdio.h>
#include <stdlib.h>
#define Max 100

typedef struct tipo_lista
{
    int a[Max];
    int cant;
} tipo_lista;

// consulta si la lista es vacia
int es_vacia( tipo_lista lista );

// agrega un elemento al comienzo de la lista
tipo_lista agregar( tipo_lista *lista, int elem );

// inserta un elemento en una posicion particular de la lista.
/*  0 si es exitosa la operacion
 * -1 si la posicion es invalida. */
int ins( tipo_lista *lista, int elemento, int position);


// agrega un elemento al final de la lista
tipo_lista fin( tipo_lista *lista, int elemento );

// elimina la cabeza de la lista (remueve el primer elemento).
/*  0 si es exitosa la operacion
 * -1 si la lista es vacia. */
int eliminar_comienzo( tipo_lista* lista );

// elimina un elemento en una posicion dada.
/*  0 si es exitosa la operacion
 * -1 si la posicion es invalida o si la lista es vacia.*/
int eliminar( tipo_lista* lista, int posicion);

// retorna el elemento en la posicion dada.
/* La posicion dada debe ser valida */
int obtener( tipo_lista lista, int position );

// retorna la reversa de la lista.
tipo_lista reversa( tipo_lista lista );

// concatenacion de listas.
tipo_lista concat( tipo_lista ini, tipo_lista cola );

// retorna la sub-lista comenzando en 'ini' y terminando en 'fin'
tipo_lista sub( tipo_lista lista, int ini, int fin );

// retorna una copia de la lista
tipo_lista copia( tipo_lista lista );

// retorna el primer elemento de una lista no vacia.
int cabeza( tipo_lista lista );

// retorna todos los elementos de la lista menos el primero.
tipo_lista cola( tipo_lista lista );

// muestra el contenido de la lista en la salida estandar 'std'
void mostrar( tipo_lista lista );

int reemplazar (tipo_lista *lista, int pos, int elem);

void intercambiar (tipo_lista *lista, int pos1, int pos2);

int main()
{
	
  	tipo_lista lista;
	lista.cant = 0;
	
	ins( &lista, 1, 0 );
	ins( &lista, 2, 1 );
	ins( &lista, 3, 2 );
	ins( &lista, 4, 3 );
	
	// lista = [ 1, 2, 3, 4 ]
	
	printf( "lista = " );
	mostrar( lista );
	printf("\n");
	
	// reversa( lista ) = [ 4, 3, 2, 1 ]
	
	printf( "reversa( lista ) = " );
	mostrar( reversa( lista ) );
	printf("\n");
	
	tipo_lista xs = concat( lista, reversa( lista ) );
	
	// xs = [ 1, 2, 3, 4, 4, 3, 2, 1 ]
	
	printf( "concatenamos la lista y su reversa = " );
	mostrar( xs );
	printf("\n");

	printf( "Insertar en la lista original el valor 0 en la posicion 1 =" );
	
	ins( &lista, 0, 1 );
	
	// lista = [ 1, 0, 2, 3, 4 ]
	
	mostrar( lista );
	printf("\n");
	
	printf("Reemplazar el valor 10 por el valor que se encuentra en la posicion 2, pero retornar el valor que habia anteriormente: ");
	int reem = reemplazar (&lista, 0, 10);
	printf ("%d", reem);
	
	printf("\nNueva lista: ");
	mostrar(lista);
	printf("\n");
	
	printf("Intercambiar el valor ubicado en la posicion 2 por el valor de la posicion 0\n");
	intercambiar (&lista, 2,0);
	mostrar(lista);
	printf("\n");
	
    
  return 0;
}

/*
	Implementacion de lista de enteros 
	usando la estructura array.
 */

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
