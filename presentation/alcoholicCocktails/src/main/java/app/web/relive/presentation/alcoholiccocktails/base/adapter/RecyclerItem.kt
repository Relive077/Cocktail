package app.web.relive.presentation.alcoholiccocktails.base.adapter

interface RecyclerItem {
    val id: String?
    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
}