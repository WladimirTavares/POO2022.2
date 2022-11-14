/** A LightEvent listener, which is required to implement LightListener interface. */
public class LightWatcher implements LightListener {
   private int id;  // ID of this listener
 
   /** Constructor */
   public LightWatcher(int id) {
      this.id = id;
      System.out.println("LightWatcher-" + id + ": created");
   }
 
   /** LightEvent handlers - Called back with LightEvent is fired */
   @Override
   public void lightOn(LightEvent evt) {
      System.out.println("LightWatcher-" + id
         + ": I am notified that light is on");
   }
 
   @Override
   public void lightOff(LightEvent evt) {
      System.out.println("LightWatcher-" + id
         + ": I am notified that light is off");
   }
}