package jp.cordea.eyes

import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface MainActivityModule {
    @ContributesAndroidInjector(
        modules = [
            MainActivityBindModule::class
        ]
    )
    fun contributeMainActivity(): MainActivity
}

@Module
interface MainActivityBindModule {
    @Binds
    fun bindView(activity: MainActivity): MainContract.View

    @Binds
    fun bindPresenter(presenter: MainPresenter): MainContract.Presenter
}
