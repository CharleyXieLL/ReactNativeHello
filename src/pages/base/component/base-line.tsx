import * as React from 'react';
import {View} from 'react-native';
import {commonstyle} from '../../../styles/common-style';

const BaseLine = () => {
  return (
    <View
      style={[
        commonstyle.background_line,
        commonstyle.width_100,
        commonstyle.height_normal_line,
      ]}
    />
  );
};

export default BaseLine;
