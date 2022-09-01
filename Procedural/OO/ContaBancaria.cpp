#include "ContaBancaria.h"

ContaBancaria::ContaBancaria(string nome){
        nomeCorrentista =  nome;
        saldo = 0;
        contaEhEspecial = false;
    }

ContaBancaria::ContaBancaria(string nome, double deposito, bool ehEspecial){
    nomeCorrentista =  nome;
    saldo = deposito;
    contaEhEspecial = ehEspecial;
}

void ContaBancaria::deposita(int valor){
    saldo += valor;
}


void ContaBancaria::retira(int valor){
    if( contaEhEspecial ){
        saldo -= valor;
    }else{
        if( valor <= saldo ){
            saldo -= valor;
        }else{
            cout << "Valor insuficiente" << endl;
        }
    }
}


void ContaBancaria::mostra(){
    cout << "Nome: " <<  nomeCorrentista << endl;
    cout << "Saldo: " <<  saldo << endl;
    cout << "Especial: "<<  (contaEhEspecial? "sim" : "nao") << endl;
}