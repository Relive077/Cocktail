package app.web.relive.domain.base.usecase

interface GeneralSuspendUseCase<Type, in Params> {

    suspend operator fun invoke(params: Params): Type

}