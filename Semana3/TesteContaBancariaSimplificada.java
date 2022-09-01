public class TesteContaBancariaSimplificada {
    public static void main(String[] args) {
        ContaBancariaSimplificada c1 = new ContaBancariaSimplificada("Alef");
        ContaBancariaSimplificada c2 = new ContaBancariaSimplificada("Yarlei", 3000);
        ContaBancariaSimplificada c3 = new ContaBancariaSimplificada("Janaina", 150000, true);
        
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
    }
}
