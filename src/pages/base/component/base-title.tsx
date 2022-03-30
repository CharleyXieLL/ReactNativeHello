import * as React from 'react';
import {Image, Text, TouchableHighlight, View, Platform} from 'react-native';
import {commonstyle} from '../../../styles/common-style';
import BaseLine from './base-line';
import {ImagePathMain} from '../../../utils/ImagePath';
import {commoncolor} from '../../../styles/common-color';
import NavigationService from '../../../router/NavigationService';
import {PlatformName} from '../../../type/index';

type BaseTitleProps = {
  title: string;
};
const BaseTitle = (props: BaseTitleProps) => {
  const showTitle = () => {
    return (
      <View
        style={[commonstyle.height_android_bar, commonstyle.background_white]}
      />
    );
  };

  return (
    <View style={[commonstyle.flex_v]}>
      {Platform.OS === PlatformName.ANDROID ? showTitle() : {}}
      <View
        style={[
          commonstyle.width_100,
          commonstyle.flex_v,
          commonstyle.height_main_title,
          commonstyle.position_relative,
        ]}>
        <View
          style={[
            commonstyle.flex_1,
            commonstyle.background_white,
            commonstyle.flex_center,
          ]}>
          <Text
            style={[commonstyle.font_size_title, commonstyle.font_color_black]}>
            {props.title}
          </Text>
        </View>
        <BaseLine />
        <TouchableHighlight
          underlayColor={commoncolor.white}
          onPress={() => {
            NavigationService.goBack();
          }}
          style={[
            commonstyle.wh_base_arrow,
            commonstyle.flex_center,
            commonstyle.position_absolute,
            commonstyle.position_left_0,
          ]}>
          <Image
            source={ImagePathMain.image_arrow_back_black}
            style={[commonstyle.image_wh_base_arrow]}
          />
        </TouchableHighlight>
      </View>
    </View>
  );
};

export default BaseTitle;
