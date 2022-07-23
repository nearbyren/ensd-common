package ejiayou.common.http

import androidx.lifecycle.MutableLiveData
import ejiayou.common.module.base.BaseAppViewModel

/**
 * @author: lr
 * @created on: 2022/7/10 4:01 下午
 * @description:
 */
class TestViewModel : BaseAppViewModel() {
    private val repo by lazy { TestRepoImpl() }

    /**
     * 获取文章列表
     */
    fun getTestList() {
        launchOnUI {
            showLoadingView(true)
            repo.getTestList(1, 20)
                    .onCompletion { showLoadingView(false) }
                    .onSuccess {
                        showToast("获取测试成功")
                    }
                    .onFailure { code, msg ->
                        showToast(msg ?: "获取测试失败")
                    }
                    .onCatch { error ->
                        showToast(error.errorMsg)
                    }
        }
    }
}