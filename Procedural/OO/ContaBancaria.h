#pragma once
class ContaBancaria{
    private:
    string nomeCorrentista;
    double saldo;
    bool contaEhEspecial;
    public:
    ContaBancaria(string nome);
    ContaBancaria(string nome, double deposito, bool ehEspecial);
    void deposita(int valor);
    void retira(int valor);
    void mostra();
};