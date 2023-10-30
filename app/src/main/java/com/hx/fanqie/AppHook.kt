package com.hx.fanqie

import android.R.attr.classLoader
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
            /**
             * 去掉广告 5.9.5版本去广告
             */

            try {
                lpparam.classLoader.loadClass("com.dragon.read.component.biz.impl.g.e")
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
            } catch (e: Exception) {
                XposedBridge.log("com.dragon.read.component.biz.impl.g.e:${e.message}")
            }
            /**
             * 5.9.5 去掉更新
             */


            try {
                lpparam.classLoader.loadClass("com.dragon.read.update.d")
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
            } catch (e: Exception) {
                XposedBridge.log("com.dragon.read.update.d:${e.message}")

            }

//            5.9.9版本去广告
            try {
                lpparam.classLoader.loadClass("com.dragon.read.component.biz.impl.h.e")
                XposedHelpers.findAndHookMethod("com.dragon.read.component.biz.impl.h.e",
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
            } catch (e: Exception) {
                XposedBridge.log("com.dragon.read.component.biz.impl.h.e:${e.message}")

            }
//            5.9.9版本去更新
            try {
                lpparam.classLoader.loadClass("com.dragon.read.update.UpdateManager")
                XposedHelpers.findAndHookMethod(
                    "com.dragon.read.update.UpdateManager",
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
            } catch (e: Exception) {
                XposedBridge.log("com.dragon.read.update.UpdateManager:${e.message}")

            }


        }
    }
}