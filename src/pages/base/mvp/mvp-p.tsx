import {Presenter} from './presenter';
export abstract class BasePresenter<V> implements Presenter<V> {
  protected mview: V | undefined;

  bindMvpView(mvpView: V): void {
    this.mview = mvpView;
  }
}
