package ejiayou.composing.builds

/**
 * @author:
 * @created on: 2022/3/4 13:46
 * @description:
 */
object ThirdLib {
    //toast
    const val Toasty = "com.github.GrenderG:Toasty:1.2.8"
    const val light = "io.github.tonnyl:light:1.0.0"
    const val stateframelayout = "am.widget:stateframelayout:2.0.2"
    const val sdkPanowidget = "com.google.vr:sdk-panowidget:1.80.0"

    //功能引导指示图
    const val MaterialIntroView = "com.github.iammert:MaterialIntroView:1.6.0"

    //引导图
    const val slidingtutorial = "com.cleveroad:slidingtutorial:0.9"


    val logger = Logger

    object Logger {
        private const val logger_version = "2.1.1"
        const val logger = "com.orhanobut:logger:${logger_version}"
    }

    val timber = Timber

    object Timber {
        private const val timber_version = "4.7.1"
        const val timber = "com.jakewharton.timber:timber:${timber_version}"
    }

    val rxjava = Rxjava

    object Rxjava {
        private const val rxjava_version = "2.1.3"
        const val rxjava = "io.reactivex.rxjava2:rxjava:${rxjava_version}"
        const val rxandroid = "io.reactivex.rxjava2:rxandroid:2.0.1"
        const val rxbinding2 = "com.jakewharton.rxbinding2:rxbinding:2.1.1"
    }

    val dagger = Dagger

    object Dagger {
        private const val dagger_version = "2.16"
        const val dagger = "com.google.dagger:dagger:${dagger_version}"
        const val dagger2Compiler = "com.google.dagger:dagger-compiler:2.19"
        const val dagger2Android = "com.google.dagger:dagger-android:2.19"
        const val dagger2Support = "com.google.dagger:dagger-android-support:2.16"
        const val dagger2Processor = "com.google.dagger:dagger-android-processor:2.16"
    }


    val okhttp3 = Okhttp3

    object Okhttp3 {
        private const val okhttp3_version = "4.7.2"
        const val okhttp3 = "com.squareup.okhttp3:okhttp:${okhttp3_version}"
        const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:3.8.1"
        const val retrofit = "com.squareup.retrofit2:retrofit:2.9.0"
        const val retrofitConverterGson = "com.squareup.retrofit2:converter-gson:2.9.0"
        const val adapterRxjava = "com.squareup.retrofit2:adapter-rxjava:2.9.0"
        const val adapterRxjava2 = "com.squareup.retrofit2:adapter-rxjava2:2.3.0"
        const val converterCalars = "com.squareup.retrofit2:converter-scalars:2.9.0"
    }


    //拦截请求调试
    val stethoOkhttp3 = StethoOkhttp3

    object StethoOkhttp3 {
        private const val stetho_okhttp3_version = "1.5.0"
        const val stethoOkhttp3 = "com.facebook.stetho:stetho-okhttp3:${stetho_okhttp3_version}"
    }


    //拦截请求调试
    val stetho = Stetho

    object Stetho {
        private const val stetho_version = "1.5.0"
        const val stetho = "com.facebook.stetho:stetho:${stetho_version}"
    }

    const val nativecrashreport = "com.tencent.bugly:nativecrashreport:3.9.0"
    val crashwoodpecker = Crashwoodpecker

    object Crashwoodpecker {
        private const val crashwoodpecker_version = "2.1.1"
        const val crashwoodpecker = "me.drakeet.library:crashwoodpecker:${crashwoodpecker_version}"
    }


    val banner = Banner

    object Banner {
        const val banner = "com.youth.banner:banner:2.1.1"
    }

    val smarttablayout = Smarttablayout

    object Smarttablayout {
        const val smarttablayout =
            "com.ogaclejapan.smarttablayout:library:2.0.0@aar"
        const val smarttablayoutUtils =
            "com.ogaclejapan.smarttablayout:utils-v4:2.0.0@aar"
    }


    val mtwalle = Mtwalle

    //美团打包
    object Mtwalle {
        const val mtwalle = "com.meituan.android.walle:library:1.1.6"
    }


    val permissionsdispatcher = Permissionsdispatcher

    object Permissionsdispatcher {
        private const val permissionsdispatcher_version = "2.1.3"
        const val permissionsdispatcher =
            "com.github.hotchemi:permissionsdispatcher:${permissionsdispatcher_version}"
        const val permissionsdispatcherProcessor =
            "com.github.hotchemi:permissionsdispatcher-processor:${permissionsdispatcher_version}"
    }

    val arouter = Arouter

    object Arouter {
        private const val arouter_version = "1.5.2"
        const val arouterApi = "com.alibaba:arouter-api:$arouter_version"
        const val arouterCompiler = "com.alibaba:arouter-compiler:$arouter_version"
    }

    val tinker = Tinker

    object Tinker {
        private const val tinker_version = "1.9.14.18"
        const val tinkerLib = "com.tencent.tinker:tinker-android-lib:$tinker_version"
        const val tinkerLoader = "com.tencent.tinker:tinker-android-loader:$tinker_version"
        const val tinkerAno = "com.tencent.tinker:tinker-android-anno:$tinker_version"
        const val tinkerAnoSupport =
            "com.tencent.tinker:tinker-android-anno-support:$tinker_version"
    }

    val leakcanary = Leakcanary

    object Leakcanary {
        private const val leakcanary_version = "1.6.2"
        const val leakcanaryAnd = "com.squareup.leakcanary:leakcanary-android:$leakcanary_version"
        const val leakcanaryAndNoOp =
            "com.squareup.leakcanary:leakcanary-android-no-op:$leakcanary_version"
        const val leakcanarySuppFrag =
            "com.squareup.leakcanary:leakcanary-support-fragment:$leakcanary_version"

    }


    object Glide {
        const val glide = "com.github.bumptech.glide:glide:1.6.2"
    }

    object Lottie {
        const val lottie = "com.airbnb.android:lottie:3.4.4"
    }

    object Easypermissions {
        const val easypermissions = "pub.devrel:easypermissions:3.0.0"
    }


    object MmkvStatic {
        const val mmkvStatic = "com.tencent:mmkv-static:1.2.8"
    }

    object Relinker {
        const val relinker = "com.getkeepsafe.relinker:relinker:1.4.3"
    }

    object KotlinStdlib {
        const val kotlinStdlib = "org.jetbrains.kotlin:kotlin-stdlib:1.5.0"
    }

    object GoogleGson {
        const val googleGson = "com.google.code.gson:gson:2.8.8"
    }

    object Immersionbar {
        const val immersionbar = "com.gyf.immersionbar:immersionbar:3.0.0"
    }
    object Utilcodex {
        const val utilcodex = "  com.blankj:utilcodex:1.29.0"
    }

}