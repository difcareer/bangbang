package com.bangcle.protect;

import android.app.Application;
import android.content.res.Configuration;
import dalvik.system.DexClassLoader;

public class ApplicationWrapper extends Application
{
  public static String FirstApplication = "com.bangcle.protect.FirstApplication";
  public static Application realApplication = null;
  private DexClassLoader cl;

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (realApplication != null)
      realApplication.onConfigurationChanged(paramConfiguration);
  }

  // ERROR //
  public void onCreate()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokespecial 30	android/app/Application:onCreate	()V
    //   4: invokestatic 36	com/bangcle/protect/Util:getCustomClassLoader	()Ljava/lang/ClassLoader;
    //   7: ifnonnull +7 -> 14
    //   10: aload_0
    //   11: invokestatic 40	com/bangcle/protect/Util:runAll	(Landroid/content/Context;)V
    //   14: getstatic 18	com/bangcle/protect/ApplicationWrapper:FirstApplication	Ljava/lang/String;
    //   17: astore_1
    //   18: aload_0
    //   19: invokestatic 36	com/bangcle/protect/Util:getCustomClassLoader	()Ljava/lang/ClassLoader;
    //   22: checkcast 42	dalvik/system/DexClassLoader
    //   25: putfield 44	com/bangcle/protect/ApplicationWrapper:cl	Ldalvik/system/DexClassLoader;
    //   28: aload_0
    //   29: invokevirtual 47	com/bangcle/protect/ApplicationWrapper:getClassLoader	()Ljava/lang/ClassLoader;
    //   32: aload_1
    //   33: invokevirtual 53	java/lang/ClassLoader:loadClass	(Ljava/lang/String;)Ljava/lang/Class;
    //   36: invokevirtual 59	java/lang/Class:newInstance	()Ljava/lang/Object;
    //   39: checkcast 4	android/app/Application
    //   42: putstatic 14	com/bangcle/protect/ApplicationWrapper:realApplication	Landroid/app/Application;
    //   45: getstatic 14	com/bangcle/protect/ApplicationWrapper:realApplication	Landroid/app/Application;
    //   48: ifnull +72 -> 120
    //   51: invokestatic 65	com/bangcle/protect/ACall:getACall	()Lcom/bangcle/protect/ACall;
    //   54: astore_3
    //   55: aload_3
    //   56: aload_0
    //   57: getstatic 14	com/bangcle/protect/ApplicationWrapper:realApplication	Landroid/app/Application;
    //   60: aload_0
    //   61: getfield 44	com/bangcle/protect/ApplicationWrapper:cl	Ldalvik/system/DexClassLoader;
    //   64: aload_0
    //   65: invokevirtual 69	com/bangcle/protect/ApplicationWrapper:getBaseContext	()Landroid/content/Context;
    //   68: invokevirtual 73	com/bangcle/protect/ACall:set2	(Landroid/app/Application;Landroid/app/Application;Ljava/lang/ClassLoader;Landroid/content/Context;)Ljava/lang/Object;
    //   71: pop
    //   72: aload_3
    //   73: getstatic 14	com/bangcle/protect/ApplicationWrapper:realApplication	Landroid/app/Application;
    //   76: aload_0
    //   77: invokevirtual 69	com/bangcle/protect/ApplicationWrapper:getBaseContext	()Landroid/content/Context;
    //   80: invokevirtual 77	com/bangcle/protect/ACall:at1	(Landroid/app/Application;Landroid/content/Context;)V
    //   83: getstatic 82	android/os/Build$VERSION:RELEASE	Ljava/lang/String;
    //   86: iconst_0
    //   87: iconst_3
    //   88: invokevirtual 88	java/lang/String:substring	(II)Ljava/lang/String;
    //   91: invokestatic 94	java/lang/Float:parseFloat	(Ljava/lang/String;)F
    //   94: ldc 95
    //   96: fcmpg
    //   97: ifgt +10 -> 107
    //   100: aload_3
    //   101: getstatic 14	com/bangcle/protect/ApplicationWrapper:realApplication	Landroid/app/Application;
    //   104: invokevirtual 99	com/bangcle/protect/ACall:set3	(Landroid/app/Application;)V
    //   107: invokestatic 102	com/bangcle/protect/Util:doProvider	()V
    //   110: getstatic 14	com/bangcle/protect/ApplicationWrapper:realApplication	Landroid/app/Application;
    //   113: invokevirtual 30	android/app/Application:onCreate	()V
    //   116: aload_3
    //   117: invokevirtual 105	com/bangcle/protect/ACall:set8	()V
    //   120: return
    //   121: astore_2
    //   122: aload_2
    //   123: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   126: aconst_null
    //   127: putstatic 14	com/bangcle/protect/ApplicationWrapper:realApplication	Landroid/app/Application;
    //   130: goto -85 -> 45
    //   133: astore 6
    //   135: aload 6
    //   137: invokevirtual 108	java/lang/Exception:printStackTrace	()V
    //   140: return
    //   141: astore 5
    //   143: goto -36 -> 107
    //
    // Exception table:
    //   from	to	target	type
    //   18	45	121	java/lang/Exception
    //   116	120	133	java/lang/Exception
    //   83	107	141	java/lang/Exception
  }

  public void onLowMemory()
  {
    super.onLowMemory();
    if (realApplication != null)
      realApplication.onLowMemory();
  }

  public void onTerminate()
  {
    super.onTerminate();
    if (realApplication != null)
      realApplication.onTerminate();
  }

  public void onTrimMemory(int paramInt)
  {
    try
    {
      super.onTrimMemory(paramInt);
      if (realApplication != null)
        realApplication.onTrimMemory(paramInt);
      return;
    }
    catch (Exception localException)
    {
    }
  }
}

/* Location:           /Users/andr0day/Knife/bangbang/2.jar
 * Qualified Name:     com.bangcle.protect.ApplicationWrapper
 * JD-Core Version:    0.6.2
 */