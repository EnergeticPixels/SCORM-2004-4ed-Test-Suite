package org.adl.util;

import java.applet.Applet;
import java.lang.reflect.Method;

import netscape.javascript.JSObject;

/**
 * Compatibility bridge for legacy applet JSObject window lookup.
 */
public final class JSObjectBridge
{
   private JSObjectBridge()
   {
      // Utility class
   }

   /**
    * Attempts to resolve JSObject.getWindow(Applet) using reflection.
    * Returns null when the method is unavailable on modern JDKs.
    *
    * @param iApplet legacy applet instance
    * @return JSObject window reference or null
    */
   public static JSObject getWindow(Applet iApplet)
   {
      try
      {
         Method m = JSObject.class.getMethod("getWindow", Applet.class);
         return (JSObject)m.invoke(null, iApplet);
      }
      catch (Exception ignored)
      {
         return null;
      }
   }
}