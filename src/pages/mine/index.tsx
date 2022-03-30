import * as React from 'react';
import {View, Text} from 'react-native';
import {commonstyle} from '../../styles/common-style';
import BaseScreen from '../base/base-screen';
import {MineMvpView} from './mine-v';
import {MinePresenter} from './mine-p';

class MineScreen
  extends BaseScreen<MineMvpView, MinePresenter>
  implements MineMvpView
{
  protected init(): void {}
  protected bindPresenter(): MinePresenter {
    return new MinePresenter();
  }
  protected getMvpView(): MineMvpView {
    return this;
  }

  render(): React.ReactNode {
    return (
      <View style={[commonstyle.flex_1, commonstyle.flex_center]}>
        <Text>Mine Screen</Text>
      </View>
    );
  }
}

export default MineScreen;
