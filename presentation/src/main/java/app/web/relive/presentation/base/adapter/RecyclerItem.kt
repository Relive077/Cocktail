package app.web.relive.presentation.base.adapter

interface RecyclerItem {
    val idDrink: String?
    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
}