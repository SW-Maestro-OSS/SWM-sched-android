package org.soma.conference.domain.viewtype

import java.lang.reflect.Type

enum class CommonViewTypes(
    val viewType: String, private val viewTypeClassType: Type
) {
    TITLE_IMAGE("AViewType", AViewVO::class.java),
    TITLE("BViewType", BViewVO::class.java);

    companion object {
        fun findViewTypeClassType(viewType: String): Type {
            for (enumValue in CommonViewTypes.values()) {
                if (enumValue.viewType == viewType) {
                    return enumValue.viewTypeClassType
                }
            }
            throw IllegalStateException("Can't find viewType. Please check CommonViewTypes for the ViewType you want to use.")
        }

        fun findOrdinalFromViewType(viewType: String): Int {
            for (enumValue in CommonViewTypes.values()) {
                if (enumValue.viewType == viewType) {
                    return enumValue.ordinal
                }
            }
            throw IllegalStateException("Can't find viewType ordinal. Please check CommonViewTypes for the ViewType you want to use.")
        }
    }
}