package space.jiyun.coala.ui.question

import androidx.databinding.BindingConversion
import java.text.SimpleDateFormat
import java.util.*

@BindingConversion
fun convertDateToString(date : Date) : String
        = SimpleDateFormat("yyyy-MM-dd", Locale.KOREA).format(date)
