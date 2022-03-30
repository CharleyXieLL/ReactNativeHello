import {BaseMvpView} from '../base/mvp/mvp-v';
import {HomeResponse} from './postbean/main-post-bean';
export interface DetailMvpView extends BaseMvpView {
  getHomeSuccess(homeData: HomeResponse): void;
}
