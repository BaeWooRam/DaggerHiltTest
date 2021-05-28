package com.example.daggerhilttest

import android.content.Context
import dagger.BindsInstance
import dagger.Component

/**
 * 외부에서 객체를 사용할 때에는 모듈로부터 직접 받는것이 아니라, 컴포넌트라는 인터페이스를 통하여 객체를 제공받아야합니다.
 * 즉, 컴포넌트는 외부에서 객체를 제공받기 위해 사용하는 인터페이스입니다.
 * Dagger 라이브러리는 앱을 컴파일할 때, 이 어노테이션이 붙은 인터페이스들의 실제구현체 클래스를 자동생성해 줍니다.
 */
@Component(dependencies = [LoginModuleDependencies::class])
interface LoginComponent {

    fun inject(activity: MainActivity)

    /**
     * 객체를 생성할 때, 모듈에서 제공(@Provider)하는 것만으로는 인자를 주입하기 어려운 경우가 종종 있습니다.
     * 가장 쉬운 예로는 안드로이드에서 객체 생성에 Context 객체가 필요한 경우 이빈다. Context는 모듈에서 생성할 수 없기 때문에,
     * 이미 생성된 객체를 밖에서 받아야합니다
     */
    @Component.Builder
    interface Builder {
        fun context(@BindsInstance context: Context): Builder
        fun appDependencies(loginModuleDependencies: LoginModuleDependencies): Builder
        fun build(): LoginComponent
    }


    /*
        // 실제 사용 예
        class TestApplication: Application() {

            override fun onCreate() {
                super.onCreate()
                DaggerLoginComponent.builder()
                    .context(this)
                    .appDependencies(EntryPointsAccessors.fromApplication(applicationContext, LoginModuleDependencies::class.java))
                    .build()
                    .inject(this)
            }
        }
     */
}