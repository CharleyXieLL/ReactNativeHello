package com.luoji.httpsdata

import org.json.JSONException
import org.json.JSONObject

/**
 *Author:Ace
 *Date:On 2021/9/1
 */
object ResponseUtil {
  fun getMap(jsonString: String?): HashMap<String, Any>? {
    val jsonObject: JSONObject
    try {
      jsonObject = JSONObject(jsonString)
      val keyIter: Iterator<String> = jsonObject.keys()
      var key: String
      var value: Any
      val valueMap = HashMap<String, Any>()
      while (keyIter.hasNext()) {
        key = keyIter.next()
        value = jsonObject[key] as Any
        valueMap[key] = value
      }
      return valueMap
    } catch (e: JSONException) {
      e.printStackTrace()
    }
    return null
  }
}