package io.arrowkt.example

@InlineSerializable
data class UserId(val value : String) {
    companion object {
        fun unique() =
            UserId(java.util.UUID.randomUUID().toString())
    }

    override fun toString(): String = "UserId($value)"
}
