#include <stdio.h>
#include <string.h>

typedef struct{
    char nomeCorrentista[20];
    double saldo;
    bool contaEhEspecial;
} ContaBancaria;

void abreContaSimples(ContaBancaria* c, char *nome){
    strcpy(c->nomeCorrentista, nome);
    c->saldo = 0;
    c->contaEhEspecial = false;
}

void abreConta(ContaBancaria * c, char * nome, double deposito, bool ehEspecial){
    strcpy(c->nomeCorrentista, nome);
    c->saldo = deposito;
    c->contaEhEspecial = ehEspecial;
}

void deposita(ContaBancaria * c, int valor){
    c->saldo += valor;
}


void retira(ContaBancaria * c, int valor){
    if( c->contaEhEspecial ){
        c->saldo -= valor;
    }else{
        if( valor <= c->saldo ){
            c->saldo -= valor;
        }else{
            printf("Valor insuficiente");
        }
    }
}


void mostra(const ContaBancaria * c){
    printf("Nome: %s\n", c->nomeCorrentista);
    printf("Saldo: %lf\n", c->saldo);
    printf("Especial: %s\n", (c->contaEhEspecial? "sim" : "nao"));
}

int main(){
    
    ContaBancaria c1;
    ContaBancaria c2;

    abreContaSimples(&c1, (char*)"Wladimir");
    deposita(&c1, 5000);
    mostra(&c1);

    abreConta(&c2, (char*)"Andre", 2000, true);
    deposita(&c2, 10000);
    c2.saldo += 1000;
    mostra(&c2);

}