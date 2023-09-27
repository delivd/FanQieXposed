package com.hx.fanqie

import android.R.attr.classLoader
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodHook
import de.robv.android.xposed.XposedBridge
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage


class AppHook : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam) {

        if (lpparam.packageName == "com.dragon.read") {
            XposedBridge.log("start hook...")
            /**
             * 去掉广告
             */
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
                        param.result = true
                    }
                })
            /**
             * 去掉更新
             */
            XposedHelpers.findAndHookMethod(
                "com.dragon.read.update.d",
                lpparam.classLoader,
                "b",
                object : XC_MethodHook() {
                    @Throws(Throwable::class)
                    override fun beforeHookedMethod(param: MethodHookParam) {
                        super.beforeHookedMethod(param)
                    }

                    @Throws(Throwable::class)
                    override fun afterHookedMethod(param: MethodHookParam) {
                        super.afterHookedMethod(param)
                        param.result = null
                    }
                })
        }
    }
}