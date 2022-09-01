#include <iostream>
#include <string>

using namespace std;


typedef struct{
    string nomeCorrentista;
    double saldo;
    bool contaEhEspecial;

    void abreContaSimples(string nome){
        nomeCorrentista =  nome;
        saldo = 0;
        contaEhEspecial = false;
    }

    void abreConta(string nome, double deposito, bool ehEspecial){
        nomeCorrentista =  nome;
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
                cout << "Valor insuficiente" << endl;
            }
        }
    }


    void mostra(){
        cout << "Nome: " <<  nomeCorrentista << endl;
        cout << "Saldo: " <<  saldo << endl;
        cout << "Especial: "<<  (contaEhEspecial? "sim" : "nao") << endl;
    }

} ContaBancaria;


int main(){
    
    ContaBancaria c1;
    ContaBancaria c2;
    ContaBancaria c3{ "Fabio", 5000, false};

    c1.abreContaSimples("Wladimir");
    c1.deposita(5000);
    c1.mostra();

    c2.abreConta("Andre", 2000, true);
    c2.deposita(10000);
    c2.saldo += 1000;
    c2.mostra();

    c3.mostra();

}