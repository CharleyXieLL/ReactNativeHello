package com.luoji.retrofitrxjava

import androidx.databinding.ObservableField

/**
 * Author:Ace
 * Date:On 2022/1/5
 */
data class ObserverMainModel(
    var status:ObservableField<Int> = ObservableField<Int>().apply { set(0) }
) {
}