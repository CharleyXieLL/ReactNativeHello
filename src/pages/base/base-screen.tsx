import * as React from 'react';
import {BackHandler, Platform} from 'react-native';
import Toast from 'react-native-root-toast';
import {PlatformName} from '../../type';
import {BasePresenter} from './mvp/mvp-p';
import {BaseMvpView} from './mvp/mvp-v';
import {RouterName} from '../../router/router-name';
import {RouterScreen} from '../../router/index';

const backEventName = 'hardwareBackPress';

abstract class BaseScreen<
  V extends BaseMvpView,
  P extends BasePresenter<V>,
  PROPS = {},
  STATE = {},
> extends React.Component<PROPS, STATE> {
  protected presenter: P | undefined;

  private lastBackPressedTime: number = 0;

  componentDidMount() {
    this.setPresenter();
    this.init();
    this.registerBackListener();
  }

  componentWillUnmount() {
    if (Platform.OS === PlatformName.ANDROID) {
      BackHandler.removeEventListener(backEventName, this.onBackClicked);
    }
  }

  protected abstract init(): void;
  protected abstract bindPresenter(): P;
  protected abstract getMvpView(): V;

  private setPresenter() {
    if (!this.presenter) {
      this.presenter = this.bindPresenter();
    }
    this.presenter.bindMvpView(this.getMvpView());
  }

  public registerBackListener() {
    if (Platform.OS === PlatformName.ANDROID) {
      if (
        RouterName.routerName === RouterScreen.MAIN ||
        RouterName.routerName === RouterScreen.PROFILE ||
        RouterName.routerName === RouterScreen.MINE ||
        RouterName.routerName === RouterScreen.HOME
      ) {
        BackHandler.addEventListener(backEventName, this.onBackClicked);
      } else {
        BackHandler.removeEventListener(backEventName, this.onBackClicked);
      }
    }
  }

  onBackClicked = () => {
    if (
      this.lastBackPressedTime &&
      this.lastBackPressedTime + 1500 > Date.now()
    ) {
      return false;
    }
    this.lastBackPressedTime = Date.now();
    this.showToast('再按一次退出程序');
    return true;
  };

  private options = {
    duration: Toast.durations.SHORT,
    position: -70,
    shadow: true,
    animation: true,
    hideOnPress: true,
    delay: 0,
    onShow: () => {
      // calls on toast\`s appear animation start
    },
    onShown: () => {
      // calls on toast\`s appear animation end.
    },
    onHide: () => {
      // calls on toast\`s hide animation start.
    },
    onHidden: () => {
      // calls on toast\`s hide animation end.
    },
  };

  public showToast = (message: string) => {
    this.options.duration = Toast.durations.SHORT;
    Toast.show(message, this.options);
  };

  public showToastLong = (message: string) => {
    this.options.duration = Toast.durations.LONG;
    Toast.show(message, this.options);
  };
}

export default BaseScreen;
