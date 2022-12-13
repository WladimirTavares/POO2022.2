## Padrão Observer

No padrão Observer, temos um objeto Fonte (que publica informações)  e os objetos assinantes (que recebem as publicações). 

Os assinantes registram-se no Fonte para receber atualizações quando os dados da Fonte são alterados. Os assinantes podem cancelar o seu registro e deixar de receber as atualizações do Fonte.

No projeto de interface gráfica, temos um objeto Button e podemos adicionar ActionListener (um assinante) que será notificado quando um botão for clicado. 


No pacote [java.awt.event.*](https://docs.oracle.com/en/java/javase/19/docs/api/java.desktop/java/awt/event/package-tree.html) temos várias contratos (interfaces) para assinar diferentes modificações de diferentes componentes do AWT:

* java.util.EventListener
* java.awt.event.ActionListener
* java.awt.event.AdjustmentListener
* java.awt.event.AWTEventListener
* java.awt.event.ComponentListener
* java.awt.event.ContainerListener
* java.awt.event.FocusListener
* java.awt.event.HierarchyBoundsListener
* java.awt.event.HierarchyListener
* java.awt.event.InputMethodListener
* java.awt.event.ItemListener
* java.awt.event.KeyListener
* java.awt.event.MouseListener
* java.awt.event.MouseMotionListener
* java.awt.event.MouseWheelListener
* java.awt.event.TextListener
* java.awt.event.WindowFocusListener
* java.awt.event.WindowListener
* java.awt.event.WindowStateListener

## Class EventObject

A classe EventObject é a classe raiz da qual todos os objetos de eventos devem ser derivados. Essa classe guarda informações sobre algo que aconteceu com a fonte. Essa classe possui uma referência à fonte do evento.

```Java
class EventObject extends Object{
    Object source;
    EventObject(Object source);
    Object getSource();
    String toString();
}
```

## Class LightEvent

No nosso exemplo, a classe LightEvent vai ficar responsável por encapsular as mensagens geradas pela nossa classe Light que será apresentada a seguir.

```Java
import java.util.EventObject;
public class LightEvent extends EventObject {
   public LightEvent (Object src) {
      super(src);
   }
}
```

## Interface EventListener

A interface EventListener tem como função principal a manipulação dos eventos gerados.

```Java
interface EventListener{
    void handleEvent(Event evt);
}
```

## Interface LightListener

A interface LightListener

```Java
import java.util.EventListener;
public interface LightListener extends EventListener {
   public void lightOn(LightEvent evt);  // Called-back upon light on
   public void lightOff(LightEvent evt); // Called-back upon light off
}
```

## Class LightWatcher

```Java
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
```

## Classe Light

```Java
/** The Light Source, which maintains a list of listeners and fires LightEvent to its listeners */
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
```

## TestLight

```Java
/** A Test Driver */
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
```

## Saída

```bash
Light: constructed and off
LightWatcher-1: created
LightWatcher-2: created
LightWatcher-3: created
Light: added a listener
Light: added a listener
Light: turn on
LightWatcher-1: I am notified that light is on
LightWatcher-2: I am notified that light is on
Light: added a listener
Light: turn off
LightWatcher-1: I am notified that light is off
LightWatcher-2: I am notified that light is off
LightWatcher-3: I am notified that light is off
Light: removed a listener
Light: removed a listener
Light: turn on
LightWatcher-2: I am notified that light is on
```

