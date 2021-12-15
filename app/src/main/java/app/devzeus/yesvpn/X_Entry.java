package app.devzeus.yesvpn;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class X_Entry implements IXposedHookLoadPackage {
    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        if(lpparam.packageName.equals("com.eclipse.gamonyapp")){
            XposedHelpers.findAndHookMethod(
                    "com.eclipse.gamonyapp.Fragments.OffersFragment", lpparam.classLoader,
                    "vpn", new XC_MethodHook() {
                        @Override
                        protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                            param.setResult(false);
                            super.afterHookedMethod(param);
                        }
                    }
            );
        }
    }
}
