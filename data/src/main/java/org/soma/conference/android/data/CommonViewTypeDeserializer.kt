package org.soma.conference.android.data

import com.google.gson.Gson
import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonParseException
import org.soma.conference.domain.viewtype.CommonViewTypes
import org.soma.conference.domain.viewtype.CommonListItemVO
import java.lang.reflect.Type

class CommonViewTypeDeserializer : JsonDeserializer<CommonListItemVO> {
    @Throws(JsonParseException::class)
    override fun deserialize(
        json: JsonElement?, typeOfT: Type, context: JsonDeserializationContext
    ): CommonListItemVO {
        val jsonObject = json?.asJsonObject ?: throw IllegalArgumentException("Json Parsing 실패")
        val viewType = jsonObject.get("viewType").asString
        val decidedViewType = CommonViewTypes.findViewTypeClassType(viewType)
        val content = jsonObject.get("content").asJsonObject

        return CommonListItemVO(viewType, Gson().fromJson(content, decidedViewType))
    }
}