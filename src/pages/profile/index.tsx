import * as React from 'react';
import {View, Text} from 'react-native';
import {commonstyle} from '../../styles/common-style';
import BaseScreen from '../base/base-screen';
import {ProfileMvpView} from './profile-v';
import {ProfilePresenter} from './profile-p';

class ProfileScreen
  extends BaseScreen<ProfileMvpView, ProfilePresenter>
  implements ProfileMvpView
{
  protected init(): void {}
  protected bindPresenter(): ProfilePresenter {
    return new ProfilePresenter();
  }
  protected getMvpView(): ProfileMvpView {
    return this;
  }

  render(): React.ReactNode {
    return (
      <View style={[commonstyle.flex_1, commonstyle.flex_center]}>
        <Text>Profile Screen</Text>
      </View>
    );
  }
}

export default ProfileScreen;
