#include <stdio.h>
#include <stdlib.h>
#include "alista_enteros.h"

int main(){
    tipo_lista lista;
    int elem;
    int positivos, negativos;
    int cantNum;

    printf("Cantidad de numero que desea ingresar: ");
    scanf("%d", &cantNum);

    lista.cant = 0;
    
    for (int i=0; i<cantNum; i++) {
        printf("Inserte un numero: ");
        scanf("%d", &elem);
        agregar(&lista, elem);
    }

    positivos = 0;
    negativos = 0;

    for (int i=0; i<lista.cant; i++) {
        if (lista.a[i] >= 0) {
            positivos++;
        } else {
            negativos++;
        }
    }

    if (positivos > negativos) {
        printf("True.");
    } else {
        printf("False.");
    }

    return 0;
}