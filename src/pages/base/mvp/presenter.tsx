export interface Presenter<V> {
  bindMvpView(mvpView: V): void;
}
