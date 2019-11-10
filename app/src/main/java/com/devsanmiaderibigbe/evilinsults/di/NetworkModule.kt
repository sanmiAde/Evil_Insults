package com.devsanmiaderibigbe.evilinsults.di

import android.app.Application
import com.devsanmiaderibigbe.evilinsults.utils.AppConstants
import com.devsanmiaderibigbe.evilinsults.utils.AppScheduler
import com.devsanmiaderibigbe.evilinsults.di.scope.ApplicationScope
import com.devsanmiaderibigbe.evilinsults.remote.EvilInsultService
import com.devsanmiaderibigbe.evilinsults.remote.Repository
import com.devsanmiaderibigbe.evilinsults.remote.RepositoryImp
import com.squareup.moshi.Moshi
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

@Module
class NetworkModule {

    @Provides
    @ApplicationScope
    internal fun provideOkHttpChace(application: Application): Cache {
        val cacheSize = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize.toLong())
    }

    @Provides
    @ApplicationScope
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
        return loggingInterceptor
    }

    @Provides
    @ApplicationScope
    internal fun providesMoshi(): Moshi {
        return Moshi.Builder().build()
    }

    @Provides
    @ApplicationScope
    internal fun provideOkHttpClient(
        cache: Cache,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .cache(cache)
            .readTimeout(60, TimeUnit.SECONDS)
            .connectTimeout(60, TimeUnit.SECONDS)
            .build()
    }

    @Provides
    @ApplicationScope
    internal fun provideRetrofit(moshi: Moshi, okHttpClient: OkHttpClient, appScheduler: AppScheduler): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(appScheduler.io()))
            .baseUrl(AppConstants.API_BASE_URL)
            .client(okHttpClient)
            .build()
    }

    @Provides
    @ApplicationScope
    fun providesEvilInsultService(retrofit: Retrofit) : EvilInsultService = retrofit.create(EvilInsultService::class.java)


    @ApplicationScope
    @Provides
    fun providesRepository( evilInsultService: EvilInsultService) : Repository{
        return RepositoryImp(evilInsultService)
    }

    @Provides
    @ApplicationScope
    fun appScheduler() : AppScheduler {
        return AppScheduler()
    }
}