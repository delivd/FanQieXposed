package com.hx.fanqie

import android.util.Log
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage


class AppHook : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {

        if (lpparam.packageName == "com.dragon.read") {
            XposedBridge.log("start hook...")
            XposedHelpers.findAndHookMethod("com.dragon.read.component.biz.impl.g.e",
                lpparam.classLoader,
                "isNoAd",
                String::class.java,
                object : XC_MethodHook() {
                    @Throws(Throwable::class)
                    override fun beforeHookedMethod(param: MethodHookParam) {
                        super.beforeHookedMethod(param)
                    }

                    @Throws(Throwable::class)
                    override fun afterHookedMethod(param: MethodHookParam) {
                        super.afterHookedMethod(param)
                        Log.e("JSFunc", "isNoAd--->${param.result}")
                        param.result = true
                    }
                })
        }
    }
}