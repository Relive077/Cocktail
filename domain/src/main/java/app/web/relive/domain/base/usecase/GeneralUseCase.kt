package app.web.relive.domain.base.usecase

interface GeneralUseCase<Type, in Params> {

    operator fun invoke(params: Params): Type

}