#include <stdio.h>
#include <string.h>

char nomeCorrentista[20];
double saldo;
bool contaEhEspecial;

void abreContaSimples(char *nome){
    strcpy(nomeCorrentista, nome);
    saldo = 0;
    contaEhEspecial = false;
}

void abreConta(char * nome, double deposito, bool ehEspecial){
    strcpy(nomeCorrentista, nome);
    saldo = deposito;
    contaEhEspecial = ehEspecial;
}

void deposita(int valor){
    saldo += valor;
}


void retira(int valor){
    if( contaEhEspecial ){
        saldo -= valor;
    }else{
        if( valor <= saldo ){
            saldo -= valor;
        }else{
            printf("Valor insuficiente");
        }
    }
}


void mostra(){
    printf("Nome: %s\n", nomeCorrentista);
    printf("Saldo: %lf\n", saldo);
    printf("Especial: %s\n", (contaEhEspecial? "sim" : "nao"));
}

int main(){
    abreContaSimples((char*)"Wladimir");
    deposita(5000);
    mostra();
}