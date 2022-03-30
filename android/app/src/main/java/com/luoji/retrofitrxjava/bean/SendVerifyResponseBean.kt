package com.luoji.retrofitrxjava.bean

/**
 * Author:Ace
 * Date:On 2022/1/14
 */
data class SendVerifyResponseBean(var sendVerifyCodeSuccessVo:SendVerifyCode) {}

data class SendVerifyCode(var sendSuccess:Boolean,var effectiveSeconds:Int){}