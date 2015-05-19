package neo.proxy;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import com.bangcle.protect.ACall;
import com.bangcle.protect.Util;

public class DistributeReceiver extends BroadcastReceiver
{
  private BroadcastReceiver realReceiver = null;

  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (Util.getCustomClassLoader() == null)
      Util.runAll(paramContext);
    try
    {
      this.realReceiver = ((BroadcastReceiver)Util.getCustomClassLoader().loadClass(getClass().getName()).newInstance());
      if (this.realReceiver != null)
      {
        ACall.getACall().c1(this, this.realReceiver);
        this.realReceiver.onReceive(paramContext, paramIntent);
        ACall.getACall().c2(this, this.realReceiver);
      }
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        localException.printStackTrace();
        this.realReceiver = null;
      }
    }
  }
}

/* Location:           /Users/andr0day/Knife/bangbang/2.jar
 * Qualified Name:     neo.proxy.DistributeReceiver
 * JD-Core Version:    0.6.2
 */