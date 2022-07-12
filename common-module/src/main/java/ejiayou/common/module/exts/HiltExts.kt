//package ejiayou.common.module.exts
//
//import android.content.Context
//import ejiayou.common.module.utils.AppUtils
//import ejiayou.common.module.utils.LogUtils
//import ejiayou.common.module.utils.ToastUtils
//
//
//
//inline fun <reified T> fromApplicationSafe(context: Context): T? {
//    return try {
//        EntryPointAccessors.fromApplication(context, T::class.java)
//    } catch (e: IllegalStateException) {
//        if (AppUtils.isDebug()) {
//            ToastUtils.showToast(
//                context,
//                "IllegalStateException:The implementation of ${T::class.simpleName} cannot be found",
//                true
//            )
//        }
//        LogUtils.e("IllegalStateException:The implementation of ${T::class.simpleName} cannot be found \n ${e.stackTrace}")
//        null
//    } catch (e: Exception) {
//        if (AppUtils.isDebug()) {
//            ToastUtils.showToast(
//                context,
//                "Exception:The implementation of ${T::class.simpleName} cannot be found",
//                true
//            )
//        }
//        LogUtils.e("Exception:The implementation of ${T::class.simpleName} cannot be found \n ${e.stackTrace}")
//        null
//    }
//}