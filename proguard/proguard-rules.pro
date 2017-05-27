# Add project specific ProGuard rules here.
# By default, the flags in this file are appended to flags specified
# in E:\Android_studio_SDK/tools/proguard/proguard-android.txt
# You can edit the include path and order by changing the proguardFiles
# directive in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# Add any project specific keep options here:

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

#对MyFragment类进行完全保留，不混淆其类名、方法名、以及变量名。
-keep class com.cxp.proguard.MyFragment {
    *;
}

#对Utils类中的未调用方法进行保留，防止其被移除掉。     不对这个方法进行忽略
-keepclassmembers class com.cxp.proguard.Utils {
    public void methodUnused();
}

#对第三方库进行保留，不混淆android-support库，以及LitePal库中的代码。
-keep class org.litepal.** {
    *;
}

-keep class android.support.** {
    *;
}

-keep class butterknife.** {
    *;
}

#忽略警告的包名   第三方
-dontwarn org.litepal.**
-dontwarn butterknife.**
