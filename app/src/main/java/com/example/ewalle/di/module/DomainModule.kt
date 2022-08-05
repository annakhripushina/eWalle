package com.example.ewalle.di.module

import android.content.Context
import com.example.ewalle.data.repository.*
import com.example.ewalle.domain.repository.*
import com.example.ewalle.domain.usecase.*
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
interface DomainModule {

    companion object {
        @Singleton
        @Provides
        fun provideGetDateTimeUseCase(repository: DateTimeRepository): GetDateTimeUseCase =
            GetDateTimeUseCase(repository)

        @Singleton
        @Provides
        fun provideGetTemperatureUseCase(repository: TemperatureRepository): GetTemperatureUseCase =
            GetTemperatureUseCase(repository)

        @Singleton
        @Provides
        fun provideSignInUserUseCase(repository: AuthRepository): SignInUserUseCase =
            SignInUserUseCase(repository)

        @Singleton
        @Provides
        fun provideCreateUserUseCase(repository: AuthRepository): CreateUserUseCase =
            CreateUserUseCase(repository)

        @Singleton
        @Provides
        fun provideJoinForFreeUseCase(repository: AuthRepository): JoinForFreeUseCase =
            JoinForFreeUseCase(repository)

        @Singleton
        @Provides
        fun provideGetServicesUseCase(
            repository: ServiceRepository,
            context: Context
        ): GetServicesMainScreenUseCase =
            GetServicesMainScreenUseCase(repository, context)

        @Singleton
        @Provides
        fun provideGetUserUseCase(repository: UserDataRepository): GetUserUseCase =
            GetUserUseCase(repository)

        @Singleton
        @Provides
        fun provideGetBalanceUseCase(repository: UserDataRepository): GetBalanceUseCase =
            GetBalanceUseCase(repository)

        @Singleton
        @Provides
        fun provideGetFriendsUseCase(repository: UserDataRepository): GetFriendsUseCase =
            GetFriendsUseCase(repository)


    }

    @Singleton
    @Binds
    fun bindDateTimeRepository(impl: DateTimeRepositoryImpl): DateTimeRepository

    @Singleton
    @Binds
    fun bindTemperatureRepository(impl: TemperatureRepositoryImpl): TemperatureRepository

    @Singleton
    @Binds
    fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    @Singleton
    @Binds
    fun bindServiceRepository(impl: ServiceRepositoryImpl): ServiceRepository

    @Singleton
    @Binds
    fun bindUserDataRepository(impl: UserDataRepositoryImpl): UserDataRepository

}