package com.example.daggerhilttest

import android.util.Log
import dagger.Component
import javax.inject.Inject

interface AnalyticsService {
    fun analyticsMethods()
}

/**
 * Dagger가 객체들을 자동으로 생성하고 의존성을 관리하려면, 객체들이 의존성을 어떠헥 주입받을지 Dagger에게 명시해주어야합니다.
 * Dagger는 객체가 의존성을 주입받는 방법으로 다음 2가지를 원합니다
 *
 * 1) 생성자를 통한 주입
 * 2) 멤버필드에 직접 주입
 *
 */
class AnalyticsServiceImpl @Inject constructor() : AnalyticsService {
    private val debugTag:String = javaClass.simpleName
    override fun analyticsMethods() {
        Log.d(debugTag, "analyticsMethods")
    }
}
