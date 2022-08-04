package com.example.ewalle.di.module

import com.example.ewalle.data.repository.AuthRepositoryImpl
import com.example.ewalle.data.repository.DateTimeRepositoryImpl
import com.example.ewalle.data.repository.ServiceRepositoryImpl
import com.example.ewalle.data.repository.TemperatureRepositoryImpl
import com.example.ewalle.domain.repository.AuthRepository
import com.example.ewalle.domain.repository.DateTimeRepository
import com.example.ewalle.domain.repository.ServiceRepository
import com.example.ewalle.domain.repository.TemperatureRepository
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
        fun provideGetServicesUseCase(repository: ServiceRepository): GetServicesMainScreenUseCase =
            GetServicesMainScreenUseCase(repository)
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

}