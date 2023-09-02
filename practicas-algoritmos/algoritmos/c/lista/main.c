#include <stdio.h>
#include <stdlib.h>	
#include "alista_enteros.h"

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

