import HomeScreen from '../home/index';
import MineScreen from '../mine/index';
import {createNativeStackNavigator} from '@react-navigation/native-stack';
import * as React from 'react';
import {View} from 'react-native';
import {commonstyle} from '../../styles/common-style';
import MainTabView from './component/main-tab-view';
import ProfileScreen from '../profile/index';
import {RouterScreen} from '../../router';
import NavigationService from '../../router/NavigationService';
import BaseScreen from '../base/base-screen';
import {MainMvpView} from './main-view';
import {MainPresenter} from './main-p';

const MainStack = createNativeStackNavigator();

type MainScreenProps = {};

class MainScreen
  extends BaseScreen<MainMvpView, MainPresenter>
  implements MainMvpView
{
  protected init(): void {}

  protected bindPresenter(): MainPresenter {
    return new MainPresenter();
  }

  protected getMvpView(): MainMvpView {
    return this;
  }

  render(): React.ReactNode {
    return (
      <View style={[commonstyle.flex_1, commonstyle.position_relative]}>
        <View style={[commonstyle.flex_1]}>
          <MainStack.Navigator
            screenOptions={{headerShown: false, animation: 'none'}}>
            <MainStack.Screen name={RouterScreen.HOME} component={HomeScreen} />
            <MainStack.Screen
              name={RouterScreen.PROFILE}
              component={ProfileScreen}
            />
            <MainStack.Screen name={RouterScreen.MINE} component={MineScreen} />
          </MainStack.Navigator>
        </View>
        <MainTabView
          style={[commonstyle.position_absolute, commonstyle.position_bottom_0]}
          onClickTab={(type: RouterScreen) => {
            NavigationService.navigate(type);
          }}
        />
      </View>
    );
  }
}

export default MainScreen;
