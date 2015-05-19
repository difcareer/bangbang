package com.bangcle.protect;

import android.app.Activity;
import android.app.Application;
import android.content.ContentProvider;
import android.content.Context;
import java.io.File;

public class ACall
{
  private static ACall acall;

  static
  {
    if (Util.getCPUABI().equals("x86"))
    {
      Util.runAll1(Util.x86Ctx);
      if (new File("/data/data/" + Util.x86Ctx.getPackageName() + "/.cache/" + "libsecexe.x86.so").exists())
        System.load("/data/data/" + Util.x86Ctx.getPackageName() + "/.cache/" + "libsecexe.x86.so");
    }
    while (true)
    {
      acall = null;
      return;
      System.load("/data/data/" + Util.x86Ctx.getPackageName() + "/lib/" + "libsecexe.x86.so");
      continue;
      Util.runAll1(Util.x86Ctx);
      System.load("/data/data/" + Util.x86Ctx.getPackageName() + "/.cache/" + "libsecexe.so");
    }
  }

  public static ACall getACall()
  {
    if (acall == null)
      acall = new ACall();
    return acall;
  }

  public native void a1(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

  public native void at1(Application paramApplication, Context paramContext);

  public native void at2(Application paramApplication, Context paramContext);

  public native void c1(Object paramObject1, Object paramObject2);

  public native void c2(Object paramObject1, Object paramObject2);

  public native Object c3(Object paramObject1, Object paramObject2);

  public native void r1(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2);

  public native void r2(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2, byte[] paramArrayOfByte3);

  public native ClassLoader rc1(Context paramContext);

  public native void s1(Object paramObject1, Object paramObject2, Object paramObject3);

  public native Object set1(Activity paramActivity, ClassLoader paramClassLoader);

  public native Object set2(Application paramApplication1, Application paramApplication2, ClassLoader paramClassLoader, Context paramContext);

  public native void set3(Application paramApplication);

  public native void set3(Object paramObject1, Object paramObject2);

  public native void set4();

  public native void set5(ContentProvider paramContentProvider);

  public native void set8();
}

/* Location:           /Users/andr0day/Knife/bangbang/2.jar
 * Qualified Name:     com.bangcle.protect.ACall
 * JD-Core Version:    0.6.2
 */