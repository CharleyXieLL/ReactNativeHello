import {HomeResponse} from '../../bean/main-res-bean';
import {homeHttp} from '../../request/api';
import {BasePresenter} from '../base/mvp/mvp-p';
import {HomeMvpView} from './home-v';
export class HomePresenter extends BasePresenter<HomeMvpView> {
  /**
   * 获取首页数据
   */
  async getHome() {
    let data: HomeResponse = await homeHttp();
    console.log(`data---->${data.advertising?.length}`);
    this.mview?.getHomeSuccess(data);
  }
}
