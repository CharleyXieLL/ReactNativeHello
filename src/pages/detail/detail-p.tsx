import {homeHttp} from '../../request/api';
import {BasePresenter} from '../base/mvp/mvp-p';
import {DetailMvpView} from './detail-v';
import {HomeResponse} from './postbean/main-post-bean';
export class DetailPresenter extends BasePresenter<DetailMvpView> {
  /**
   * 获取首页数据
   */
  async getHome() {
    let data: HomeResponse = await homeHttp();
    console.log(`data---->${data.advertising?.length}`);
    this.mview?.getHomeSuccess(data);
  }
}
