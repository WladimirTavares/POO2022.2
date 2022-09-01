#include "ContaBancaria.h"

int main(){

    ContaBancaria c1("Wladimir");
    ContaBancaria c2("Andre", 2000, true);
    ContaBancaria c3("Fabio", 5000, false);

    c1.deposita(5000);
    c1.mostra();

    c2.deposita(10000);
    c2.mostra();

    c3.mostra();
}


