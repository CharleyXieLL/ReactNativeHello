import BaseScreen from '../base/base-screen';
import {LoginMvpView} from './login-v';
import {LoginPresenter} from './login-p';

export default class LoginScreen
  extends BaseScreen<LoginMvpView, LoginPresenter>
  implements LoginMvpView
{
  protected init(): void {}
  protected bindPresenter(): LoginPresenter {
    return new LoginPresenter();
  }
  protected getMvpView(): LoginMvpView {
    return this;
  }
}
