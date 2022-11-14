import java.util.*;
public class Light {
   // Status - on (true) or off (false)
   private boolean on;
   // Listener list
   private List<LightListener> listeners = new ArrayList<LightListener>();
 
   /** Constructor */
   public Light() {
      on = false;   // initially off
      System.out.println("Light: constructed and off");
   }
 
   /** Add the given LightListener */
   public void addLightListener(LightListener listener) {
      listeners.add(listener);
      System.out.println("Light: added a listener");
   }
 
   /** Remove the given LightListener */
   public void removeLightListener(LightListener listener) {
      listeners.remove(listener);
      System.out.println("Light: removed a listener");
   }
 
   /** Turn on this light */
   public void turnOn() {
      if (!on) {
         on = !on;
         System.out.println("Light: turn on");
         notifyListener();
      }
   }
 
   /** Turn off this light */
   public void turnOff() {
      if (on) {
         on = !on;
         System.out.println("Light: turn off");
         notifyListener();
      }
   }
 
   /** Construct an LightEvent and trigger the appropriate handler on its registered listeners */
   private void notifyListener() {
      LightEvent evt = new LightEvent(this);
      for (LightListener listener : listeners) {
         if (on) {
            listener.lightOn(evt);
         } else {
            listener.lightOff(evt);
         }
      }
   }
}