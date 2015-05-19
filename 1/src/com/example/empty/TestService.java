package com.example.empty;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class TestService extends Service
{
  public IBinder onBind(Intent paramIntent)
  {
    return null;
  }

  public void onCreate()
  {
    super.onCreate();
    Toast.makeText(this, "TestService.onCreate", 0).show();
  }
}

/* Location:           /Users/andr0day/Knife/bangbang/1.jar
 * Qualified Name:     com.example.empty.TestService
 * JD-Core Version:    0.6.2
 */