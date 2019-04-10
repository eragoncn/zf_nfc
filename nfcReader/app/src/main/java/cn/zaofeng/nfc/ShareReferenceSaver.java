package cn.zaofeng.nfc;

import android.content.Context;
import android.preference.PreferenceManager;

public class ShareReferenceSaver
{
  public static void saveData(Context paramActivity, String paramString1, String paramString2)
  {
    PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().putString(paramString1, paramString2).commit();
  }

  public static String getData(Context paramActivity, String paramString)
  {
    return PreferenceManager.getDefaultSharedPreferences(paramActivity).getString(paramString, "");
  }
}