import {sendCodeHttp} from '../../request/api';
import {BasePresenter} from '../base/mvp/mvp-p';
import {DetailMvpView} from './detail-v';
import {SendCodePostBean, SendCodeResponse} from './postbean/main-post-bean';
export class DetailPresenter extends BasePresenter<DetailMvpView> {
  /**
   * 发送验证码
   */
  async sendCode() {
    let data: SendCodeResponse = await sendCodeHttp(
      new SendCodePostBean('6366532525'),
    );
    console.log(`data---->${data.sendVerifyCodeSuccessVo?.effectiveSeconds}`);
    this.mview?.sendCodeSuccess();
  }
}
