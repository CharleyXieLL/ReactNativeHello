/* eslint-disable react-native/no-inline-styles */
import BaseScreen from '../base/base-screen';
import {SplashMvpView} from './splash-v';
import {SplashPresenter} from './splash-p';
import React, {ReactNode} from 'react';
import {Text, View} from 'react-native';
import {commonstyle} from '../../styles/common-style';
import NavigationService from '../../router/NavigationService';
import {RouterScreen} from '../../router/index';

export default class SplashScreen
  extends BaseScreen<SplashMvpView, SplashPresenter>
  implements SplashMvpView
{
  protected init(): void {
    setTimeout(() => {
      NavigationService.replace(RouterScreen.MAIN);
    }, 2000);
  }
  protected bindPresenter(): SplashPresenter {
    return new SplashPresenter();
  }
  protected getMvpView(): SplashMvpView {
    return this;
  }

  render(): ReactNode {
    return (
      <View
        style={[
          commonstyle.flex_1,
          commonstyle.background_white,
          commonstyle.position_relative,
        ]}>
        <View
          style={[
            commonstyle.width_100,
            commonstyle.flex_v_center,
            commonstyle.position_absolute,
            {bottom: 70},
          ]}>
          <Text style={[commonstyle.font_color_black, {fontSize: 30}]}>
            React Demo
          </Text>
        </View>
      </View>
    );
  }
}
