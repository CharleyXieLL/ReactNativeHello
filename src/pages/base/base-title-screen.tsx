import BaseScreen from './base-screen';
import * as React from 'react';
import {View} from 'react-native';
import {commonstyle} from '../../styles/common-style';
import BaseTitle from './component/base-title';
import {RouterScreen} from '../../router';
import {BasePresenter} from './mvp/mvp-p';
import {BaseMvpView} from './mvp/mvp-v';

abstract class BaseTitleScreen<
  V extends BaseMvpView,
  P extends BasePresenter<V>,
> extends BaseScreen<V, P> {
  protected abstract getContent(): React.ReactElement;
  protected abstract getTitle(): RouterScreen;
  render(): React.ReactNode {
    return (
      <View style={[commonstyle.flex_1, commonstyle.flex_v]}>
        <BaseTitle title={this.getTitle()} />
        {this.getContent()}
      </View>
    );
  }
}

export default BaseTitleScreen;
