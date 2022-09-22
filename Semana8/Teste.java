class DayOfWeek{

   static final int SUNDAY = 0;
   static final int MONDAY = 1;
   static final int TUESDAY = 2;
   static final int WEDNESDAY = 3;
   static final int THURSDAY = 4;
   static final int FRIDAY = 5;
   static final int SATURDAY = 6;
   
   
   static void printDayOfWeek(int day){
      switch(day){
         case DayOfWeek.SUNDAY:
            System.out.println("SUNDAY");
            break;
         case DayOfWeek.MONDAY:
            System.out.println("MONDAY");
            break;

         case DayOfWeek.TUESDAY:
            System.out.println("TUESDAY");
            break;

         case DayOfWeek.WEDNESDAY:
            System.out.println("WEDNESDAY");
            break;

         case DayOfWeek.THURSDAY:
            System.out.println("THURSDAY");
            break;

         case DayOfWeek.FRIDAY:
            System.out.println("FRIDAY");
            break;
         
         case DayOfWeek.SATURDAY:
            System.out.println("SATURDAY");
            break;
         
      }
   }
}

class Teste{


   public static void main(String[] args) {
      int day = 78;

      DayOfWeek.printDayOfWeek(day);
   }
      


}