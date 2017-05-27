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
#Butterknife 7.0.1版本
#不忽略的类
#-keep class butterknife.** { *; }
#-keep class **$$ViewBinder { *; }
##忽略警告的包名   第三方
#-dontwarn butterknife.internal.**
#-keepclasseswithmembernames class * {
#    @butterknife.* <fields>;
#}
#-keepclasseswithmembernames class * {
#    @butterknife.* <methods>;
#}
#Butterknife8.4.0不需要混淆，自动配置好了