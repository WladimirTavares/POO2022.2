public class TestLight {
   public static void main(String[] args) {
      Light light = new Light();
      LightWatcher lw1 = new LightWatcher(1);
      LightWatcher lw2 = new LightWatcher(2);
      LightWatcher lw3 = new LightWatcher(3);
      light.addLightListener(lw1);
      light.addLightListener(lw2);
      light.turnOn();
      light.addLightListener(lw3);
      light.turnOff();
      light.removeLightListener(lw1);
      light.removeLightListener(lw3);
      light.turnOn();
   }
}