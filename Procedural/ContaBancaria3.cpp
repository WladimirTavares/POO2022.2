#include <iostream>
#include <string>

using namespace std;


typedef struct{
    string nomeCorrentista;
    double saldo;
    bool contaEhEspecial;
} ContaBancaria;

void abreContaSimples(ContaBancaria & c, string nome){
    c.nomeCorrentista =  nome;
    c.saldo = 0;
    c.contaEhEspecial = false;
}

void abreConta(ContaBancaria & c, string nome, double deposito, bool ehEspecial){
    c.nomeCorrentista =  nome;
    c.saldo = deposito;
    c.contaEhEspecial = ehEspecial;
}

void deposita(ContaBancaria & c, int valor){
    c.saldo += valor;
}


void retira(ContaBancaria & c, int valor){
    if( c.contaEhEspecial ){
        c.saldo -= valor;
    }else{
        if( valor <= c.saldo ){
            c.saldo -= valor;
        }else{
            cout << "Valor insuficiente" << endl;
        }
    }
}


void mostra(const ContaBancaria & c){
    cout << "Nome: " <<  c.nomeCorrentista << endl;
    cout << "Saldo: " <<  c.saldo << endl;
    cout << "Especial: "<<  (c.contaEhEspecial? "sim" : "nao") << endl;
}

int main(){
    
    int a;

    int & ref_a = a;

    a = 4;
    ref_a = 8;
     

    ContaBancaria c1;
    ContaBancaria c2;

    abreContaSimples(c1, "Wladimir");
    deposita(c1, 5000);
    mostra(c1);

    abreConta(c2, "Andre", 2000, true);
    deposita(c2, 10000);
    c2.saldo += 1000;
    mostra(c2);

}