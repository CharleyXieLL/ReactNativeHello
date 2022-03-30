import * as React from 'react';
import {Button, Text, View} from 'react-native';
import {commonstyle} from '../../styles/common-style';
import {RouterScreen} from '../../router/index';
import BaseTitleScreen from '../base/base-title-screen';
import {DetailMvpView} from './detail-v';
import {DetailPresenter} from './detail-p';

class DetailScreen
  extends BaseTitleScreen<DetailMvpView, DetailPresenter>
  implements DetailMvpView
{
  protected init(): void {}

  sendCodeSuccess(): void {
    console.log('发送验证码成功');
  }

  showBaseToast(msg: string): void {
    this.showToast(msg);
  }

  protected bindPresenter(): DetailPresenter {
    return new DetailPresenter();
  }
  protected getMvpView(): DetailMvpView {
    return this;
  }

  protected getContent(): React.ReactElement<
    any,
    string | React.JSXElementConstructor<any>
  > {
    return (
      <View style={[commonstyle.flex_1, commonstyle.flex_center]}>
        <Text style={[commonstyle.font_color_body, commonstyle.font_size_body]}>
          Detail
        </Text>
        <Button
          title="显示吐司"
          onPress={() => {
            this.showToast('我是一个吐司');
          }}
        />

        <Button
          title="发送验证码"
          onPress={() => {
            this.presenter?.sendCode();
          }}
        />
      </View>
    );
  }

  protected getTitle(): RouterScreen {
    return RouterScreen.DETAIL;
  }
}

export default DetailScreen;
