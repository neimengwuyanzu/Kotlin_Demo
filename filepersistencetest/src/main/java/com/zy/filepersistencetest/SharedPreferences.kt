import android.content.SharedPreferences

/**
 * 书里说如果上一节的高级用法学会了 这个看的很明白
 * 这尼玛就尴尬了  我看的迷迷糊糊
 */
fun SharedPreferences.open(block:SharedPreferences.Editor.() -> Unit){
    val editor = edit()
    editor.block()
    editor.apply()
}