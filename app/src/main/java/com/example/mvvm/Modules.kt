package com.example.mvvm


import com.example.mvvm.repositories.NicePlaceRepository
import com.example.mvvm.viewmodels.MainActivityViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module



const val BASE_URL = "https://vnexpress.net/"
val viewModelModule = module {
    viewModel {
        MainActivityViewModel(get())
    }
}
val appModule = module {

    single<ApiHelper> {
        return@single ApiHelperImpl()
    }
}
val repositoryModule = module {
    single {
        NicePlaceRepository(get())
    }
}







