#include <stdio.h>
#include <stdlib.h>
#include "alista_enteros.h"

void cargarNotas(tipo_lista* lista);
void promedio(tipo_lista lista);

int main () {

    tipo_lista listaNotas;

    cargarNotas(&listaNotas);
    promedio(listaNotas);

    return 0;
}

void cargarNotas(tipo_lista* lista) {

    int cantNotas;
    printf("Ingrese cantidad de notas a cargar: ");
    scanf("%d", &cantNotas);

        lista->cant = 0;
        for (int i=0; i<cantNotas; i++){
            printf("Ingrese una nota: ");
            scanf("%d", &(lista->a[i]));
        }
        
}

void promedio(tipo_lista lista) {
    int sumNotas = 0;
    int sumNotasAp = 0;
    int cant = 0;
    float promSinAplazos = 0;
    float promConAplazos = 0;

    for (int i=0; i<=lista.cant; i++) {
        sumNotas = sumNotas + lista.a[i];

        if (lista.a[i] >= 5) {
            cant++;
            sumNotasAp = sumNotasAp + lista.a[i];
        }
    }
    promConAplazos = (float) (sumNotas/lista.cant);
    promSinAplazos = (float) (sumNotasAp/cant);

    printf("Promedio sin aplazos: %f", promSinAplazos);
    printf("Promedio con aplazos: %f", promConAplazos);
}
