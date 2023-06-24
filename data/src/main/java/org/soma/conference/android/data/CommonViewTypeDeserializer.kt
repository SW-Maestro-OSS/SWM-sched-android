package org.soma.conference.android.data

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import org.soma.conference.domain.viewtype.CommonViewTypes
import org.soma.conference.domain.viewtype.CommonViewVO
import java.lang.reflect.Type

class CommonViewTypeDeserializer : JsonDeserializer<CommonViewVO> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement?, typeOfT: Type, context: JsonDeserializationContext
    ): CommonViewVO {
        val jsonObject = json?.asJsonObject ?: throw IllegalArgumentException("Json Parsing 실패")
        val viewType = jsonObject.get("viewType").asString
        val content = jsonObject.get("content").asJsonObject
        val type = CommonViewTypes.findViewTypeClassType(viewType)

        return CommonViewVO(viewType, Gson().fromJson(content, type))
    }
}