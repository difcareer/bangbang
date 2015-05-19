package com.example.empty;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

public class MyActivity extends Activity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130837504);
    Toast.makeText(this, "MyActivity.onCreate", 0).show();
    Intent localIntent = new Intent();
    localIntent.setClass(this, TestService.class);
    startService(localIntent);
  }
}

/* Location:           /Users/andr0day/Knife/bangbang/1.jar
 * Qualified Name:     com.example.empty.MyActivity
 * JD-Core Version:    0.6.2
 */