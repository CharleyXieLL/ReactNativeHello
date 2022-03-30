import * as React from 'react';
import {View, Text, Button} from 'react-native';
import {commonstyle} from '../../styles/common-style';
import {RouterScreen} from '../../router';
import BaseScreen from '../base/base-screen';
import {HomeMvpView} from './home-v';
import {HomePresenter} from './home-p';
import NavigationService from '../../router/NavigationService';

class HomeScreen
  extends BaseScreen<HomeMvpView, HomePresenter>
  implements HomeMvpView
{
  protected init(): void {}
  protected bindPresenter(): HomePresenter {
    return new HomePresenter();
  }
  protected getMvpView(): HomeMvpView {
    return this;
  }

  render(): React.ReactNode {
    return (
      <View style={[commonstyle.flex_1, commonstyle.flex_center]}>
        <Text>Home Screen</Text>
        <Button
          title={'点击去往详情页'}
          onPress={() => {
            NavigationService.navigate(RouterScreen.DETAIL);
          }}
        />
      </View>
    );
  }
}

export default HomeScreen;
