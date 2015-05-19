package com.bangcle.protect;

import dalvik.system.DexClassLoader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;

public class MyClassLoader extends DexClassLoader
{
  private ClassLoader mClassLoader = null;

  public MyClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader.getParent());
    this.mClassLoader = paramClassLoader;
    Thread.currentThread().setContextClassLoader(this);
  }

  public URL getResource(String paramString)
  {
    return this.mClassLoader.getResource(paramString);
  }

  public InputStream getResourceAsStream(String paramString)
  {
    return this.mClassLoader.getResourceAsStream(paramString);
  }

  public Enumeration<URL> getResources(String paramString)
    throws IOException
  {
    return this.mClassLoader.getResources(paramString);
  }
}

/* Location:           /Users/andr0day/Knife/bangbang/2.jar
 * Qualified Name:     com.bangcle.protect.MyClassLoader
 * JD-Core Version:    0.6.2
 */