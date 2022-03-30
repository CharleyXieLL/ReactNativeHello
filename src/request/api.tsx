import requestAction, {METHOD, RequestOptions} from '.';
import {SendCodePostBean} from '../pages/detail/postbean/main-post-bean';

//发送验证码
export function sendCodeHttp(params: SendCodePostBean) {
  return requestAction(
    'verifyCode/login/send',
    new RequestOptions(METHOD.POST, params),
  );
}
