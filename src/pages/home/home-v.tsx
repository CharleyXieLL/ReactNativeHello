import {HomeResponse} from '../../bean/main-res-bean';
import {BaseMvpView} from '../base/mvp/mvp-v';
export interface HomeMvpView extends BaseMvpView {
  getHomeSuccess(homeData: HomeResponse): void;
}
