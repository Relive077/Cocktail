package app.web.relive.domain.base.mapper

interface Mapper<in LeftObject, out RightObject> {

    fun mapLeftToRight(obj: LeftObject): RightObject

}