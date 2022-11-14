import java.util.EventListener;
public interface LightListener extends EventListener {
   public void lightOn(LightEvent evt);  // Called-back upon light on
   public void lightOff(LightEvent evt); // Called-back upon light off
}